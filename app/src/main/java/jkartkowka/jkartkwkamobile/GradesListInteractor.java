package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;
import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.PointsListRequest;
import jkartkowka.jkartkwkamobile.network.requests.PopQuizListRequest;

public class GradesListInteractor extends JKInteractor {

    public GradesListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void gradesList(StandardGenericResponseHandler<ArrayList<PopQuiz>> standardGenericResponseHandler) {
        PointsListRequest request = new PointsListRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}