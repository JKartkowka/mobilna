package jkartkowka.jkartkwkamobile;

import android.content.Context;
import android.provider.Settings;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 18.01.2016.
 */
public class AirplaneModeInteractor extends JKInteractor implements AirplaneModeInteractorInterface {
    private final Context context;


    public AirplaneModeInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender);
        context = applicationContext;
    }

    @Override
    public boolean isAirplaneModeOn() {
        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) != 0;
    }
}
