package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LecturerAuthenticationActivity extends JKActivity {

    private LecturerAuthenticationInteractor interactor;
    private LecturerStandardAuthenticationWireframe wireframe;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        interactor = new LecturerAuthenticationInteractor(new RequestSender(getApplicationContext()), getIntent(), this);
        wireframe = new LecturerStandardAuthenticationWireframe(this);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.getSecret(new StandardGenericResponseHandler<Integer>() {
            @Override
            public void onSuccess(Integer drawableId) {
                imageView.setImageResource(drawableId);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    public void onConfirmationClick(View v) {
        interactor.activatePopQuiz(new StandardGenericResponseHandler<Pair<String, String>>() {
            @Override
            public void onSuccess(Pair<String, String> responseObject) {
                wireframe.navigateToPopQuiz(responseObject.first, responseObject.second);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    public void onDisproveClick(View v) {
        wireframe.navigateToCustomConfirmation(interactor.groupId, interactor.popQuizId);
    }
}
