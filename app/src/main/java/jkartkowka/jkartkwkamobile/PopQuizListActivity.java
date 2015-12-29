package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.PopQuiz;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class PopQuizListActivity extends JKListActivity {

    private PopQuizListWireframe wireframe;
    private PopQuizListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopQuiz popQuiz = (PopQuiz) listView.getItemAtPosition(position);
                wireframe.navigateToGroupsWithPopQuiz(popQuiz);
            }
        });
        titleLabel.setText("Wybierz kartkówkę, którą chcesz przeprowadzić:");
        wireframe = new PopQuizListWireframe(this);
        RequestSender requestSender = new RequestSender(getApplicationContext());
        interactor = new PopQuizListInteractor(requestSender);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.popQuizList(new StandardGenericResponseHandler<ArrayList<PopQuiz>>() {
            @Override
            public void onSuccess(ArrayList<PopQuiz> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(ArrayList<PopQuiz> popQuizList) {
        ArrayAdapter<PopQuiz> adapter = new ArrayAdapter<PopQuiz>(this, R.layout.layout_row, popQuizList);
        listView.setAdapter(adapter);
    }

}
