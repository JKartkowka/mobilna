package jkartkowka.jkartkwkamobile.model;

/**
 * Created by marian on 31.12.2015.
 */
public class StudentListItem {
    public final Student student;
    public boolean selected;

    public StudentListItem(Student student) {
        this.student = student;
        this.selected = false;
    }

    @Override
    public String toString() {
        return student.toString();
    }
}
