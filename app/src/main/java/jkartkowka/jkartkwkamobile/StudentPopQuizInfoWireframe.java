package jkartkowka.jkartkwkamobile;

import android.content.Intent;

public class StudentPopQuizInfoWireframe extends JKWireframe {
    public StudentPopQuizInfoWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToStudentAuthentication(int popQuizId) {
        Intent intent = new Intent(activity, StudentAuthenticationActivity.class);
        intent.putExtra("popQuizID", popQuizId);

        activity.startActivity(intent);
    }
}