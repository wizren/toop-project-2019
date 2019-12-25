package toop.project.uni.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Person implements Serializable {
    List<Subject> subjects;
    List<Publication> scientificPublications;
    int role;
    public Professor(String name,
                     String surname,
                     String patronymic,
                     LocalDate birthDate,
                     int role,
                     IndexingDelegate delegate) {
        super(name, surname, patronymic, birthDate, delegate);
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