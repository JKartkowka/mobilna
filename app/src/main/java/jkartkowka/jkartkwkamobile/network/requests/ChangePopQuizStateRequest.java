package jkartkowka.jkartkwkamobile.network.requests;

import android.util.Pair;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by marian on 29.12.2015.
 */
public class ChangePopQuizStateRequest implements StandardRequest {
    private final int popQuizId;
    private final int groupId;
    private final StandardGenericResponseHandler<Pair<String, String>> responseHandler;

    public ChangePopQuizStateRequest(int groupId, int popQuizId, StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        this.popQuizId = popQuizId;
        this.groupId = groupId;
        this.responseHandler = responseHandler;
    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

    }

    @Override
    public void mockedResponse() {
        responseHandler.onSuccess(new Pair<>("Kartkówka dla Adama", "Języki Formalne i Techniki Translacji, czwartek nieparzysty, godzina 18.55"));
    }

    @Override
    public String apiMethod() {
        return "change_state/tests";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", popQuizId);
        params.put("group_id", groupId);
        params.put("state", 1);

        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }
}
