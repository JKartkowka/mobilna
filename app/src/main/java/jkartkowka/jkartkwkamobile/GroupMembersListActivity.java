package jkartkowka.jkartkwkamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.model.Student;

public class GroupMembersListActivity extends JKListActivity {
    private GroupMembersListWireframe wireframe;
    private int groupID;
    private GroupMembersListInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) listView.getItemAtPosition(position);
                makeToast(student.toString());
            }
        });
        titleLabel.setText("Lista osób w grupie zajęciowej");
        Intent intent = getIntent();
        groupID = intent.getIntExtra("groupID", -1);
        wireframe = new GroupMembersListWireframe(this);
        interactor = new GroupMembersListInteractor(new RequestSender(getApplicationContext()));
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
