package jkartkowka.jkartkwkamobile;

import android.content.Context;
import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 21.01.2016.
 */
public class StudentPopQuizInfo extends AirplaneModeInteractor {
    public final int popQuizId;

    public StudentPopQuizInfo(RequestSender requestSender, Context applicationContext, Intent intent) {
        super(requestSender, applicationContext);
        popQuizId = intent.getIntExtra("popQuizID", -1);
    }
}
