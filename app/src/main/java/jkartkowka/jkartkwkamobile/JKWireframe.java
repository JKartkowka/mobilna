package jkartkowka.jkartkwkamobile;

import android.content.Intent;

public class JKWireframe {

    protected final JKActivity activity;

    public JKWireframe(JKActivity activity) {
        this.activity = activity;
    }

    protected void makeIntent(Class<?> listActivityClass) {
        Intent intent = new Intent(activity, listActivityClass);
        activity.startActivity(intent);
    }

    protected void makeLauncherIntent(Class<?> listActivityClass) {
        Intent intent = new Intent(activity, listActivityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }

    public void back() {
        activity.finish();
    }
}
