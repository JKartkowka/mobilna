package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LecturerAuthenticationActivity extends JKActivity {

    private LecturerAuthenticationInteractor interactor;
    private LecturerAuthenticationWireframe wireframe;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        interactor = new LecturerAuthenticationInteractor(new RequestSender(getApplicationContext()), getIntent(), this);
        wireframe = new LecturerAuthenticationWireframe(this);
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
        wireframe.navigateToPopQuiz();
    }
}
