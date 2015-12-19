package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.TestListRequest;

/**
 * Created by marian on 19.12.2015.
 */
public class TestsListInteractor extends JKInteractor {
    public TestsListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void testsList(StandardGenericResponseHandler<ArrayList<JKTest>> responseHandler) {
        TestListRequest request = new TestListRequest(responseHandler);
        requestSender.sendRequest(request);
    }
}
