package jkartkowka.jkartkwkamobile.model;

/**
 * Created by marian on 19.12.2015.
 */
public class JKTest {
    public final int id;
    private final String name;

    public JKTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + id + ") " + name;
    }
}
