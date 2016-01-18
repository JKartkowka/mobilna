package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by maciej on 30.12.15.
 */
public class QuestionRequest implements StandardRequest {

    private final StandardGenericResponseHandler<Question> responseHandler;

    public QuestionRequest(StandardGenericResponseHandler<Question> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {

    }

    @Override
    public String apiMethod() {
        return "";
    } //TODO add declaration to api

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }

    @Override
    public void mockedResponse() {
        String[] answers = {"2", "3", "4", "5"};
        Question question = new Question(0, "2+2", answers, false);
        responseHandler.onSuccess(question);
    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return null;
    }
}
