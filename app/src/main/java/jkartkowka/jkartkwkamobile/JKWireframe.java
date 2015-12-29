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
}
