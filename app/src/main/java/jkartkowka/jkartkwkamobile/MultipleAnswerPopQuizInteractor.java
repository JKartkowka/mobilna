package jkartkowka.jkartkwkamobile;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.QuestionRequest;

/**
 * Created by maciej on 29.12.15.
 */
public class MultipleAnswerPopQuizInteractor extends JKInteractor{
    public MultipleAnswerPopQuizInteractor(RequestSender requestSender) {
        super(requestSender);
    }
    public void question(StandardGenericResponseHandler<Question> standardGenericResponseHandler) {
        QuestionRequest request = new QuestionRequest (standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
}
