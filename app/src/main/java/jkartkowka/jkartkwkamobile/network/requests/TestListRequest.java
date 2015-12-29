package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class TestListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<JKTest>> responseHandler;

    public TestListRequest(StandardGenericResponseHandler<ArrayList<JKTest>> responseHandler) {
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
        ArrayList<JKTest> testsList = new ArrayList<>();
        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; i++) {
            int questionCount = randomGenerator.nextInt(20) + 10;
            int correctAnswers = randomGenerator.nextInt(questionCount);
            JKTest test = new JKTest(i, "Kartkówka " + i, questionCount, correctAnswers, 2.0f);
            testsList.add(test);
        }

        responseHandler.onSuccess(testsList);
    }
}
