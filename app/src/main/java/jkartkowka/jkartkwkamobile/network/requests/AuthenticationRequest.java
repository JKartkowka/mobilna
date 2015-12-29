package jkartkowka.jkartkwkamobile.network.requests;

import jkartkowka.jkartkwkamobile.model.User;

public interface AuthenticationRequest extends JKRequest {
    User mockedResponse();

    void onSuccess(User user);
}
