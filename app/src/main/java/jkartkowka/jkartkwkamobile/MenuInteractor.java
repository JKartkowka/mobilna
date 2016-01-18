package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 18.01.2016.
 */
public class MenuInteractor extends JKInteractor{
    public MenuInteractor(RequestSender requestSender) {
        super(requestSender);
    }

    public void logout() {
        requestSender.clearCredentials();
    }
}
