package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LecturerPopQuizActivity extends JKActivity {

    private LecturerPopQuizWireframe wireframe;
    private LecturerPopQuizInteractor interactor;
    private TextView popQuizNameLabel;
    private TextView groupNameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_pop_quiz);
        wireframe = new LecturerPopQuizWireframe(this);
        interactor = new LecturerPopQuizInteractor(new RequestSender(getApplicationContext()), getIntent());
        popQuizNameLabel = (TextView) findViewById(R.id.popQuizName);
        groupNameLabel = (TextView) findViewById(R.id.groupName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        popQuizNameLabel.setText(interactor.popQuizName);
        groupNameLabel.setText(interactor.groupName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        interactor.onPause();
    }

    public void onStopPopQuiz(View v) {
        interactor.stopPopQuiz(v, new StandardGenericResponseHandler<Boolean>() {
            @Override
            public void onSuccess(Boolean responseObject) {
                super.onSuccess(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }
}
