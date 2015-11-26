package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 22.11.15.
 */
public class LoginRequest extends StandardRequest {
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
        User user = new User();

        responseHandler.onSuccess(user);
    }

    public void parseErrorResponse(HashMap<String, Object> params) {
        ErrorHandler error = new ErrorHandler();

        responseHandler.onFailure(error);
    }

}
