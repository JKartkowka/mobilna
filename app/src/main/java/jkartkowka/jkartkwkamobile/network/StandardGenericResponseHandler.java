package jkartkowka.jkartkwkamobile.network;

/**
 * Created by marian on 26.11.15.
 */
public abstract class StandardGenericResponseHandler<T> {

    public void onSuccess(T responseObject) {

    }

    public void onFailure(ErrorHandler error) {

    }
}
