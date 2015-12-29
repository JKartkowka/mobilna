package jkartkowka.jkartkwkamobile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import jkartkowka.jkartkwkamobile.model.JKTest;

public class GradesListWireframe extends JKWireframe {
    public GradesListWireframe(JKActivity activity) {
        super(activity);
    }

    public void showTestResult(JKTest chosenPopQuiz, Context applicationContext) {
        AlertDialog.Builder alert = new AlertDialog.Builder(applicationContext);
        alert.setTitle("Wyniki kartkówki\n" + "(" + chosenPopQuiz.getName() + ")");
        alert.setMessage("Zdobyłeś " + chosenPopQuiz.getResult() + " punktów.\nTwoja ocena to: " + chosenPopQuiz.getGrade());
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });
        alert.show();
    }
}