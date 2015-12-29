package jkartkowka.jkartkwkamobile.model;

public class Group {
    public final int id;
    private final String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + id + ") " + name;
    }

}
