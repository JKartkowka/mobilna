package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import jkartkowka.jkartkwkamobile.network.RequestSender;

public class StudentAuthenticationInteractor extends UserAuthenticationInteractor {

    public StudentAuthenticationInteractor(RequestSender requestSender, Activity activity) {
        super(requestSender, activity);
    }
}
