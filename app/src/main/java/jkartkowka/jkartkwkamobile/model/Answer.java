package jkartkowka.jkartkwkamobile.model;

/**
 * Created by adamk on 21.01.2016.
 */
public class Answer {
    public final int id;
    private final String content;

    public Answer(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public String toString() {
        return content;
    }

    public int getId() {return id;}
}
