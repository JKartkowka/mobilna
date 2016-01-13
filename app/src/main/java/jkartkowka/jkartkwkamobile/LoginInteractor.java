package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.model.UserType;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.LoginRequest;

public class LoginInteractor extends JKInteractor {

    public LoginInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void login(String login, String password, final StandardGenericResponseHandler<UserType> standardResponseHandler) {
        RequestSender.setCredentials(login, password);
//        TODO login flow will change
        LoginRequest request = new LoginRequest(login, password, new StandardGenericResponseHandler<User>() {
            @Override
            public void onSuccess(User responseObject) {
                standardResponseHandler.onSuccess(responseObject.getType());
            }

            @Override
            public void onFailure(ErrorHandler error) {
                standardResponseHandler.onFailure(error);
            }
        });
        requestSender.sendRequest(request);
    }

}
