package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupListRequest;

/**
 * Created by marian on 19.12.2015.
 */
public class GroupsListInteractor extends JKInteractor {

    public GroupsListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupsList(StandardGenericResponseHandler<ArrayList<JKGroup>> standardGenericResponseHandler) {
        GroupListRequest request = new GroupListRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
