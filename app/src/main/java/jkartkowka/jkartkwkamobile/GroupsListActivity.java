package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Group;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class GroupsListActivity extends JKListActivity {

    private GroupsListWireframe wireframe;
    private int popQuizId;
    private GroupsListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Group group = (Group) listView.getItemAtPosition(position);
                wireframe.navigateToAuthentication(popQuizId, group.id);
            }
        });
        titleLabel.setText("Wybierz grupę zajęciową, dla której chcesz przeprowadzić kartkówkę:");
        Intent intent = getIntent();
        popQuizId = intent.getIntExtra("popQuizID", -1);
        wireframe = new GroupsListWireframe(this);
        interactor = new GroupsListInteractor(new RequestSender(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.groupsList(new StandardGenericResponseHandler<ArrayList<Group>>() {
            @Override
            public void onSuccess(ArrayList<Group> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(ArrayList<Group> groupsList) {
        ArrayAdapter<Group> adapter = new ArrayAdapter<Group>(this, R.layout.layout_row, groupsList);
        listView.setAdapter(adapter);
    }
}
