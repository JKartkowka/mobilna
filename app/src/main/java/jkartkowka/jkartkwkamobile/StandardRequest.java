package jkartkowka.jkartkwkamobile;

import java.util.HashMap;

/**
 * Created by marian on 26.11.15.
 */
public abstract class StandardRequest  {

    public abstract String apiMethod();

    public abstract HashMap<String, Object> params();

    public abstract void parseSuccessResponse(HashMap<String, Object> params);

    public abstract void parseErrorResponse(HashMap<String, Object> params);

    public abstract void mockedResponse();
}
