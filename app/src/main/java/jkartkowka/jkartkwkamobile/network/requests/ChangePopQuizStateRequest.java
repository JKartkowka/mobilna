package jkartkowka.jkartkwkamobile.network.requests;

import android.util.Pair;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.PopQuizState;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 29.12.2015.
 */
public class ChangePopQuizStateRequest implements StandardRequest {
    private final int popQuizId;
    private final int groupId;
    private final StandardGenericResponseHandler<Pair<String, String>> responseHandler;
    private final PopQuizState popQuizState;

    public ChangePopQuizStateRequest(int groupId, int popQuizId, PopQuizState popQuizState, StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        this.popQuizId = popQuizId;
        this.groupId = groupId;
        this.responseHandler = responseHandler;
        this.popQuizState = popQuizState;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        try {
            JSONObject object = params.getJSONObject(0);
            String test_name = object.getString("test_name");
            String group_name = "";
            responseHandler.onSuccess(new Pair<>(test_name, group_name));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mockedResponse() {
        responseHandler.onSuccess(new Pair<>("Kartkówka dla Adama", "Języki Formalne i Techniki Translacji, czwartek nieparzysty, godzina 18.55"));
    }

    @Override
    public String apiMethod() {
        return "change_state";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", popQuizId);
        params.put("group_id", groupId);
        if (popQuizState == PopQuizState.PQSOpened) {
            params.put("state", 1);
        } else {
            params.put("state", 0);
        }

        return params;
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "tests";
    }
}
