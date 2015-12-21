package jkartkowka.jkartkwkamobile;

import android.content.Intent;

/**
 * Created by marian on 19.12.2015.
 */
public class JKWireframe {

    protected final JKActivity activity;

    public JKWireframe(JKActivity activity) {
        this.activity = activity;
    }

    protected void makeIntent(Class<?> testsListActivityClass) {
        Intent intent = new Intent(activity, testsListActivityClass);
        activity.startActivity(intent);
    }
}
