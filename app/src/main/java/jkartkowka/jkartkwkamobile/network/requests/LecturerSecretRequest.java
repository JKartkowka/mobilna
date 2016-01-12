package jkartkowka.jkartkwkamobile.network.requests;

import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class LecturerSecretRequest extends SecretRequest implements StandardRequest {
    private final int groupId;
    private final int popQuizId;

    public LecturerSecretRequest(int groupId, int popQuizId, StandardGenericResponseHandler<Integer> responseHandler) {
        super(responseHandler);
        this.groupId = groupId;
        this.popQuizId = popQuizId;
    }

    @Override
    public void parseSuccessResponse(HashMap<String, Object> params) {

    }

    @Override
    public void mockedResponse() {
        Random rand = new Random();
        int number = rand.nextInt(16) + 1;
        responseHandler.onSuccess(number);
    }

    @Override
    public String apiMethod() {
        return "tests/get_key";
    }

    @Override
    public HashMap<String, Object> params() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("test_id", popQuizId);
        params.put("group_id", groupId);

        return params;
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {

    }

}
