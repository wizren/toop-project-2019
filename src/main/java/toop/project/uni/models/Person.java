package toop.project.uni.models;

//Базовый класс для людей

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    String structDescription;
    private IndexingDelegate delegate;

    public Person(String name, String surname, String patronymic, LocalDate birthDate, IndexingDelegate delegate) {
        this.setName(name);
        this.setSurname(surname);
        this.setPatronymic(patronymic);
        this.birthDate = birthDate;
        this.delegate = delegate;
        delegate.getPersonList(true);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName() + " " + getPatronymic();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        delegate.getPersonList(true);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        delegate.getPersonList(true);
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        delegate.getPersonList(true);
    }
}
