package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.util.Pair;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.SecretRequest;

public class StudentAuthenticationInteractor extends JKInteractor {

    private final Activity currentActivity;

    public StudentAuthenticationInteractor(RequestSender requestSender, Activity activity) {
        super(requestSender);
        currentActivity = activity;
    }

    public void getSecret(final StandardGenericResponseHandler<Integer> responseHandler) {
        SecretRequest request = new SecretRequest(new StandardGenericResponseHandler<Integer>() {
            @Override
            public void onSuccess(Integer secretId) {
                Integer drawableId = getDrawableId(secretId);
                responseHandler.onSuccess(drawableId);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                responseHandler.onFailure(error);
            }
        });

        requestSender.sendRequest(request);
    }

    private Integer getDrawableId(Integer secretId) {
        return currentActivity.getResources().getIdentifier("symbol" + secretId, "drawable", currentActivity.getPackageName());
    }
}
