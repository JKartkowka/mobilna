package jkartkowka.jkartkwkamobile;

import java.util.Date;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.model.UserType;

/**
 * Created by marian on 22.11.15.
 */
public class LoginRequest implements AuthenticationRequest {
    public final String login;
    public final String password;
    public final StandardGenericResponseHandler<User> responseHandler;

    public LoginRequest(String login, String password, StandardGenericResponseHandler<User> standardResponseHandler) {
        this.login = login;
        this.password = password;
        this.responseHandler = standardResponseHandler;
    }

    @Override
    public String apiMethod() {
        return "login";
    }

    public HashMap<String, Object> params() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("login", login);
        map.put("md5", password);

        return map;
    }

    public void parseSuccessResponse(HashMap<String, Object> params) {
    }

    public void parseErrorResponse(HashMap<String, Object> params) {
        ErrorHandler error = new ErrorHandler();

        responseHandler.onFailure(error);
    }

    @Override
    public User mockedResponse() {
        String accessToken = "accessToken";
        String refreshToken = "refreshToken";
        Date accessTokenExpirationDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        UserType type;
        if(login.matches("L.*"))
            type = UserType.UTLecturer;
        else
            type = UserType.UTStudent;

        User user = new User(accessToken, refreshToken, accessTokenExpirationDate, type);

        return user;
    }

    @Override
    public void onSuccess(User user) {
        responseHandler.onSuccess(user);
    }

}
