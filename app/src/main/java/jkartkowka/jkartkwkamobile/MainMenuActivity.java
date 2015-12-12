package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by maciej on 09.12.15.
 */
public class MainMenuActivity extends ActionBarActivity {
    private ImageButton buttonPopQuiz;
    private ImageButton buttonGroups;
    private ImageButton buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        buttonPopQuiz = (ImageButton) findViewById(R.id.buttonPopQuiz);
        buttonGroups = (ImageButton)findViewById(R.id.buttonGroups);
        buttonLogOut = (ImageButton) findViewById(R.id.buttonLogOut);
    }

    public void onPopQuizClick(View v){
        Toast.makeText(this, "Pop Quiz", Toast.LENGTH_SHORT).show();
    }

    public void onGroupsClick(View v){
        Toast.makeText(this, "Groups", Toast.LENGTH_SHORT).show();
    }

    public void onLogOutClick(View v) {
        Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show();
    }

}
