package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.RequestSender;

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
}
