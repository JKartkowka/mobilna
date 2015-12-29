package jkartkowka.jkartkwkamobile.model;

public class JKTest {
    public final int id;
    private final String name;
    private int questionCount;
    private int correctAnswers;
    private float grade;

    public JKTest(int id, String name, int questionCount, int correctAnswers, float grade) {
        this.id = id;
        this.name = name;
        this.questionCount = questionCount;
        this.correctAnswers = correctAnswers;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "" + id + ") " + name;
    }

    public String getResult() {
        return correctAnswers + "/" + questionCount;
    }

    public float getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}
