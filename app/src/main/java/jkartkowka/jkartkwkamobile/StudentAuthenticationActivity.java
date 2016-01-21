package jkartkowka.jkartkwkamobile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class StudentAuthenticationActivity extends StudentActivity {

    private StudentAuthenticationWireframe wireframe;
    private StudentAuthenticationInteractor interactor;
    private ImageView authSymbolImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentauthentication);
        wireframe = new StudentAuthenticationWireframe(this);
        interactor = new StudentAuthenticationInteractor(new RequestSender(getApplicationContext()), this, getApplicationContext(), getIntent());
        authSymbolImageView = (ImageView) findViewById(R.id.authSymbol);
        interactor.getSecret(new StandardGenericResponseHandler<Integer>() {
            @Override
            public void onSuccess(Integer drawableId) {
                authSymbolImageView.setImageResource(drawableId);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    public void onStartPopQuizClick(View v) {
        if (!interactor.isAirplaneModeOn()) {
            makeAirplaneModeToast();
            return;
        }
        final ProgressDialog dialog = ProgressDialog.show(StudentAuthenticationActivity.this, "", "Ładowanie", true);
        interactor.isActivePopQuiz(new StandardGenericResponseHandler<Boolean>() {
            @Override
            public void onSuccess(Boolean responseObject) {
                dialog.dismiss();
                if (responseObject) {
                    wireframe.startPopQuiz();
                } else {
                    makeToast("Zaczekaj aż prowadzący zweryfikuje wszystkich studentów");
                }
            }

            @Override
            public void onFailure(ErrorHandler error) {
                dialog.dismiss();
                makeToast(error.toString());
            }
        });
    }
}
