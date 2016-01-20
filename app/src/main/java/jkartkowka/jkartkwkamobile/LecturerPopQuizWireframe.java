package jkartkowka.jkartkwkamobile;

import android.content.Intent;

/**
 * Created by marian on 29.12.2015.
 */
public class LecturerPopQuizWireframe extends JKWireframe {
    public LecturerPopQuizWireframe(JKActivity activity) {
        super(activity);
    }

    public void backToMenu() {
        Intent intent = new Intent(activity, LecturerMenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        activity.startActivity(intent);
    }
}
