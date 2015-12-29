package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.PopQuiz;

public class PopQuizListWireframe extends JKWireframe {
    public PopQuizListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToGroupsWithPopQuiz(PopQuiz popQuiz) {
        Intent intent = new Intent(activity, GroupsListActivity.class);
        intent.putExtra("popQuizID", popQuiz.id);
        activity.startActivity(intent);
    }
}
