package toop.project.uni.models;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Group implements Serializable {
    private List<Subject> subjects;
    private List<Student> students;
    private Specialty specialty;
    private Student headman;
    private int grade;
    private int number;

    public Group(int number, int grade) {
        this.grade = grade;
        this.number = number;
    }

    @Override
    public String toString() {
        return getFullNumber();
    }

    public String getFullNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(specialty.getCode());
        sb.append('/');
        sb.append(number);
        return sb.toString();
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
            student.structDescription = String.format("группа: %s", getFullNumber());
            return student;
        }).collect(Collectors.toList());
    }
}