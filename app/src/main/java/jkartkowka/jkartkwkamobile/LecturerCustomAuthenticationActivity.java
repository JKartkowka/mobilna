package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.adapters.StudentListAdapter;
import jkartkowka.jkartkwkamobile.model.StudentListItem;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LecturerCustomAuthenticationActivity extends JKActivity {

    private LecturerCustomAuthenticationInteractor interactor;
    private LecturerCustomAuthenticationWireframe wireframe;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_custom_authentication);
        interactor = new LecturerCustomAuthenticationInteractor(new RequestSender(getApplicationContext()), getIntent());
        wireframe = new LecturerCustomAuthenticationWireframe(this);
        listView = (ListView) findViewById(R.id.listView2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.getStudents(new StandardGenericResponseHandler<ArrayList<StudentListItem>>() {
            @Override
            public void onSuccess(ArrayList<StudentListItem> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    private void reloadData(ArrayList<StudentListItem> students) {
        StudentListAdapter adapter = new StudentListAdapter(this, R.layout.layout_student_list_row, students);
        listView.setAdapter(adapter);
    }
}
