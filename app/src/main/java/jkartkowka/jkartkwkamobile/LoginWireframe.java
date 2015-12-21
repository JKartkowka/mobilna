package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 19.12.2015.
 */
public class LoginWireframe extends JKWireframe {
    public LoginWireframe(LoginActivity activity) {
        super(activity);
    }

    public void navigateToMenu() {
        makeIntent(MainMenuActivity.class);
    }
}
