package jkartkowka.jkartkwkamobile.network.requests;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import java.util.HashMap;
import jkartkowka.jkartkwkamobile.network.StandardGenericResponseHandler;
import jkartkowka.jkartkwkamobile.network.StandardRequest;

/**
 * Created by maciej on 20.01.16.
 */
public class IsAnyPopQuizActiveRequest implements StandardRequest{
    private final StandardGenericResponseHandler<Boolean> responseHandler;

    public IsAnyPopQuizActiveRequest(StandardGenericResponseHandler<Boolean> responseHandler){
        this.responseHandler=responseHandler;
    }

    @Override
    public void parseSuccessResponse(JSONArray params) {
        if(params.length()>0){
            responseHandler.onSuccess(true);
        }
        else
            responseHandler.onSuccess(false);
    }

    @Override
    public void mockedResponse() {
        responseHandler.onSuccess(true);
    }

    @Override
    public int restMethod() {
        return Request.Method.POST;
    }

    @Override
    public String endpoint() {
        return "tests";
    }

    @Override
    public String apiMethod() {
        return "list";
    }

    @Override
    public HashMap<String, Object> params() {
        return null;
    }

    @Override
    public void parseErrorResponse(VolleyError params) {

    }
}