package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

/**
 * Created by maciej on 29.12.15.
 */
public class StudentPopQuizActivity extends StudentActivity {
    private ListView listView;
    protected TextView questionNumberLabel;
    protected TextView titleLabel;
    private StudentPopQuizWireframe wireframe;
    private StudentPopQuizInteractor interactor;
    ImageTextArrayAdapter adapter;
    private boolean[] marked = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popquiz_multiple_answer);
        interactor = new StudentPopQuizInteractor(new RequestSender(getApplicationContext()), getApplicationContext());
        wireframe = new StudentPopQuizWireframe(this);
        adapter = new ImageTextArrayAdapter(this, new String[]{"0", "0", "0", "0"}, marked);

        questionNumberLabel = (TextView) findViewById(R.id.QuestionNumber);
        titleLabel = (TextView) findViewById(R.id.PopQuizMultipleAnswerQuestion);
        listView = (ListView) findViewById(R.id.MultipleAnswerQuestionListView);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                marked[position] = !marked[position];
                adapter.notifyDataSetChanged();
            }
        });

        interactor.getPopQuiz(new StandardGenericResponseHandler<PopQuiz>() {
            @Override
            public void onSuccess(PopQuiz responseObject) {
                interactor.initialize(responseObject);
                reloadData();
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!interactor.isAirplaneModeOn()) {
            makeAirplaneModeToast();
            wireframe.back();
            return;
        }
        reloadData();
    }

    private void reloadData() {
        marked = interactor.getSavedAnswers();
        questionNumberLabel.setText(String.valueOf(interactor.getCurrentQuestionIndex() + 1));
        titleLabel.setText(interactor.getQuestion());
        String[] answers = interactor.getSuggestedAnswers();
        adapter = new ImageTextArrayAdapter(this, answers, marked);
        listView.setAdapter(adapter);
    }
    public void onPreviousQuestionClick(View v) {
        interactor.saveAnswer(marked);
        interactor.previousQuestion();
        reloadData();
    }

    public void onNextQuestionClick(View v) {
        // TODO add a finishButton and display a dialog on click
        if(interactor.getCurrentQuestionIndex() == 2) wireframe.finishPopQuiz();
        interactor.saveAnswer(marked);
        interactor.nextQuestion();
        reloadData();
    }

}
