package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class GroupMembersListActivity extends JKListActivity {
    private GroupMembersListWireframe wireframe;
    private GroupMembersListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        titleLabel.setText("Lista osób w grupie zajęciowej");
        wireframe = new GroupMembersListWireframe(this);
        interactor = new GroupMembersListInteractor(new RequestSender(getApplicationContext()), getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.groupMembers(new StandardGenericResponseHandler<ArrayList<Student>>() {
            @Override
            public void onSuccess(ArrayList<Student> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                makeToast(error.toString());
            }
        });
    }

    private void reloadData(ArrayList<Student> groupsList) {
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.layout_row, groupsList);
        listView.setAdapter(adapter);
    }
}
