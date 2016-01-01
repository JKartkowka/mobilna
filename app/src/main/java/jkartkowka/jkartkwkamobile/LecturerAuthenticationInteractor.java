package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.ChangePopQuizStateRequest;
import jkartkowka.jkartkwkamobile.network.requests.LecturerSecretRequest;

public class LecturerAuthenticationInteractor extends UserAuthenticationInteractor {

    public final int groupId;
    public final int popQuizId;

    public LecturerAuthenticationInteractor(RequestSender requestSender, Intent intent, Activity activity) {
        super(requestSender, activity);
        groupId = intent.getIntExtra("groupID", -1);
        popQuizId = intent.getIntExtra("popQuizID", -1);
    }
    @Override
    public void getSecret(final StandardGenericResponseHandler<Integer> responseHandler) {
        LecturerSecretRequest request = new LecturerSecretRequest(groupId, popQuizId, new StandardGenericResponseHandler<Integer>() {
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

    public void activatePopQuiz(StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        ChangePopQuizStateRequest request = new ChangePopQuizStateRequest(groupId, popQuizId, responseHandler);

        requestSender.sendRequest(request);
    }
}
