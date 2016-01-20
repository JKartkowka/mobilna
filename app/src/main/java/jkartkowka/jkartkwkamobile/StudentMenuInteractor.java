package jkartkowka.jkartkwkamobile;

import android.content.Context;

import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.IsAnyPopQuizActiveRequest;

/**
 * Created by marian on 18.01.2016.
 */
public class StudentMenuInteractor extends MenuInteractor implements AirplaneModeInteractorInterface {

    private final AirplaneModeInteractor airplaneModeInteractor;

    public StudentMenuInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender);
        airplaneModeInteractor = new AirplaneModeInteractor(requestSender, applicationContext);
    }

    public boolean isAirplaneModeOn() {
        return airplaneModeInteractor.isAirplaneModeOn();
    }

    public void isAnyPopQuizActive(StandardGenericResponseHandler<Boolean> standardGenericResponsHandler) {
        IsAnyPopQuizActiveRequest request = new IsAnyPopQuizActiveRequest(standardGenericResponsHandler);
        requestSender.sendRequest(request);
    }
}
