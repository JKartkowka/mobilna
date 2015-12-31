package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;
import jkartkowka.jkartkwkamobile.model.Student;

public class GroupMembersListInteractor extends JKInteractor {
    public GroupMembersListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupMembers(StandardGenericResponseHandler<ArrayList<Student>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
