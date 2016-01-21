package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class LecturerSecretRequest extends SecretRequest implements StandardRequest {
    private final int popQuizId;

    public LecturerSecretRequest(int popQuizId, StandardGenericResponseHandler<Integer> responseHandler) {
        super(responseHandler);
        this.popQuizId = popQuizId;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        try {
            int key = params.getInt(0);
            responseHandler.onSuccess(key);
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
