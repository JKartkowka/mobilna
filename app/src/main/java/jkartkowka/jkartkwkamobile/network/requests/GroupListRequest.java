package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    public void parseSuccessResponse(JSONArray response) {
        ArrayList<Group> groupArrayList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject groupObject = (JSONObject) response.get(i);
                String groupName = groupObject.getString("name");
                int groupId = groupObject.getInt("id");
                Group group = new Group(groupId, groupName);
                groupArrayList.add(group);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        responseHandler.onSuccess(groupArrayList);
    }

    @Override
    public String apiMethod() {
        return "list";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(VolleyError response) {
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
