package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.GroupListRequest;

/**
 * Created by maciej on 22.12.15.
 */
public class CheckGroupsListInteractor extends JKInteractor {

    public CheckGroupsListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void groupsList(StandardGenericResponseHandler<ArrayList<JKGroup>> standardGenericResponseHandler) {
        GroupListRequest request = new GroupListRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
