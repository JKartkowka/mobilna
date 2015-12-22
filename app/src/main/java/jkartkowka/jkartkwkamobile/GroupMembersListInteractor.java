package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupMembersRequest;

/**
 * Created by maciej on 22.12.15.
 */
public class GroupMembersListInteractor extends JKInteractor {
    public GroupMembersListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupMembers(StandardGenericResponseHandler<ArrayList<JKGroup>> standardGenericResponseHandler) {
        GroupMembersRequest request = new GroupMembersRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
