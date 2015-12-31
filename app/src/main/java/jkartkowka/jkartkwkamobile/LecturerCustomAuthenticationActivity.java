package jkartkowka.jkartkwkamobile;

import android.os.Bundle;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class LecturerCustomAuthenticationActivity extends JKActivity {

    private LecturerCustomAuthenticationInteractor interactor;
    private LecturerCustomAuthenticationWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_custom_authentication);
        interactor = new LecturerCustomAuthenticationInteractor(new RequestSender(getApplicationContext()), getIntent());
        wireframe = new LecturerCustomAuthenticationWireframe(this);
    }

}
