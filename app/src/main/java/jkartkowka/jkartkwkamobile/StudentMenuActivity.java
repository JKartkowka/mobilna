package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class StudentMenuActivity extends StudentActivity {
    private ImageButton buttonPopQuiz;
    private ImageButton buttonGrades;
    private ImageButton buttonLogOut;
    private StudentMenuWireframe wireframe;
    private StudentMenuInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentmenu);
        buttonPopQuiz = (ImageButton) findViewById(R.id.buttonPopQuiz);
        buttonGrades = (ImageButton) findViewById(R.id.buttonGrades);
        buttonLogOut = (ImageButton) findViewById(R.id.buttonLogOut);
        wireframe = new StudentMenuWireframe(this);
        interactor = new StudentMenuInteractor(new RequestSender(getApplicationContext()), getApplicationContext());
    }

    public void onPopQuizClick(View v) {
        if (!interactor.isAirplaneModeOn()) {
            makeAirplaneModeToast();
        } else {
            wireframe.navigateToPopQuizInfo();
        }
    }

    public void onGradesClick(View v) {
        wireframe.navigateToGradesList();
    }

    public void onLogOutClick(View v) {
        interactor.logout();
        wireframe.back();
    }

}
