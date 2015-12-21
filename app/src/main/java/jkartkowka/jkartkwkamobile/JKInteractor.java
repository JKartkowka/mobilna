package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.network.RequestSender;

/**
 * Created by marian on 19.12.2015.
 */
public class JKInteractor {

    protected final RequestSender requestSender;

    public JKInteractor(RequestSender requestSender) {
        this.requestSender = requestSender;
    }
}
