package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.PopQuizListRequest;

public class PopQuizListInteractor extends JKInteractor {
    public PopQuizListInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void popQuizList(StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler) {
        PopQuizListRequest request = new PopQuizListRequest(responseHandler);
        requestSender.sendRequest(request);
    }
}
