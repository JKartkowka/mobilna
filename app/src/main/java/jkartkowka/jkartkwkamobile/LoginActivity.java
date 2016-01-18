package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import jkartkowka.jkartkwkamobile.model.UserType;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LoginActivity extends JKActivity {

    private LoginInteractor loginInteractor;
    private ImageButton buttonLogin;
    private EditText inputLogin;
    private EditText inputPassword;
    private LoginWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);
        buttonLogin = (ImageButton) findViewById(R.id.buttonLogIn);
        inputLogin = (EditText) findViewById(R.id.inputLogin);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        setupAutodismissingKeyboard(findViewById(R.id.ALparentview));
        wireframe = new LoginWireframe(this);
        RequestSender requestSender = new RequestSender(getApplicationContext());
        loginInteractor = new LoginInteractor(requestSender);
    }

    @Override
    protected void onResume() {
        super.onResume();
        inputPassword.setText("");
    }

    public void onLogInClick(View v) {
        if (inputLogin.getText().toString().length() == 0 || inputPassword.getText().toString().length() == 0) {
            makeToast("Wprowadź dane logowania");
        } else {
            loginInteractor.login(inputLogin.getText().toString(), inputPassword.getText().toString(), new StandardGenericResponseHandler<UserType>() {
                @Override
                public void onSuccess(UserType receivedUserType) {
                    makeToast("Logged in as: " + receivedUserType.toString());
                    wireframe.navigateToMenu(receivedUserType);
                }

                @Override
                public void onFailure(ErrorHandler error) {
                    super.onFailure(error);
                }
            });
        }
    }

    public void gotoQuizActivity(View v) {
        Intent intent = new Intent(this, MultipleAnswerPopQuizActivity.class);
        this.startActivity(intent);
    }


}
