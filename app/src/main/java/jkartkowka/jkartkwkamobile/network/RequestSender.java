package jkartkowka.jkartkwkamobile.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.network.requests.AuthenticationRequest;
import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

public class RequestSender {
    private static final String API_URL = "http://192.168.1.2";
    private static final String API_PORT = "8002";
    private final RequestQueue queue;
    private static String auth;

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

    private void sendStandardRequest(final StandardRequest request) {
        JsonArrayRequest jsonRequest = new JsonArrayRequest(request.restMethod(), API_URL + ":" + API_PORT + "/" + request.endpoint(), new Gson().toJson(request.params()), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("To jest standard response " + response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("To jest error " + error.toString());
                request.mockedResponse();

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return generateRequestHeader();
            }
        };

        queue.add(jsonRequest);
    }

    @NonNull
    private Map<String, String> generateRequestHeader() {
        Map<String, String> params = new HashMap<>();
        params.put("Authorization", auth);
        return params;
    }

    public static void setCredentials(String username, String password) {
        String creds = String.format("%s:%s", username, password);
        auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
    }

    private void sendAuthenticationRequest(AuthenticationRequest request) {
        User user = request.mockedResponse();
        request.onSuccess(user);
    }
}
