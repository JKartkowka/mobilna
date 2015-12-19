package jkartkowka.jkartkwkamobile.model;

import java.util.Date;

/**
 * Created by marian on 26.11.15.
 */
public class User {
    private final String accessToken;
    private final String refreshToken;
    private final Date accessTokenExpirationDate;
    private final UserType type;

    public User(String accessToken, String refreshToken, Date accessTokenExpirationDate, UserType type) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpirationDate = accessTokenExpirationDate;
        this.type = type;
    }

    public UserType getType() {
        return type;
    }
}
