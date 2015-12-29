package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.Group;

public class CheckGroupsListWireframe extends JKWireframe {
    public CheckGroupsListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToGroupMembersList(Group group) {
        Intent intent = new Intent(activity, GroupMembersListActivity.class);
        intent.putExtra("groupID", group.id);
        activity.startActivity(intent);
    }
}
