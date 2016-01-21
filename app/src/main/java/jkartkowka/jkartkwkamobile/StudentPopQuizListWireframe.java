package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.PopQuiz;

/**
 * Created by marian on 21.01.2016.
 */
public class StudentPopQuizListWireframe extends JKWireframe {

    public StudentPopQuizListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToAuthentication(PopQuiz popQuiz) {
        Intent intent = new Intent(activity, StudentPopQuizInfoActivity.class);
        intent.putExtra("popQuizID", popQuiz.id);

        activity.startActivity(intent);
    }
}
