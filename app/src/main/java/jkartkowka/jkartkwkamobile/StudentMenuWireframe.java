package jkartkowka.jkartkwkamobile;

public class StudentMenuWireframe extends JKWireframe {

    public StudentMenuWireframe(StudentMenuActivity studentMenuActivity) {
        super(studentMenuActivity);
    }

    public void navigateToGradesList() {
        makeIntent(GradesListActivity.class);
    }

    public void navigateToPopQuizList() {
        makeIntent(StudentPopQuizListActivity.class);
    }
}
