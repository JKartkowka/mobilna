package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import jkartkowka.jkartkwkamobile.model.Question;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

/**
 * Created by maciej on 29.12.15.
 */
public class MultipleAnswerPopQuizActivity extends JKListActivity {
    private MultipleAnswerPopQuizWireframe wireframe;
    private MultipleAnswerPopQuizInteractor interactor;
    private ImageView indicator;
    protected ListView listView;
    protected TextView titleLabel;
    ImageTextArrayAdapter adapter;
    private boolean[] marked = new boolean[4];
    private Button back; //TODO implement buttons
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popquiz_multiple_answer);
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
        titleLabel.setText(question.toString());
        String[] answers = question.answersList();
        adapter = new ImageTextArrayAdapter(this, answers, marked);
        listView.setAdapter(adapter);
    }

}
