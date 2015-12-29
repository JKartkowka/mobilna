package jkartkowka.jkartkwkamobile;

public class LecturerAuthenticationWireframe extends JKWireframe {
    public LecturerAuthenticationWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToPopQuiz() {
        makeIntent(LecturerPopQuizActivity.class);
    }
}
