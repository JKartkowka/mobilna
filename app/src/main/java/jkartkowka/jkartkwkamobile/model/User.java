package jkartkowka.jkartkwkamobile.model;

/**
 * Created by marian on 26.11.15.
 */
public class User {
    private final UserType type;

    public User(UserType type) {
        this.type = type;
    }

    public UserType getType() {
        return type;
    }
}
