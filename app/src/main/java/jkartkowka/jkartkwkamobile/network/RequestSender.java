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

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import jkartkowka.jkartkwkamobile.model.User;
import jkartkowka.jkartkwkamobile.network.requests.AuthenticationRequest;
import jkartkowka.jkartkwkamobile.network.requests.JKRequest;

public class RequestSender {
    private static final String API_URL = "http://192.168.0.5";
    private static final String API_PORT = "8080";
    private static final boolean API_WORKS = true;
    private final RequestQueue queue;
    private static String auth;

    public RequestSender(Context applicationContext) {
        queue = Volley.newRequestQueue(applicationContext);
    }

    public void sendRequest(JKRequest request) {
        if (request instanceof AuthenticationRequest) {
            sendAuthenticationRequest((AuthenticationRequest) request);
        } else if (request instanceof StandardRequest) {
            sendStandardRequest((StandardRequest) request);
        }
    }

    private void sendStandardRequest(final StandardRequest request) {
        if (API_WORKS) {
            JsonArrayRequest jsonRequest = new JsonArrayRequest(request.restMethod(), API_URL + ":" + API_PORT + "/" + request.endpoint(), new Gson().toJson(generateRequestParams(request)), new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    System.out.println("Request: " + request.getClass().toString() + "\n" + "Method: " + request.apiMethod() + "\n" + "Params: " + request.params().toString() + "\n" + "Response: " + response.toString());
                    request.parseSuccessResponse(response);
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("Request: " + request.getClass().toString() + "\n" + "Method: " + request.apiMethod() + "\n" + "Params: " + request.params().toString() + "\n" + "Error response: " + error.toString());
                    request.mockedResponse();

                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return generateRequestHeader();
                }
            };

            queue.add(jsonRequest);
        } else {
            request.mockedResponse();
        }
    }

    private HashMap<String, Object> generateRequestParams(StandardRequest request) {
        HashMap<String, Object> params = (HashMap<String, Object>) request.params().clone();
        params.put("method", request.apiMethod());

        return params;
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

    public void clearCredentials() {
        auth = null;
    }
}
