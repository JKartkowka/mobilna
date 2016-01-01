package jkartkowka.jkartkwkamobile;

public class StudentMenuWireframe extends JKWireframe {

    public StudentMenuWireframe(StudentMenuActivity studentMenuActivity) {
        super(studentMenuActivity);
    }

    public void navigateToPopQuizInfo() { makeIntent(StudentPopQuizInfoActivity.class);}

    public void navigateToGradesList() { makeIntent(GradesListActivity.class);}

}
