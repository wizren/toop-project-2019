package toop.project.uni.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Student extends Person implements Serializable {
    private List<Publication> scientificPublications;
    private GradeBook gradeBook;

    public Student(String name,
                   String surname,
                   String patronymic,
                   LocalDate birthDate,
                   IndexingDelegate delegate) {
        super(name, surname, patronymic, birthDate, delegate);
        gradeBook = new GradeBook();
    }

    public GradeBook getGradeBook() {
        return gradeBook;
    }

    public List<Publication> getScientificPublications() {
        return scientificPublications;
    }
}
