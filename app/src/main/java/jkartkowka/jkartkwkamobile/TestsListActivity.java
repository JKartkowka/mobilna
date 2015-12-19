package jkartkowka.jkartkwkamobile;

import android.os.Bundle;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKTest;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class TestsListActivity extends JKActivity {

    private TestsListWireframe wireframe;
    private TestsListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_list);
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
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }
}
