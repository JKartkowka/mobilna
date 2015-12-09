package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {

    private LoginInteractor loginInteractor;
    private Button buttonLogin;
    private EditText inputLogin;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        inputLogin = (EditText) findViewById(R.id.inputLogin);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
    }

    void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        if (inputLogin.getText().toString().length() == 0 || inputPassword.getText().toString().length() == 0) {
            makeToast("Wprowadź dane logowania");
        } else {
            RequestSender requestSender = new RequestSender(getApplicationContext());
            loginInteractor = new LoginInteractor(requestSender);
            loginInteractor.login(inputLogin.getText().toString(), inputPassword.getText().toString(), new StandardGenericResponseHandler<UserType>() {
                @Override
                void onSuccess(UserType responseObject) {
                    makeToast("Logged as: " + responseObject.toString());
                    //TODO start new activity for logged in user
                }

                @Override
                void onFailure(ErrorHandler error) {
                    super.onFailure(error);
                }
            });
        }
    }


}
