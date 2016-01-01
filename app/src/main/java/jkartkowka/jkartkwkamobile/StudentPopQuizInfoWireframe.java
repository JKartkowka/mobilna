package jkartkowka.jkartkwkamobile;

public class StudentPopQuizInfoWireframe extends JKWireframe {
    public StudentPopQuizInfoWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToStudentAuthentication() {
        makeIntent(StudentAuthenticationActivity.class);
    }
}