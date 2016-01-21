package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.PopQuizRequest;

public class StudentAuthenticationInteractor extends UserAuthenticationInteractor implements AirplaneModeInteractorInterface {

    private final AirplaneModeInteractor airplaneModeInteractor;

    public StudentAuthenticationInteractor(RequestSender requestSender, Activity activity, Context applicationContext, Intent intent) {
        super(requestSender, activity, intent);
        airplaneModeInteractor = new AirplaneModeInteractor(requestSender, applicationContext);
    }

    @Override
    public boolean isAirplaneModeOn() {
        return airplaneModeInteractor.isAirplaneModeOn();
    }

    public void isActivePopQuiz(final StandardGenericResponseHandler<Boolean> standardGenericResponseHandler) {
        PopQuizRequest request = new PopQuizRequest(popQuizId, new StandardGenericResponseHandler<PopQuiz>() {
            @Override
            public void onSuccess(PopQuiz responseObject) {
                standardGenericResponseHandler.onSuccess(responseObject != null);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                standardGenericResponseHandler.onFailure(error);
            }
        });

        requestSender.sendRequest(request);
    }
}
