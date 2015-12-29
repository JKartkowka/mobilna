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
}
