package toop.project.uni.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Professor extends Person {
    Department department;
    Set<Subject> subjects;
    List<Publication> scientificPublications;
    int role;
    public Professor(String name, String surname, Date birthDate, int role) {
        super(name, surname, birthDate);
    }
}