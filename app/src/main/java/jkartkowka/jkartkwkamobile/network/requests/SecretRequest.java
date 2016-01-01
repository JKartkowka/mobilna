package jkartkowka.jkartkwkamobile.network.requests;

import java.util.HashMap;
import java.util.Random;

import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

public class SecretRequest implements StandardRequest {
    protected final StandardGenericResponseHandler<Integer> responseHandler;

    public SecretRequest(StandardGenericResponseHandler<Integer> responseHandler) {
        this.responseHandler = responseHandler;
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
        return new HashMap<String, Object>();
    }

    @Override
    public void parseErrorResponse(HashMap<String, Object> params) {
    }
}