package jkartkowka.jkartkwkamobile;

public class LecturerMenuWireframe extends JKWireframe {

    public LecturerMenuWireframe(LecturerMenuActivity lecturerMenuActivity) {
        super(lecturerMenuActivity);
    }

    public void navigateToPopQuizList() {
        makeIntent(PopQuizListActivity.class);
    }

    public void navigateToCheckGroupsList() {
        makeIntent(CheckGroupsListActivity.class);
    }

}
