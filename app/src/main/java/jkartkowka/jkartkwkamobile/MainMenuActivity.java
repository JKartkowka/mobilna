package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by maciej on 09.12.15.
 */
public class MainMenuActivity extends ActionBarActivity {
    private Button buttonTest;
    private Button buttonGrades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        buttonTest = (Button) findViewById(R.id.buttonTest);
        buttonGrades=(Button)findViewById(R.id.buttonGrades);
    }

    public void onButtonTest(View v){
        Toast.makeText(this, "Kartkówka", Toast.LENGTH_SHORT).show();
    }

    public void onButtonGrades(View v){
        Toast.makeText(this, "Oceny", Toast.LENGTH_SHORT).show();
    }

}
