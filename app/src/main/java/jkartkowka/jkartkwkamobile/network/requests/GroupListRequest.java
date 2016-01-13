package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Group;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class GroupListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<Group>> responseHandler;

    public GroupListRequest(StandardGenericResponseHandler<ArrayList<Group>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

    }

    @Override
    public String apiMethod() {
        return "list";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();

        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public void mockedResponse() {
        ArrayList<Group> popQuizList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Group group = new Group(i, "Grupa " + i);
            popQuizList.add(group);
        }

        responseHandler.onSuccess(popQuizList);
    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "groups";
    }
}
