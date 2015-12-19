package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 19.12.2015.
 */
public class MainMenuWireframe extends JKWireframe {

    public MainMenuWireframe(MainMenuActivity mainMenuActivity) {
        super(mainMenuActivity);
    }

    public void navigateToTestsList() {
        makeIntent(TestsListActivity.class);
    }

}
