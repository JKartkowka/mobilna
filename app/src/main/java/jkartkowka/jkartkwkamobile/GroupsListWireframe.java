package jkartkowka.jkartkwkamobile;

import android.content.Intent;

public class GroupsListWireframe extends JKWireframe {
    public GroupsListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToAuthentication(int popQuizId, int groupId) {
        Intent intent = new Intent(activity, LecturerAuthenticationActivity.class);
        intent.putExtra("popQuizID", popQuizId);
        intent.putExtra("groupID", groupId);
        activity.startActivity(intent);
    }
}
