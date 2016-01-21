package jkartkowka.jkartkwkamobile;

import android.app.DownloadManager;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 21.01.2016.
 */
public class SendAnswersRequest implements StandardRequest {
    private final int testId;
    private final ArrayList<HashMap<String, Object>> answers;
    private final StandardGenericResponseHandler<Object> standardGenericResponseHandler;

    public SendAnswersRequest(int testId, ArrayList<HashMap<String, Object>> answers, StandardGenericResponseHandler<Object> standardGenericResponseHandler) {
        this.testId = testId;
        this.answers = answers;
        this.standardGenericResponseHandler = standardGenericResponseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        standardGenericResponseHandler.onSuccess("");
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
        return "send";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", testId);
        params.put("answers", answers);
        return params;
    }

    @Override
    public void parseErrorResponse(VolleyError params) {
        standardGenericResponseHandler.onSuccess("");
    }
}
