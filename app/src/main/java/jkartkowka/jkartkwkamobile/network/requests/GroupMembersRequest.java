package jkartkowka.jkartkwkamobile.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class GroupMembersRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<Student>> responseHandler;

    public GroupMembersRequest(StandardGenericResponseHandler<ArrayList<Student>> responseHandler) {
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
        ArrayList<Student> membersList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Student student = new Student(i, "Osoba  " + i);
            membersList.add(student);
        }

        responseHandler.onSuccess(membersList);
    }
}
