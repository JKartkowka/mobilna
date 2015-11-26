package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 26.11.15.
 */
public abstract class StandardGenericResponseHandler<T> {

    void onSuccess(T responseObject) {

    }

    void onFailure(ErrorHandler error) {

    }
}
