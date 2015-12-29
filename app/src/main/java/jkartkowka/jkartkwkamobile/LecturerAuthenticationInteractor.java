package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.ChangePopQuizStateRequest;
import jkartkowka.jkartkwkamobile.network.requests.SecretRequest;

public class LecturerAuthenticationInteractor extends JKInteractor {

    private final int groupId;
    private final int popQuizId;
    private final Activity currentActivity;

    public LecturerAuthenticationInteractor(RequestSender requestSender, Intent intent, Activity activity) {
        super(requestSender);
        groupId = intent.getIntExtra("groupID", -1);
        popQuizId = intent.getIntExtra("popQuizID", -1);
        currentActivity = activity;
    }

    public void getSecret(final StandardGenericResponseHandler<Integer> responseHandler) {
        SecretRequest request = new SecretRequest(groupId, popQuizId, new StandardGenericResponseHandler<Integer>() {
            @Override
            public void onSuccess(Integer secretId) {
                Integer drawableId = getDrawableId(secretId);
                responseHandler.onSuccess(drawableId);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                responseHandler.onFailure(error);
            }
        });

        requestSender.sendRequest(request);
    }

    private Integer getDrawableId(Integer secretId) {
        return currentActivity.getResources().getIdentifier("symbol" + secretId, "drawable", currentActivity.getPackageName());
    }

    public void activatePopQuiz(StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        ChangePopQuizStateRequest request = new ChangePopQuizStateRequest(groupId, popQuizId, responseHandler);

        requestSender.sendRequest(request);
    }
}
