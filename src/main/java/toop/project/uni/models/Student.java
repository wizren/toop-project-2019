package toop.project.uni.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Student extends Person implements Serializable {
    List<Publication> scientificPublications;
    GradeBook gradeBook;

    public Student(String name,
                   String surname,
                   String patronymic,
                   LocalDate birthDate,
                   IndexingDelegate delegate) {
        super(name, surname, patronymic, birthDate, delegate);
        gradeBook = new GradeBook();
    }
}
