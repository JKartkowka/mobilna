package jkartkowka.jkartkwkamobile;

import android.os.Bundle;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.model.Student;
import jkartkowka.jkartkwkamobile.network.ErrorHandler;
import jkartkowka.jkartkwkamobile.network.RequestSender;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;

public class LecturerCustomAuthenticationActivity extends JKActivity {

    private LecturerCustomAuthenticationInteractor interactor;
    private LecturerCustomAuthenticationWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_custom_authentication);
        interactor = new LecturerCustomAuthenticationInteractor(new RequestSender(getApplicationContext()), getIntent());
        wireframe = new LecturerCustomAuthenticationWireframe(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        interactor.getStudents(new StandardGenericResponseHandler<ArrayList<Student>>() {
            @Override
            public void onSuccess(ArrayList<Student> responseObject) {
                reloadData(responseObject);
            }

            @Override
            public void onFailure(ErrorHandler error) {
                super.onFailure(error);
            }
        });
    }

    private void reloadData(ArrayList<Student> students) {

    }
}
