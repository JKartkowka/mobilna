package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class GradesListActivity extends JKListActivity {

    private GradesListWireframe wireframe;
    private GradesListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JKTest test = (JKTest) listView.getItemAtPosition(position);
                wireframe.showTestResult(test, GradesListActivity.this);
            }
        });
        titleLabel.setText("Wybierz kartkówkę, której wynik chcesz zobaczyć:");
        wireframe = new GradesListWireframe(this);
        RequestSender requestSender = new RequestSender(getApplicationContext());
        interactor = new GradesListInteractor(requestSender);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.gradesList(new StandardGenericResponseHandler<ArrayList<JKTest>>() {
            @Override
            public void onSuccess(ArrayList<JKTest> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(ArrayList<JKTest> gradesList) {
        ArrayAdapter<JKTest> adapter = new ArrayAdapter<JKTest>(this, R.layout.layout_row, gradesList);
        listView.setAdapter(adapter);
    }

}
