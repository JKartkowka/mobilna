package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

/**
 * Created by maciej on 29.12.15.
 */
public class MultipleAnswerPopQuizActivity extends JKActivity {
    private ListView listView;
    private MultipleAnswerPopQuizWireframe wireframe;
    private MultipleAnswerPopQuizInteractor interactor;
    protected TextView titleLabel;
    ImageTextArrayAdapter adapter;
    private boolean[] marked = new boolean[4];
    private Button back; //TODO implement buttons
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        interactor = new MultipleAnswerPopQuizInteractor(new RequestSender(getApplicationContext()));
        setContentView(R.layout.activity_popquiz_multiple_answer);
        adapter = new ImageTextArrayAdapter(this, new String[]{"0", "0", "0", "0"}, marked);
        listView = (ListView)findViewById(R.id.MultipleAnswerQuestionListView);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                marked[position] = !marked[position];
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.question(new StandardGenericResponseHandler<Question>() {
            @Override
            public void onSuccess(Question responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(Question question) {
        titleLabel = (TextView) findViewById(R.id.PopQuizMultipleAnswerQuestion);
        titleLabel.setText(question.toString());
        String[] answers = question.answersList();
        adapter = new ImageTextArrayAdapter(this, answers, marked);
        listView.setAdapter(adapter);
    }

}
