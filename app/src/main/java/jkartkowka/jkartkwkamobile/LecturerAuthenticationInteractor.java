package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;

import jkartkowka.jkartkwkamobile.model.PopQuizState;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.ChangePopQuizStateRequest;

public class LecturerAuthenticationInteractor extends UserAuthenticationInteractor {

    public final int groupId;
    public LecturerAuthenticationInteractor(RequestSender requestSender, Intent intent, Activity activity) {
        super(requestSender, activity, intent);
        groupId = intent.getIntExtra("groupID", -1);
    }

    public void activatePopQuiz(StandardGenericResponseHandler<Pair<String, String>> responseHandler) {
        ChangePopQuizStateRequest request = new ChangePopQuizStateRequest(groupId, popQuizId, PopQuizState.PQSOpened, responseHandler);

        requestSender.sendRequest(request);
    }
}
