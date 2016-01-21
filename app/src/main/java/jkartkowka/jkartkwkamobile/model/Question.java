package jkartkowka.jkartkwkamobile.model;

/**
 * Created by maciej on 30.12.15.
 */
public class Question {
    public final int id;
    private final String content;
    private final Answer[] answers;

    public Question(int id, String content, Answer[] answers) {
        this.id = id;
        this.content = content;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return content;
    }

    public Answer[] getAnswers() {return answers;}

    public int getId() {return id;}
}
