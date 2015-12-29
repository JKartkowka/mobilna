package jkartkowka.jkartkwkamobile;

public class LecturerMenuWireframe extends JKWireframe {

    public LecturerMenuWireframe(LecturerMenuActivity lecturerMenuActivity) {
        super(lecturerMenuActivity);
    }

    public void navigateToTestsList() {
        makeIntent(TestsListActivity.class);
    }

    public void navigateToCheckGroupsList() { makeIntent(CheckGroupsListActivity.class);}
}
