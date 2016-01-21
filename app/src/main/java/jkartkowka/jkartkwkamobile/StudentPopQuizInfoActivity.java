package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class StudentPopQuizInfoActivity extends StudentActivity {

    private StudentPopQuizInfoWireframe wireframe;
    private StudentPopQuizInfo interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpopquizinfo);
        wireframe = new StudentPopQuizInfoWireframe(this);
        interactor = new StudentPopQuizInfo(new RequestSender(getApplicationContext()), getApplicationContext(), getIntent());
    }

    public void onAuthenticateClick(View v) {
        if (!interactor.isAirplaneModeOn()) {
            makeAirplaneModeToast();
            return;
        }
        wireframe.navigateToStudentAuthentication(interactor.popQuizId);
    }
}
