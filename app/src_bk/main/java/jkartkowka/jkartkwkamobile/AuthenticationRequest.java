package jkartkowka.jkartkwkamobile;

/**
 * Created by marian on 04.12.15.
 */
public interface AuthenticationRequest extends JKRequest {
    User mockedResponse();

    void onSuccess(User user);
}
