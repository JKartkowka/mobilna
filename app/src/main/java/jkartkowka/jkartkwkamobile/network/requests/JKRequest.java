package jkartkowka.jkartkwkamobile.network.requests;

import com.android.volley.VolleyError;

import java.util.HashMap;

public interface JKRequest {

    String apiMethod();

    HashMap<String, Object> params();

    void parseErrorResponse(VolleyError params);

}
