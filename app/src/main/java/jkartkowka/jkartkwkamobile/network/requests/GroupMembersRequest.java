package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class GroupMembersRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<Student>> responseHandler;
    private final int groupId;

    public GroupMembersRequest(StandardGenericResponseHandler<ArrayList<Student>> responseHandler) {
        this.responseHandler = responseHandler;
        groupId = 0; // TODO: skąd wiziął się ten konstruktor?
    }

    public GroupMembersRequest(int groupId, StandardGenericResponseHandler<ArrayList<Student>> standardGenericResponseHandler) {
        this.groupId = groupId;
        this.responseHandler = standardGenericResponseHandler;
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
        HashMap<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);
        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

    @Override
    public void mockedResponse() {
        ArrayList<Student> membersList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Student student = new Student(i, "Osoba  " + i);
            membersList.add(student);
        }

        responseHandler.onSuccess(membersList);
    }
}
