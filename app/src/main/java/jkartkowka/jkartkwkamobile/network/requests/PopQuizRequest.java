package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import jkartkowka.jkartkwkamobile.model.Answer;
import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by maciej on 30.12.15.
 */
public class PopQuizRequest implements StandardRequest {

    private final StandardGenericResponseHandler<PopQuiz> responseHandler;

    public PopQuizRequest(StandardGenericResponseHandler<PopQuiz> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public String apiMethod() {
        return "get_test";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }

    @Override
    public void parseSuccessResponse(JSONArray jsonQuizArray) {
        PopQuiz popQuiz = null;
        try {
            JSONObject jsonQuiz = (JSONObject) jsonQuizArray.get(0);
            String quizName = jsonQuiz.getString("name");
            int identifier = jsonQuiz.getInt("id");
            JSONArray jsonQuestionList = jsonQuiz.getJSONArray("questions");
            int questionCount = jsonQuestionList.length();

            // temporarily(?) unused parameter
            int correctAnswers = 1;

            List<Question> parsedQuestions = new ArrayList<>();
            for (int i = 0; i<questionCount; i++) {
                JSONObject jsonQuestion = (JSONObject) jsonQuestionList.get(i);
                int questionId = jsonQuestion.getInt("id");
                String questionContent = jsonQuestion.getString("content");

                JSONArray jsonAnswers = jsonQuestion.getJSONArray("answers");
                Answer[] parsedAnswers = new Answer[jsonAnswers.length()];
                for (int j = 0; j < jsonAnswers.length(); j++) {
                    JSONObject currentJsonAnswer = (JSONObject) jsonAnswers.get(j);
                    parsedAnswers[j] = new Answer(currentJsonAnswer.getInt("id"), currentJsonAnswer.toString());
                }
                parsedQuestions.add(new Question(questionId, questionContent, parsedAnswers));
            }
            popQuiz = new PopQuiz(identifier, quizName, questionCount, correctAnswers, 2.0f, parsedQuestions);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        responseHandler.onSuccess(popQuiz);
    }

    @Override
    public void mockedResponse() {
        int questionCount = 3;
        int correctAnswers = 1;

        Question[] questions = new Question[]{  new Question(1, "6+2?", new Answer[]{new Answer(1, "6"), new Answer(2, "7"), new Answer(3, "8"), new Answer(4, "9")}),
                                                new Question(2, "12-5?", new Answer[]{new Answer(5,"5"), new Answer(6, "7"), new Answer(7, "9"), new Answer(8, "11")}),
                                                new Question(3, "2+8?", new Answer[]{new Answer(9, "9"), new Answer(10, "10"), new Answer(11, "11"), new Answer(12, "1337")})};

        PopQuiz popQuiz = new PopQuiz(1, "Kartkówka " + 1, questionCount, correctAnswers, 2.0f, Arrays.asList(questions));
        responseHandler.onSuccess(popQuiz);
    }

    @Override
    public int restMethod() {
        return Request.Method.GET;
    }

    @Override
    public String endpoint() {
        return "tests";
    }
}
