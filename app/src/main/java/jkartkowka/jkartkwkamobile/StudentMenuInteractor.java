package jkartkowka.jkartkwkamobile;

import android.content.Context;
import android.provider.Settings;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 18.01.2016.
 */
public class StudentMenuInteractor extends MenuInteractor {
    private final Context context;

    public StudentMenuInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender);
        this.context = applicationContext;
    }

    public boolean isAirplaneModeOn() {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) != 0;

    }
}
