package jkartkowka.jkartkwkamobile;

import android.content.Intent;

import jkartkowka.jkartkwkamobile.model.JKTest;

/**
 * Created by marian on 19.12.2015.
 */
public class TestsListWireframe extends JKWireframe {
    public TestsListWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToGroupsWithTest(JKTest test) {
        Intent intent = new Intent(activity, GroupsListActivity.class);
        intent.putExtra("testID", test.id);
        activity.startActivity(intent);
    }
}
