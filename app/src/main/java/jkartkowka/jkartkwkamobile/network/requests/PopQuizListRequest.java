package jkartkowka.jkartkwkamobile.network.requests;

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
        return new HashMap<String, Object>();
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
}
