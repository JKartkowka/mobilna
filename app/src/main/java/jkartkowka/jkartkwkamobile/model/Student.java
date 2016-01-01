package jkartkowka.jkartkwkamobile.model;

/**
 * Created by marian on 31.12.2015.
 */
public class Student {
    public final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + id + ") " + name;
    }
}
