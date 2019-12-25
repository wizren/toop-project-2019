package toop.project.uni.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group implements Serializable {
    private List<Subject> subjects;
    private List<Student> students;
    private Student headman;
    private int grade;
    private int number;

    public Group(int number, int grade) {
        this.grade = grade;
        this.number = number;
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%d", getNumber());
    }

    public int getNumber() {
        return number;
    }

    public int getGrade() {
        return grade;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Student> getStudents() {
        return students.stream().map(student -> {
            student.structDescription = String.format("группа: %s", toString());
            return student;
        }).collect(Collectors.toList());
    }
}