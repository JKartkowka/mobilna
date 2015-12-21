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

public class TestsListActivity extends JKListActivity {

    private TestsListWireframe wireframe;
    private TestsListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JKTest test = (JKTest) listView.getItemAtPosition(position);
                wireframe.navigateToGroupsWithTest(test);
            }
        });
        titleLabel.setText("Wybierz kartkówkę, którą chcesz przeprowadzić:");
        wireframe = new TestsListWireframe(this);
        RequestSender requestSender = new RequestSender(getApplicationContext());
        interactor = new TestsListInteractor(requestSender);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.testsList(new StandardGenericResponseHandler<ArrayList<JKTest>>() {
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

    private void reloadData(ArrayList<JKTest> testsList) {
        ArrayAdapter<JKTest> adapter = new ArrayAdapter<JKTest>(this, R.layout.layout_row, testsList);
        listView.setAdapter(adapter);
    }

}
