package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class PopQuizListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler;

    public PopQuizListRequest(StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public String apiMethod() {
        return "list";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public void parseSuccessResponse(JSONArray response) {
        Random randomGenerator = new Random();
        ArrayList<PopQuiz> popQuizList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject jsonQuiz = (JSONObject) response.get(i);
                String quizName = jsonQuiz.getString("name");
                int identifier = jsonQuiz.getInt("id");
                JSONArray jsonQuestionList = jsonQuiz.getJSONArray("questions");
                int questionCount = jsonQuestionList.length();
//                TODO how to get from server number of correct answers?
                int correctAnswers = randomGenerator.nextInt(questionCount);
//                TODO how to get from server grade?
                PopQuiz popQuiz = new PopQuiz(identifier, quizName, questionCount, correctAnswers, 2.0f);
                popQuizList.add(popQuiz);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        responseHandler.onSuccess(popQuizList);
    }

    @Override
    public void mockedResponse() {
        ArrayList<PopQuiz> popQuizList = new ArrayList<>();
        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; i++) {
            int questionCount = randomGenerator.nextInt(20) + 10;
            int correctAnswers = randomGenerator.nextInt(questionCount);
            PopQuiz popQuiz = new PopQuiz(i, "Kartkówka " + i, questionCount, correctAnswers, 2.0f);
            popQuizList.add(popQuiz);
        }

        responseHandler.onSuccess(popQuizList);
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
