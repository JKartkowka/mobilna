package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 31.12.2015.
 */
public class LecturerCustomAuthenticationInteractor extends JKInteractor {
    private final int groupId;
    private final int popQuizId;

    public LecturerCustomAuthenticationInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        groupId = intent.getIntExtra("groupId", -1);
        popQuizId = intent.getIntExtra("popQuizId", -1);
    }
}
