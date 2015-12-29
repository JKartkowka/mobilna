package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Group;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class GroupMembersRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<Group>> responseHandler;

    public GroupMembersRequest(StandardGenericResponseHandler<ArrayList<Group>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

    }

    @Override
    public String apiMethod() {
        return "groups/members";
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
        ArrayList<Group> membersList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Group group = new Group(i, "Osoba  " + i);
            membersList.add(group);
        }

        responseHandler.onSuccess(membersList);
    }
}
