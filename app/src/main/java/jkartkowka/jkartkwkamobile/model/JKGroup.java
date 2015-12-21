package jkartkowka.jkartkwkamobile.model;

/**
 * Created by marian on 21.12.2015.
 */
public class JKGroup {
    private final int id;
    private final String name;

    public JKGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + id + ") " + name;
    }

}
