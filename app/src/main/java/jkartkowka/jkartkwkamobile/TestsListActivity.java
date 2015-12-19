package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class TestsListActivity extends JKActivity {

    private TestsListWireframe wireframe;
    private TestsListInteractor interactor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_list);
        listView = (ListView) findViewById(R.id.listView);
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
