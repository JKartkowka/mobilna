package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;
import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.TestListRequest;

public class GradesListInteractor extends JKInteractor {

    public GradesListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void gradesList(StandardGenericResponseHandler<ArrayList<JKTest>> standardGenericResponseHandler) {
        TestListRequest request = new TestListRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}