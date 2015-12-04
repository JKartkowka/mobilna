package jkartkowka.jkartkwkamobile;

import java.util.Date;

/**
 * Created by marian on 26.11.15.
 */
public class User {
    private final String accessToken;
    private final String refreshToken;
    private final Date accessTokenExpirationDate;

    public User(String accessToken, String refreshToken, Date accessTokenExpirationDate) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpirationDate = accessTokenExpirationDate;
    }
}
