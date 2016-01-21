package jkartkowka.jkartkwkamobile.network.requests;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by maciej on 21.01.16.
 */
public class PointsListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler;

    public PointsListRequest(StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        ArrayList<PopQuiz> arrayList = new ArrayList<>();
        try {
            for (int i = 0; i < params.length(); i++) {
                Log.e("~~~~~~~~~~~~~~~~~~~~", "~~~~~~~~~~~~~~~~~~~");
                JSONObject object = (JSONObject) params.get(i);
                JSONObject test = object.getJSONObject("test");
                int id = test.getInt("id");
                String name = test.getString("name");
                int score = object.getInt("score");
                int max = object.getInt("max");
                arrayList.add(new PopQuiz(id, name, max, score, 1, null));
            }
            responseHandler.onSuccess(arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mockedResponse() {

    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "tests";
    }

    @Override
    public String apiMethod() {
        return "give_me_my_grades_bitch";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }
}
