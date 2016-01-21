package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class SecretRequest implements StandardRequest {
    private final int popQuizId;
    private final StandardGenericResponseHandler<Integer> responseHandler;

    public SecretRequest(int popQuizId, StandardGenericResponseHandler<Integer> responseHandler) {
        this.popQuizId = popQuizId;
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        try {
            JSONObject object = params.getJSONObject(0);
            int key = object.getInt("key");
            responseHandler.onSuccess(key + 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mockedResponse() {
        Random rand = new Random();
        int number = rand.nextInt(16) + 1;
        responseHandler.onSuccess(number);
    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String apiMethod() {
        return "get_key";
    }

    @Override
    public String endpoint() {
        return "tests";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", popQuizId);

        return params;
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }

}
