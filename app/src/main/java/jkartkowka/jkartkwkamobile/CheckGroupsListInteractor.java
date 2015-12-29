package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Group;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupListRequest;

public class CheckGroupsListInteractor extends JKInteractor {

    public CheckGroupsListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupsList(StandardGenericResponseHandler<ArrayList<Group>> standardGenericResponseHandler) {
        GroupListRequest request = new GroupListRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
