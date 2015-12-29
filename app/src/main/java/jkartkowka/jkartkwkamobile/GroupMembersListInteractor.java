package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Group;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

public class GroupMembersListInteractor extends JKInteractor {
    public GroupMembersListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupMembers(StandardGenericResponseHandler<ArrayList<Group>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
