package jkartkowka.jkartkwkamobile.model;

/**
 * Created by maciej on 30.12.15.
 */
public class Question {
    public final int id;
    private final String content;
    private final String[] answers;
    private final boolean correct[]; //true - answer is correct, false - incorrect
    private final boolean open; //true - write your answer, false - choose from predefined ones

    public Question(int id, String content, String[] answers, boolean[] correct, boolean open) {
        this.id = id;
        this.content = content;
        this.answers = answers;
        this.correct = correct;
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
