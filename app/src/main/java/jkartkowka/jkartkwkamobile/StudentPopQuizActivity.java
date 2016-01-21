package jkartkowka.jkartkwkamobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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
    protected ImageButton buttonPrevious, buttonNext, buttonFinish;
    private StudentPopQuizWireframe wireframe;
    private StudentPopQuizInteractor interactor;
    ImageTextArrayAdapter adapter;
    private boolean[] marked = new boolean[4];
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popquiz_multiple_answer);
        interactor = new StudentPopQuizInteractor(new RequestSender(getApplicationContext()), getApplicationContext());
        wireframe = new StudentPopQuizWireframe(this);
        adapter = new ImageTextArrayAdapter(this, new String[]{"0", "0", "0", "0"}, marked);

        buttonPrevious = (ImageButton) findViewById(R.id.buttonPrevious);
        buttonNext = (ImageButton) findViewById(R.id.buttonNext);
        buttonFinish = (ImageButton) findViewById(R.id.buttonFinish);

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
        currentQuestionIndex = interactor.getCurrentQuestionIndex();
        marked = interactor.getSavedAnswers();
        questionNumberLabel.setText(String.valueOf(currentQuestionIndex + 1));
        titleLabel.setText(interactor.getQuestion());
        String[] answers = interactor.getSuggestedAnswers();
        adapter = new ImageTextArrayAdapter(this, answers, marked);
        listView.setAdapter(adapter);
    }

    public void onPreviousQuestionClick(View v) {
        if (currentQuestionIndex == 1)
            buttonPrevious.setVisibility(View.INVISIBLE);
        if (currentQuestionIndex == interactor.getPopQuizQuestionCount() - 1)
            buttonNext.setVisibility(View.VISIBLE);

        interactor.saveAnswer(marked);
        interactor.previousQuestion();
        reloadData();
    }

    public void onNextQuestionClick(View v) {
        if (currentQuestionIndex == 0)
            buttonPrevious.setVisibility(View.VISIBLE);
        if (currentQuestionIndex == interactor.getPopQuizQuestionCount() - 2) {
            buttonFinish.setVisibility(View.VISIBLE);
            buttonNext.setVisibility(View.INVISIBLE);
        }
        interactor.saveAnswer(marked);
        interactor.nextQuestion();
        reloadData();
    }

    public void onFinishPopQuizClick(View v) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int source) {
                if(source == DialogInterface.BUTTON_POSITIVE)
                    finish();
                    wireframe.navigateToMenu();
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Czy na pewno chcesz zakończyć kartkówkę?").setPositiveButton("Tak", dialogClickListener)
                .setNegativeButton("Nie", dialogClickListener).show();
    }

}
