package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 22.11.15.
 */
public class LoginInteractor {

    private final RequestSender requestSender;

    public LoginInteractor(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    public void login(String login, String password, final StandardResponseHandler standardResponseHandler) {
        standardResponseHandler.onSuccess();
        LoginRequest request = new LoginRequest(login, password, new StandardResponseHandler() {
            @Override
            void onSuccess() {
                standardResponseHandler.onSuccess();
            }

            @Override
            void onFailure() {
                standardResponseHandler.onFailure();
            }
        });
        requestSender.sendRequest(request);
    }
}
