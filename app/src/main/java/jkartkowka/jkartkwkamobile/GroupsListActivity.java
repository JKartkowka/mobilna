package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;

import jkartkowka.jkartkwkamobile.network.RequestSender;

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
}
