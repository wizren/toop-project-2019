package toop.project.uni.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends Person {
    List<Subject> subjects;
    List<Publication> scientificPublications;
    int role;
    public Professor(String name, String surname, String patronymic, Date birthDate, int role) {
        super(name, surname, patronymic, birthDate);
        this.role = role;
        this.scientificPublications = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public List<Publication> getScientificPublications() {
        return scientificPublications;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}