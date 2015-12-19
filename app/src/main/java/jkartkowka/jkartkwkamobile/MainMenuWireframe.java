package jkartkowka.jkartkwkamobile;

import android.content.Intent;

/**
 * Created by marian on 19.12.2015.
 */
public class MainMenuWireframe {
    private final MainMenuActivity activity;

    public MainMenuWireframe(MainMenuActivity mainMenuActivity) {
        this.activity = mainMenuActivity;
    }

    public void navigateToTestsList() {
        makeIntent(TestsListActivity.class);
    }

    private void makeIntent(Class<?> testsListActivityClass) {
        Intent intent = new Intent(activity, testsListActivityClass);
        activity.startActivity(intent);
    }
}
