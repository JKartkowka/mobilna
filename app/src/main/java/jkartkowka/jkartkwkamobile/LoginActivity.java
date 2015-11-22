package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends ActionBarActivity {

    private LoginInteractor loginInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        loginInteractor = new LoginInteractor(queue);
        loginInteractor.login("login", "password", new InteractorStandardResponseHandler() {
            void onSuccess() {
                makeToast("login success");
            }

            void onFailure() {
                makeToast("login failed");
            }
        });
    }

    void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
