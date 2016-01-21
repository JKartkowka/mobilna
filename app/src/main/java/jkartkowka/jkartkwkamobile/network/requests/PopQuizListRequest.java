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

public class PopQuizListRequest implements StandardRequest {
    private final StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler;

    public PopQuizListRequest(StandardGenericResponseHandler<ArrayList<PopQuiz>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public String apiMethod() {
        return "list";
    }

    @Override
    public HashMap<String, Object> params() {
        return new HashMap<>();
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }


    @Override
    public void parseSuccessResponse(JSONArray response) {

        Random randomGenerator = new Random();
        ArrayList<PopQuiz> popQuizList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject jsonQuiz = (JSONObject) response.get(i);
                //int key = jsonQuiz.getInt("key") //for later
                int identifier = jsonQuiz.getInt("id");
                String quizName = jsonQuiz.getString("name");
                JSONArray jsonQuestionList = jsonQuiz.getJSONArray("questions");
                int questionCount = jsonQuestionList.length();
//                TODO how to get from server number of correct answers?
                int correctAnswers = randomGenerator.nextInt(questionCount);
//                TODO how to get from server grade?

                List<Question> parsedQuestions = new ArrayList<>();
                for (int j = 0; j < questionCount; j++) {
                    JSONObject jsonQuestion = (JSONObject) jsonQuestionList.get(j);
                    int questionId = jsonQuestion.getInt("id");
                    String questionContent = jsonQuestion.getString("content");

                    JSONArray jsonAnswers = jsonQuestion.getJSONArray("answers");
                    Answer[] parsedAnswers = new Answer[jsonAnswers.length()];
                    for (int k = 0; k < jsonAnswers.length(); k++) {
                        JSONObject currentJsonAnswer = (JSONObject) jsonAnswers.get(k);
                        parsedAnswers[k] = new Answer(currentJsonAnswer.getInt("id"), currentJsonAnswer.toString());
                    }
                    parsedQuestions.add(new Question(questionId, questionContent, parsedAnswers));
                }
                PopQuiz popQuiz = new PopQuiz(identifier, quizName, questionCount, correctAnswers, 2.0f, parsedQuestions);
                popQuizList.add(popQuiz);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        responseHandler.onSuccess(popQuizList);
    }

    @Override
    public void mockedResponse() {
        ArrayList<PopQuiz> popQuizList = new ArrayList<>();

        Question[] questions = new Question[]{  new Question(1, "6+2?", new Answer[]{new Answer(1, "6"), new Answer(2, "7"), new Answer(3, "8"), new Answer(4, "9")}),
                new Question(2, "12-5?", new Answer[]{new Answer(5,"5"), new Answer(6, "7"), new Answer(7, "9"), new Answer(8, "11")}),
                new Question(3, "2+8?", new Answer[]{new Answer(9, "9"), new Answer(10, "10"), new Answer(11, "11"), new Answer(12, "1337")})};

        for (int i = 1; i <= 10; i++) {
            int questionCount = 3;
            int correctAnswers = 1;
            PopQuiz popQuiz = new PopQuiz(i, "Kartkówka " + i, questionCount, correctAnswers, 2.0f, Arrays.asList(questions));
            popQuizList.add(popQuiz);
        }

        responseHandler.onSuccess(popQuizList);
    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "tests";
    }
}