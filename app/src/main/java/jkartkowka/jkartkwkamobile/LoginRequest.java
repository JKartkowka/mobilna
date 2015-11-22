package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 22.11.15.
 */
public class LoginRequest {
    public final String login;
    public final String password;
    public final StandardResponseHandler responseHandler;

    public static final String APImethod = "login";

    public LoginRequest(String login, String password, StandardResponseHandler standardResponseHandler) {
        this.login = login;
        this.password = password;
        this.responseHandler = standardResponseHandler;
    }

    public HashMap<String, String> params() {
        HashMap<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("md5", password);

        return map;
    }


}
