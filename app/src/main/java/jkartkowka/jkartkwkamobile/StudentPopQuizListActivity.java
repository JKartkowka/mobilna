package jkartkowka.jkartkwkamobile;

import android.view.View;
import android.widget.AdapterView;

import jkartkowka.jkartkwkamobile.model.PopQuiz;

/**
 * Created by marian on 21.01.2016.
 */
public class StudentPopQuizListActivity extends PopQuizListActivity {

    private StudentPopQuizListWireframe wireframe;

    @Override
    protected void configure() {
        wireframe = new StudentPopQuizListWireframe(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopQuiz popQuiz = (PopQuiz) listView.getItemAtPosition(position);
                wireframe.navigateToAuthentication(popQuiz);
            }
        });
        titleLabel.setText("Wybierz kartkówkę, którą chcesz napisać:");
    }
}
