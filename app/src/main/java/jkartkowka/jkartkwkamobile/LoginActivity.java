package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {

    private LoginInteractor loginInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RequestSender requestSender = new RequestSender(getApplicationContext());
        loginInteractor = new LoginInteractor(requestSender);
        loginInteractor.login("login", "password", new StandardGenericResponseHandler<UserType>() {
            @Override
            void onSuccess(UserType responseObject) {
                makeToast("Logged as: " + responseObject.toString());
            }

            @Override
            void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
