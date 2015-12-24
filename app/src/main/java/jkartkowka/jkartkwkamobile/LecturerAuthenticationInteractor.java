package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.SecretRequest;

/**
 * Created by marian on 24.12.2015.
 */
public class LecturerAuthenticationInteractor extends JKInteractor {

    private final int groupId;
    private final int testId;
    private final Activity currentActivity;

    public LecturerAuthenticationInteractor(RequestSender requestSender, Intent intent, Activity activity) {
        super(requestSender);
        groupId = intent.getIntExtra("groupID", -1);
        testId = intent.getIntExtra("testID", -1);
        currentActivity = activity;
    }

    public void getSecret(final StandardGenericResponseHandler<Integer> responseHandler) {
        SecretRequest request = new SecretRequest(groupId, testId, new StandardGenericResponseHandler<Integer>() {
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
