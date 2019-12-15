package toop.project.uni.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Professor extends Person {
    Set<Subject> subjects;
    List<Publication> scientificPublications;
    int role;
    public Professor(String name, String surname, String patronymic, Date birthDate, int role) {
        super(name, surname, patronymic, birthDate);
        this.role = role;
    }
}