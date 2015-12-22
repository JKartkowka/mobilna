package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by maciej on 22.12.15.
 */
public class GroupMembersRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<JKGroup>> responseHandler;

    public GroupMembersRequest(StandardGenericResponseHandler<ArrayList<JKGroup>> responseHandler) {
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
        ArrayList<JKGroup> membersList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            JKGroup group = new JKGroup(i, "Osoba  " + i);
            membersList.add(group);
        }

        responseHandler.onSuccess(membersList);
    }
}
