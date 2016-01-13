package jkartkowka.jkartkwkamobile.network;

import org.json.JSONArray;

import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

public interface StandardRequest extends JKRequest {

    void parseSuccessResponse(JSONArray params);

    void mockedResponse();

    int restMethod();

    String endpoint();
}
