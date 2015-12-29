package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class StudentMenuActivity extends JKActivity {
    private ImageButton buttonPopQuiz;
    private ImageButton buttonGrades;
    private ImageButton buttonLogOut;
    private StudentMenuWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentmenu);
        buttonPopQuiz = (ImageButton) findViewById(R.id.buttonPopQuiz);
        buttonGrades = (ImageButton) findViewById(R.id.buttonGrades);
        buttonLogOut = (ImageButton) findViewById(R.id.buttonLogOut);
        wireframe = new StudentMenuWireframe(this);
    }

    public void onPopQuizClick(View v) {
        Toast.makeText(this, "Proceed to student authentication", Toast.LENGTH_SHORT).show();
    }

    public void onGradesClick(View v) {
        wireframe.navigateToGradesList();
    }

    public void onLogOutClick(View v) {
        Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
    }

}
