package jkartkowka.jkartkwkamobile;

import android.content.Intent;

/**
 * Created by marian on 19.12.2015.
 */
public class GroupsListWireframe extends JKWireframe {
    public GroupsListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToAuthentication(int testId, int groupId) {
        Intent intent = new Intent(activity, AuthenticationActivity.class);
        intent.putExtra("testID", testId);
        intent.putExtra("groupID", groupId);
        activity.startActivity(intent);
    }
}
