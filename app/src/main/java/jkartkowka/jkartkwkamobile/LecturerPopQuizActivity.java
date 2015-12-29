package jkartkowka.jkartkwkamobile;

import android.os.Bundle;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class LecturerPopQuizActivity extends JKActivity {

    private LecturerPopQuizWireframe wireframe;
    private LecturerPopQuizInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_pop_quiz);
        wireframe = new LecturerPopQuizWireframe(this);
        interactor = new LecturerPopQuizInteractor(new RequestSender(getApplicationContext()));
    }

}
