package toop.project.uni.models;

import java.util.List;
import java.util.Set;

public class Group {
    Set<Subject> subjects;
    List<Student> students;
    Specialty specialty;
    Student headman;
    int grade;
    int number;


    public String getGroupNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(specialty.getDepartment().getInstitute().getCode());
        sb.append(specialty.getDepartment().getCode());
        sb.append(specialty.getCode());
        sb.append('/');
        sb.append(number);
        return sb.toString();
    }

}