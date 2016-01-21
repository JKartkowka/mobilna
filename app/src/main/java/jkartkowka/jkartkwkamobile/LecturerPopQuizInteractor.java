package jkartkowka.jkartkwkamobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.View;

import jkartkowka.jkartkwkamobile.model.PopQuizState;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.ChangePopQuizStateRequest;

public class LecturerPopQuizInteractor extends JKInteractor {

    public static final int PROGRESS_BAR_MAX_TIME = 60;
    public final String groupName;
    public final String popQuizName;
    private Thread thread;
    private boolean stopped;
    private final int groupId;
    private final int popQuizId;

    public LecturerPopQuizInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        this.groupName = intent.getStringExtra("groupName");
        this.popQuizName = intent.getStringExtra("popQuizName");
        stopped = false;
        groupId = intent.getIntExtra("groupID", -1);
        popQuizId = intent.getIntExtra("popQuizID", -1);
    }

    public void stopPopQuiz(final View v, StandardGenericResponseHandler<Boolean> standardGenericResponseHandler) {
        final ProgressDialog progressBar = createProgressDialog(v);
        progressBar.show();

        createProgressBarThreadIfNeeded(progressBar, standardGenericResponseHandler);
        stopped = false;
        thread.start();
    }

    private void createProgressBarThreadIfNeeded(final ProgressDialog progressBar, final StandardGenericResponseHandler<Boolean> standardGenericResponseHandler) {
        if (thread != null) {
            return;
        }
        thread = new Thread() {
            @Override
            public void run() {
                int seconds = 0;

                while (seconds < PROGRESS_BAR_MAX_TIME && !stopped) {
                    try {
                        sleep(1000);
                        seconds++;
                        progressBar.setProgress(seconds);
                        System.out.println(seconds);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (!stopped) {
                    sendStopRequest(progressBar, standardGenericResponseHandler);
                } else {
                    progressBar.dismiss();
                }
            }
        };
    }

    @NonNull
    private ProgressDialog createProgressDialog(View v) {
        final ProgressDialog progressBar = new ProgressDialog(v.getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("Kończenie kartkówki");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(PROGRESS_BAR_MAX_TIME);
        return progressBar;
    }

    private void sendStopRequest(final ProgressDialog progressBar, final StandardGenericResponseHandler<Boolean> standardGenericResponseHandler) {
        ChangePopQuizStateRequest request = new ChangePopQuizStateRequest(groupId, popQuizId, PopQuizState.PQSClosed, new StandardGenericResponseHandler<Pair<String, String>>() {
            @Override
            public void onSuccess(Pair<String, String> responseObject) {
                progressBar.dismiss();
                standardGenericResponseHandler.onSuccess(true);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                progressBar.dismiss();
                standardGenericResponseHandler.onFailure(error);
            }
        });

        requestSender.sendRequest(request);
    }

    public void onPause() {
        stopped = true;
        thread = null;
    }
}
