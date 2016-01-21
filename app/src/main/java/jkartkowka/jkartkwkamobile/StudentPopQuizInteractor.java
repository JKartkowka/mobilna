package jkartkowka.jkartkwkamobile;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private static final int NO_ANSWER = -1;

    private PopQuiz popQuiz;
    private List<Integer> userAnswers;
    private List<Integer> answerIndices;
    private int currentQuestionIndex;

    public StudentPopQuizInteractor(RequestSender requestSender, Context applicationContext) {
        super(requestSender, applicationContext);
        userAnswers = new ArrayList<>();
        answerIndices = new ArrayList<>();
        currentQuestionIndex = 0;
    }

    public void getPopQuiz(StandardGenericResponseHandler<PopQuiz> standardGenericResponseHandler) {
//        TODO Adam change it
//        jest tylko jedna kartkówka, tak?
        PopQuizRequest request = new PopQuizRequest(1, standardGenericResponseHandler);
        requestSender.sendRequest(request);
    }
    public void initialize(PopQuiz popQuiz) {
        this.popQuiz = popQuiz;
        userAnswers = new ArrayList<>();
        for(int i=0; i<popQuiz.getQuestionCount(); i++) {
            userAnswers.add(NO_ANSWER);
            answerIndices.add(NO_ANSWER);
        }
    }

    public void saveAnswer(boolean[] marked) {
        int answerIndex = NO_ANSWER;
        for (int i=0; i<marked.length; i++) {
            if(marked[i]) answerIndex = i;
        }
        if (answerIndex == NO_ANSWER) return;
        else  {
            int answerId = popQuiz.getAnswers(getCurrentQuestionIndex())[answerIndex].getId();
            userAnswers.set(currentQuestionIndex, answerId);
            answerIndices.set(currentQuestionIndex, answerIndex);
        }
    }

    public void sendAnswers() {
        JSONObject jsonAnswer = new JSONObject();
        JSONArray jsonAnswers = new JSONArray();
        JSONObject answersParcel = new JSONObject();
        int questionCount = popQuiz.getQuestionCount();

        try {
            for (int i = 0; i < questionCount; i++) {
                jsonAnswer.put("question_id", popQuiz.getQuestionId(i));
                jsonAnswer.put("answer_id", userAnswers.get(i));
                jsonAnswers.put(jsonAnswer);
            }

            answersParcel.put("test_id", popQuiz.id);
            answersParcel.put("answers", jsonAnswers);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //TODO send it
    }

    public boolean[] getSavedAnswers() {
        int index = answerIndices.get(currentQuestionIndex);
        boolean[] answers = new boolean[4];
        if (index != NO_ANSWER) answers[index] = true;
        return answers;
    }

    public void previousQuestion() {
        if(currentQuestionIndex > 0)
            currentQuestionIndex -= 1;
    }
    public void nextQuestion() {
        if(currentQuestionIndex < popQuiz.getQuestionCount() - 1)
            currentQuestionIndex += 1;
    }

    public int getSavedAnswerCount() {
        if(userAnswers.get(currentQuestionIndex) != NO_ANSWER)
            return 1;
        else return 0;
    }

    public String getQuestion() { return popQuiz.getQuestionContent(currentQuestionIndex); }

    public Answer[] getSuggestedAnswers() { return popQuiz.getAnswers(currentQuestionIndex); }

    public int getCurrentQuestionIndex() { return currentQuestionIndex; }

    public int getPopQuizQuestionCount() { return popQuiz.getQuestionCount(); }

    public int getCorrectAnswerCount() { return popQuiz.getCorrectAnswerCount(); }
}
