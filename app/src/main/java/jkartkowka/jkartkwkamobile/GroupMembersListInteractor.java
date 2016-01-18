package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

public class GroupMembersListInteractor extends JKInteractor {
    private final int groupID;

    public GroupMembersListInteractor(RequestSender requestSender, Intent intent) {
        super(requestSender);
        groupID = intent.getIntExtra("groupID", -1);
    }

    public void groupMembers(StandardGenericResponseHandler<ArrayList<Student>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(groupID, standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
