package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class StudentPopQuizInfoActivity extends StudentActivity {

    private StudentPopQuizInfoWireframe wireframe;
    private AirplaneModeInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpopquizinfo);
        wireframe = new StudentPopQuizInfoWireframe(this);
        interactor = new AirplaneModeInteractor(new RequestSender(getApplicationContext()), getApplicationContext());
    }

    public void onAuthenticateClick(View v) {
        if (!interactor.isAirplaneModeOn()) {
            makeAirplaneModeToast();
            return;
        }
        wireframe.navigateToStudentAuthentication();
    }
}
