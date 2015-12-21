package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 21.12.2015.
 */
public class GroupListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<JKGroup>> responseHandler;

    public GroupListRequest(StandardGenericResponseHandler<ArrayList<JKGroup>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

    }

    @Override
    public String apiMethod() {
        return "groups/list";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public void mockedResponse() {
        ArrayList<JKGroup> testsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            JKGroup group = new JKGroup(i, "Grupa " + i);
            testsList.add(group);
        }

        responseHandler.onSuccess(testsList);
    }
}
