package jkartkowka.jkartkwkamobile;

import android.content.Intent;

public class LecturerStandardAuthenticationWireframe extends LecturerAuthenticationWireframe {
    public LecturerStandardAuthenticationWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToCustomConfirmation(int groupId, int popQuizId) {
        Intent intent = new Intent(activity, LecturerCustomAuthenticationActivity.class);
        intent.putExtra("popQuizId", popQuizId);
        intent.putExtra("groupId", groupId);
        activity.startActivity(intent);
    }
}
