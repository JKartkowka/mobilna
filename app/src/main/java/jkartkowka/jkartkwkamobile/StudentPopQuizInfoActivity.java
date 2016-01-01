package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;

public class StudentPopQuizInfoActivity extends JKActivity {

    private StudentPopQuizInfoWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpopquizinfo);
        wireframe = new StudentPopQuizInfoWireframe(this);
    }

    public void onAuthenticateClick(View v) {
        wireframe.navigateToStudentAuthentication();
    }
}
