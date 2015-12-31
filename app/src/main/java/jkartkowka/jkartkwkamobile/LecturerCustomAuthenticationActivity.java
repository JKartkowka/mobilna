package jkartkowka.jkartkwkamobile;

import android.os.Bundle;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class LecturerCustomAuthenticationActivity extends JKListActivity {

    private LecturerCustomAuthenticationInteractor interactor;
    private LecturerCustomAuthenticationWireframe wireframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_custom_authentication);
        interactor = new LecturerCustomAuthenticationInteractor(new RequestSender(getApplicationContext()));
        wireframe = new LecturerCustomAuthenticationWireframe(this);
    }

}
