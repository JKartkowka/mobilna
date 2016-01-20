package jkartkowka.jkartkwkamobile.model;

/**
 * Created by maciej on 30.12.15.
 */
public class Question {
    public final int id;
    private final String content;
    private final String[] answers;
    private final boolean open; //true - write your answer, false - choose from predefined ones

    public Question(int id, String content, String[] answers, boolean open) {
        this.id = id;
        this.content = content;
        this.answers = answers;
        this.open = open;
    }

    @Override
    public String toString() {
        return content;
    }

    public String[] answersList() {
        return answers;
    }

}
