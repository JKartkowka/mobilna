package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 22.11.15.
 */
public class LoginRequest {
    public final String login;
    public final String password;
    public final StandardGenericResponseHandler<User> responseHandler;

    public static final String APImethod = "login";

    public LoginRequest(String login, String password, StandardGenericResponseHandler<User> standardResponseHandler) {
        this.login = login;
        this.password = password;
        this.responseHandler = standardResponseHandler;
    }

    public HashMap<String, Object> params() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("login", login);
        map.put("md5", password);

        return map;
    }

}
