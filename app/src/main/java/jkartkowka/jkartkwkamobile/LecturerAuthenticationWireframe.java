package jkartkowka.jkartkwkamobile;

import android.content.Intent;

public class LecturerAuthenticationWireframe extends JKWireframe {
    public LecturerAuthenticationWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToPopQuiz(String popQuizName, String groupName) {
        Intent intent = new Intent(activity, LecturerPopQuizActivity.class);
        intent.putExtra("popQuizName", popQuizName);
        intent.putExtra("groupName", groupName);
        activity.startActivity(intent);
    }

    public void navigateToCustomConfirmation(int groupId, int popQuizId) {
        Intent intent = new Intent(activity, LecturerCustomAuthenticationActivity.class);
        intent.putExtra("popQuizId", popQuizId);
        intent.putExtra("groupId", groupId);
        activity.startActivity(intent);
    }
}
