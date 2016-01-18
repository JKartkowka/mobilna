package jkartkowka.jkartkwkamobile;

import android.content.Context;

import jkartkowka.jkartkwkamobile.network.RequestSender;

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
}
