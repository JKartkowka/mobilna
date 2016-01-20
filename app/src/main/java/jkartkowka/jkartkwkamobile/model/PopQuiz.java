package jkartkowka.jkartkwkamobile.model;

import java.util.ArrayList;
import java.util.List;

public class PopQuiz {
    public final int id;
    private final String name;
    private int questionCount;
    private int correctAnswers;
    private float grade;
    private List<Question> questions;

    public PopQuiz(int id, String name, int questionCount, int correctAnswers, float grade, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questionCount = questionCount;
        this.correctAnswers = correctAnswers;
        this.grade = grade;
        this.questions = questions;
    }

    @Override
    public String toString() {return id + ") " + name;}

    public String getResult() {return correctAnswers + "/" + questionCount;}

    public float getGrade() {return grade;}

    public String getName() {return name;}

    public String getQuestionContent(int index) {return questions.get(index).toString();}

    public String[] getAnswers(int index) {return questions.get(index).getAnswers();}

    public int getQuestionCount() {return questions.size();}
}
