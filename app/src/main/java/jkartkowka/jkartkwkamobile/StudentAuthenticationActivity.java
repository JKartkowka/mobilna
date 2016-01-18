package jkartkowka.jkartkwkamobile;

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
        interactor = new StudentAuthenticationInteractor(new RequestSender(getApplicationContext()), this, getApplicationContext());
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
        makeToast("INITIATE POPQUIZ PHASE 1");
    }
}
