package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class GroupMembersRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<Student>> responseHandler;
    private final int groupId;

    public GroupMembersRequest(int groupId, StandardGenericResponseHandler<ArrayList<Student>> standardGenericResponseHandler) {
        this.groupId = groupId;
        this.responseHandler = standardGenericResponseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray response) {
        ArrayList<Student> membersList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject groupObject = response.getJSONObject(i);
                int groupIndex = groupObject.getInt("id");
                if (groupIndex == groupId) {
                    parseCurrentGroup(membersList, groupObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        responseHandler.onSuccess(membersList);
    }

    private void parseCurrentGroup(ArrayList<Student> membersList, JSONObject groupObject) throws JSONException {
        JSONArray studentsArray = groupObject.getJSONArray("students");
        for (int j = 0; j < studentsArray.length(); j++) {
            parseStudentAt(membersList, studentsArray, j);
        }
    }

    private void parseStudentAt(ArrayList<Student> membersList, JSONArray studentsArray, int j) throws JSONException {
        JSONObject studentObject = studentsArray.getJSONObject(j);
        JSONObject userObject = studentObject.getJSONObject("user");
        int userId = userObject.getInt("id");
        String username = userObject.getString("username");
        Student student = new Student(userId, username);
        membersList.add(student);
    }

    @Override
    public String apiMethod() {
        return "members";
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

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "groups";
    }
}
