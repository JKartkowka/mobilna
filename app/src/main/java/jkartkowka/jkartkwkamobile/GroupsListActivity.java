package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

/**
 * Created by marian on 19.12.2015.
 */
public class GroupsListActivity extends JKListActivity {

    private GroupsListWireframe wireframe;
    private int testId;
    private GroupsListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleLabel.setText("Wybierz grupę zajęciową, dla której chcesz przeprowadzić kartkówkę:");
        Intent intent = getIntent();
        testId = intent.getIntExtra("testID", -1);
        wireframe = new GroupsListWireframe(this);
        interactor = new GroupsListInteractor(new RequestSender(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.groupsList(new StandardGenericResponseHandler<ArrayList<JKGroup>>() {
            @Override
            public void onSuccess(ArrayList<JKGroup> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(ArrayList<JKGroup> responseObject) {

    }
}
