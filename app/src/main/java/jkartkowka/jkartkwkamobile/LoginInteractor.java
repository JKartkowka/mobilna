package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.model.UserType;

/**
 * Created by marian on 22.11.15.
 */
public class LoginInteractor extends JKInteractor {


    public LoginInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void login(String login, String password, final StandardGenericResponseHandler<UserType> standardResponseHandler) {
        LoginRequest request = new LoginRequest(login, password, new StandardGenericResponseHandler<User>() {
            @Override
            void onSuccess(User responseObject) {
                standardResponseHandler.onSuccess(responseObject.getType());
            }

            @Override
            void onFailure(ErrorHandler error) {
                standardResponseHandler.onFailure(error);
            }
        });
        requestSender.sendRequest(request);
    }
}
