package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;

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
        return "tests/list";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("method", "list");
        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

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
