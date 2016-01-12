package jkartkowka.jkartkwkamobile.network;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

public interface StandardRequest extends JKRequest {

    void parseSuccessResponse(HashMap<String, Object> params);

    void mockedResponse();

    int restMethod();

    String endpoint();
}
