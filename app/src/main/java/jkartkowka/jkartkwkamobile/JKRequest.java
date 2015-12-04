package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 04.12.15.
 */
public interface JKRequest {

    String apiMethod();

    HashMap<String, Object> params();

    void parseErrorResponse(HashMap<String, Object> params);

}
