package jkartkowka.jkartkwkamobile;

/**
 * Created by maciej on 29.12.15.
 */
public class StudentPopQuizWireframe extends JKWireframe {
    public StudentPopQuizWireframe(JKActivity activity) {
        super(activity);
    }

    public void navigateToMenu() {
        // because of StudentMenuActivity intent flag, this will go back to the specified,
        // already running activity, while finishing every other active activity
        activity.makeToast("Odpowiedzi zostały wysłane");
        makeLauncherIntent(StudentMenuActivity.class);
    }
}
