package toop.project.uni.models;

import java.util.Date;
import java.util.List;

public class Student extends Person {
    List<Publication> scientificPublications;
    GradeBook gradeBook;

    public Student(String name,
                   String surname,
                   String patronymic,
                   Date birthDate) {
        super(name, surname, patronymic, birthDate);
        gradeBook = new GradeBook();
    }
}
