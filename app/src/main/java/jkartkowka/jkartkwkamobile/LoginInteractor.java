package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.model.UserType;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.LoginRequest;
import jkartkowka.jkartkwkamobile.network.requests.PopQuizListRequest;

public class LoginInteractor extends JKInteractor {

    public LoginInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void login(String login, String password, final StandardGenericResponseHandler<UserType> standardResponseHandler) {
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

    public void tempRequest() {
        PopQuizListRequest request = new PopQuizListRequest(new StandardGenericResponseHandler<ArrayList<PopQuiz>>() {
            @Override
            public void onSuccess(ArrayList<PopQuiz> responseObject) {
            }

            @Override
            public void onFailure(ErrorHandler error) {
            }
        });

        requestSender.sendRequest(request);
    }
}
