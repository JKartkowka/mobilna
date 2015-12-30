package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 29.12.2015.
 */
public class LecturerPopQuizInteractor extends JKInteractor {

    public final String groupName;
    public final String popQuizName;

    public LecturerPopQuizInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        this.groupName = intent.getStringExtra("groupName");
        this.popQuizName = intent.getStringExtra("popQuizName");
    }
}
