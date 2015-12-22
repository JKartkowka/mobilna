package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.JKGroup;

/**
 * Created by maciej on 22.12.15.
 */
public class CheckGroupsListWireframe extends JKWireframe {
    public CheckGroupsListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToGroupMembersList(JKGroup group) {
        Intent intent = new Intent(activity, GroupMembersListActivity.class);
        intent.putExtra("groupID", group.id);
        activity.startActivity(intent);
    }
}
