package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.model.UserType;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class AboutUserRequest implements StandardRequest {

    public final StandardGenericResponseHandler<User> responseHandler;

    public AboutUserRequest(StandardGenericResponseHandler<User> standardResponseHandler) {
        this.responseHandler = standardResponseHandler;
    }

    @Override
    public String apiMethod() {
        return "about";
    }

    public HashMap<String, Object> params() {
        return new HashMap<>();
    }


    public void parseErrorResponse(VolleyError params) {
        ErrorHandler error = new ErrorHandler();

        responseHandler.onFailure(error);
    }

    @Override
    public void parseSuccessResponse(JSONArray response) {

    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "user";
    }

    @Override
    public void mockedResponse() {
        User user = new User(UserType.UTStudent);

        responseHandler.onSuccess(user);
    }

    public void parseSuccessResponseJSONObject(JSONObject response) {
        try {
            int intType = response.getInt("result");
            User user;
            if (intType == 1) {
                user = new User(UserType.UTStudent);
            } else {
                user = new User(UserType.UTLecturer);
            }

            responseHandler.onSuccess(user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
