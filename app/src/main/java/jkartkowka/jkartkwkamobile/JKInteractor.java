package jkartkowka.jkartkwkamobile;

import jkartkowka.jkartkwkamobile.network.RequestSender;

public class JKInteractor {

    protected final RequestSender requestSender;

    public JKInteractor(RequestSender requestSender) {
        this.requestSender = requestSender;
    }
}
