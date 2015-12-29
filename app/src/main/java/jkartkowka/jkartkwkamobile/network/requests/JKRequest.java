package jkartkowka.jkartkwkamobile.network.requests;

import java.util.HashMap;

public interface JKRequest {

    String apiMethod();

    HashMap<String, Object> params();

    void parseErrorResponse(HashMap<String, Object> params);

}
