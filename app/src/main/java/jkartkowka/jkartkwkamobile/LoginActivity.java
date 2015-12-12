package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {

    private LoginInteractor loginInteractor;
    private ImageButton buttonLogin;
    private EditText inputLogin;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (ImageButton) findViewById(R.id.buttonLogIn);
        inputLogin = (EditText) findViewById(R.id.inputLogin);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
    }

    void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void onLogInClick(View v) {
        if (inputLogin.getText().toString().length() == 0 || inputPassword.getText().toString().length() == 0) {
            makeToast("Wprowadź dane logowania");
        } else {
            RequestSender requestSender = new RequestSender(getApplicationContext());
            loginInteractor = new LoginInteractor(requestSender);
            loginInteractor.login(inputLogin.getText().toString(), inputPassword.getText().toString(), new StandardGenericResponseHandler<UserType>() {
                @Override
                void onSuccess(UserType responseObject) {
                    makeToast("Logged in as: " + responseObject.toString());
                    navigateToMenu();
                }

                @Override
                void onFailure(ErrorHandler error) {
                    super.onFailure(error);
                }
            });
        }
    }

    private void navigateToMenu() {
        Intent intent = new Intent(this, MainMenuActivity.class); //stating with intent 'cause it's possible to attach additional values to it
        startActivity(intent);
    }


}
