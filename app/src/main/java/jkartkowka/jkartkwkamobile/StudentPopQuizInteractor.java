package jkartkowka.jkartkwkamobile;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import jkartkowka.jkartkwkamobile.model.Answer;
import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.requests.PopQuizRequest;

/**
 * Created by maciej on 29.12.15.
 */
public class StudentPopQuizInteractor extends AirplaneModeInteractor {

    private PopQuiz popQuiz;
    private List<boolean[]> userAnswers;
    private int currentQuestionIndex;

    public StudentPopQuizInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender, applicationContext);
        currentQuestionIndex = 0;
    }

    public void getPopQuiz(StandardGenericResponseHandler<PopQuiz> standardGenericResponseHandler) {
//        TODO Adam change it
        PopQuizRequest request = new PopQuizRequest(1, standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }

    public void initialize(PopQuiz popQuiz) {
        this.popQuiz = popQuiz;
        userAnswers = new ArrayList<>();
        for (int i = 0; i < popQuiz.getQuestionCount(); i++) {
            userAnswers.add(new boolean[4]);
        }
    }

    public void saveAnswer(boolean[] marked) {
        userAnswers.set(currentQuestionIndex, marked);
    }

    public Answer[] getSuggestedAnswers() {
        return popQuiz.getAnswers(currentQuestionIndex);
    }

    public boolean[] getSavedAnswers() {
        return userAnswers.get(currentQuestionIndex);
    }

    public void previousQuestion() {
        if (currentQuestionIndex > 0)
            currentQuestionIndex -= 1;
    }

    public void nextQuestion() {
        if (currentQuestionIndex < popQuiz.getQuestionCount() - 1)
            currentQuestionIndex += 1;
    }

    public String getQuestion() {
        return popQuiz.getQuestionContent(currentQuestionIndex);
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public int getPopQuizQuestionCount() {
        return popQuiz.getQuestionCount();
    }
}
