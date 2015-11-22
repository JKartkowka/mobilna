package jkartkowka.jkartkwkamobile;

import com.android.volley.RequestQueue;

/**
 * Created by marian on 22.11.15.
 */
public class LoginInteractor {
    private final RequestQueue queue;

    public LoginInteractor(RequestQueue queue) {
        this.queue = queue;
    }

    public void login(String login, String password, InteractorStandardResponseHandler interactorStandardResponseHandler) {
        interactorStandardResponseHandler.onSuccess();
    }
}
