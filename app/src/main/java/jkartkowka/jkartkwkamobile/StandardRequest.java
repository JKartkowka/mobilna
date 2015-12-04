package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 04.12.15.
 */
public interface StandardRequest extends JKRequest {

    void parseSuccessResponse(HashMap<String, Object> params);

    void mockedResponse();
}
