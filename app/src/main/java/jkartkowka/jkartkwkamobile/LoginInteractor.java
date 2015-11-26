package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 22.11.15.
 */
public class LoginInteractor {

    private final RequestSender requestSender;

    public LoginInteractor(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    public void login(String login, String password, final StandardGenericResponseHandler<User> standardResponseHandler) {
        LoginRequest request = new LoginRequest(login, password, new StandardGenericResponseHandler<User>() {
            @Override
            void onSuccess(User responseObject) {
                standardResponseHandler.onSuccess(responseObject);
            }

            @Override
            void onFailure(ErrorHandler error) {
                standardResponseHandler.onFailure(error);
            }
        });
        requestSender.sendRequest(request);
    }
}
