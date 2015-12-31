package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

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

    public void getStudents(StandardGenericResponseHandler<ArrayList<Student>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(groupId, standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
