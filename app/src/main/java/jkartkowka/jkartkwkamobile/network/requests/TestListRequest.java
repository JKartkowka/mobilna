package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 19.12.2015.
 */
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
        for (int i = 0; i < 10; i++) {
            JKTest test = new JKTest(i, "Kartkówka " + 1);
            testsList.add(test);
        }

        responseHandler.onSuccess(testsList);
    }
}
