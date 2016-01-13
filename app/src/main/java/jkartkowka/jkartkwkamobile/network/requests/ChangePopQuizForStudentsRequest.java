package jkartkowka.jkartkwkamobile.network.requests;

import android.util.Pair;

import com.android.volley.Request;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 31.12.2015.
 */
public class ChangePopQuizForStudentsRequest implements StandardRequest {
    private final ArrayList<Integer> studentsId;
    private final StandardGenericResponseHandler<Pair<String, String>> responseHandler;
    private final int popQuizId;

    public ChangePopQuizForStudentsRequest(ArrayList<Integer> studentsId, int popQuizId, StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        this.studentsId = studentsId;
        this.popQuizId = popQuizId;
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
    }

    @Override
    public void mockedResponse() {
        responseHandler.onSuccess(new Pair<>("Kartkówka dla Adama", "Języki Formalne i Techniki Translacji, czwartek nieparzysty, godzina 18.55"));
    }

    @Override
    public String apiMethod() {
        return "tests";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", popQuizId);
        params.put("students_id", studentsId);
        params.put("state", 1);

        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "change_state";
    }
}
