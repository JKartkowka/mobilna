package jkartkowka.jkartkwkamobile;

import android.content.Context;

import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.QuestionRequest;

/**
 * Created by maciej on 29.12.15.
 */
public class MultipleAnswerPopQuizInteractor extends AirplaneModeInteractor {
    public MultipleAnswerPopQuizInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender, applicationContext);
    }

    public void question(StandardGenericResponseHandler<Question> standardGenericResponseHandler) {
        QuestionRequest request = new QuestionRequest(standardGenericResponseHandler);
        requestSender.sendRequest(request);

    }
}
