package jkartkowka.jkartkwkamobile;

public class StudentAuthenticationWireframe extends JKWireframe {
    public StudentAuthenticationWireframe(JKActivity activity) {
        super(activity);
    }

    public void startPopQuiz() {
        makeIntent(StudentPopQuizActivity.class);
    }
}
