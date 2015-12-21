package jkartkowka.jkartkwkamobile.network;

import java.util.HashMap;

import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

/**
 * Created by marian on 04.12.15.
 */
public interface StandardRequest extends JKRequest {

    void parseSuccessResponse(HashMap<String, Object> params);

    void mockedResponse();
}
