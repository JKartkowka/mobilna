package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by maciej on 09.12.15.
 */
public class MainMenuActivity extends ActionBarActivity {
    private ImageButton buttonKartkowka;
    private ImageButton buttonGrupy;
    private ImageButton buttonWyloguj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        buttonKartkowka = (ImageButton) findViewById(R.id.buttonKartkowka);
        buttonGrupy = (ImageButton)findViewById(R.id.buttonGrupy);
        buttonWyloguj = (ImageButton) findViewById(R.id.buttonWyloguj);
    }

    public void onButtonKartkowka(View v){
        Toast.makeText(this, "Kartkówka", Toast.LENGTH_SHORT).show();
    }

    public void onButtonGrupy(View v){
        Toast.makeText(this, "Grupy", Toast.LENGTH_SHORT).show();
    }

    public void onButtonWyloguj(View v) {
        Toast.makeText(this, "Wyloguj", Toast.LENGTH_SHORT).show();
    }

}
