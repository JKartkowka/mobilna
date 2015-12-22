package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.JKGroup;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

/**
 * Created by maciej on 22.12.15.
 */
public class CheckGroupsListActivity extends JKListActivity {

    private GroupsListWireframe wireframe;
    private int testId;
    private GroupsListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JKGroup group = (JKGroup) listView.getItemAtPosition(position);
                makeToast(group.toString());
            }
        });
        titleLabel.setText("Wybierz grupę zajęciową, którą chcesz przejrzeć:");
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

    private void reloadData(ArrayList<JKGroup> groupsList) {
        ArrayAdapter<JKGroup> adapter = new ArrayAdapter<JKGroup>(this, R.layout.layout_row, groupsList);
        listView.setAdapter(adapter);
    }
}
