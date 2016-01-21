package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.SecretRequest;

public class UserAuthenticationInteractor extends JKInteractor {

    private final Activity currentActivity;
    protected final int popQuizId;

    public UserAuthenticationInteractor(RequestSender requestSender, Activity activity, Intent intent) {
        super(requestSender);
        this.currentActivity = activity;
        popQuizId = intent.getIntExtra("popQuizID", -1);
    }

    public void getSecret(final StandardGenericResponseHandler<Integer> responseHandler) {
        SecretRequest request = new SecretRequest(popQuizId, new StandardGenericResponseHandler<Integer>() {
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

    protected Integer getDrawableId(Integer secretId) {
        return currentActivity.getResources().getIdentifier("symbol" + secretId, "drawable", currentActivity.getPackageName());
    }

}

