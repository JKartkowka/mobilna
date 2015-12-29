package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class LecturerMenuActivity extends JKActivity {
    private ImageButton buttonPopQuiz;
    private ImageButton buttonGroups;
    private ImageButton buttonLogOut;
    private LecturerMenuWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturermenu);
        buttonPopQuiz = (ImageButton) findViewById(R.id.buttonPopQuiz);
        buttonGroups = (ImageButton) findViewById(R.id.buttonGroups);
        buttonLogOut = (ImageButton) findViewById(R.id.buttonLogOut);
        wireframe = new LecturerMenuWireframe(this);
    }

    public void onPopQuizClick(View v) {
        wireframe.navigateToTestsList();
    }

    public void onGroupsClick(View v) {
        wireframe.navigateToCheckGroupsList();
    }

    public void onLogOutClick(View v) {
        Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
    }

}
