package toop.project.uni.models;

import java.util.Date;
import java.util.List;

public class Student extends Person {
    List<Publication> scientificPublications;


    public Student(String name,
                   String surname,
                   Date birthDate,
                   Institute institute,
                   Department department,
                   Specialty specialty,
                   Group group) {
        super(name, surname, birthDate);

    }
}
