package jkartkowka.jkartkwkamobile;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by marian on 22.11.15.
 */
public class RequestSender {
    private final RequestQueue queue;

    public RequestSender(Context applicationContext) {
        queue = Volley.newRequestQueue(applicationContext);
    }

    public void sendRequest(StandardRequest request) {
        System.out.println("Params: " + request.params().toString());
        System.out.println("Method: " + request.apiMethod());

        request.parseSuccessResponse(null);

    }
}
