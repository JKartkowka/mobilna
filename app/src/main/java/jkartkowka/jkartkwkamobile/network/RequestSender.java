package jkartkowka.jkartkwkamobile.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.network.requests.AuthenticationRequest;
import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

public class RequestSender {
    private final RequestQueue queue;
    private User user;

    public RequestSender(Context applicationContext) {
        queue = Volley.newRequestQueue(applicationContext);
    }

    public void sendRequest(JKRequest request) {
        System.out.println("Params: " + request.params().toString());
        System.out.println("Method: " + request.apiMethod());

        if (request instanceof AuthenticationRequest) {
            sendAuthenticationRequest((AuthenticationRequest) request);
        } else if (request instanceof StandardRequest) {
            sendStandardRequest((StandardRequest) request);
        }
    }

    private void sendStandardRequest(StandardRequest request) {
        request.mockedResponse();
    }

    private void sendAuthenticationRequest(AuthenticationRequest request) {
        user = request.mockedResponse();
        request.onSuccess(user);
    }
}
