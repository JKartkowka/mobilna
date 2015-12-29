package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.model.UserType;

public class LoginWireframe extends JKWireframe {
    public LoginWireframe(LoginActivity activity) {
        super(activity);
    }

    public void navigateToMenu(UserType userType) {
        if(userType == UserType.UTStudent)
            makeIntent(StudentMenuActivity.class);
        else if(userType == UserType.UTLecturer)
            makeIntent(LecturerMenuActivity.class);
    }
}
