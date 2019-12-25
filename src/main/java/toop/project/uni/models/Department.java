package toop.project.uni.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Department extends UniStructure implements Serializable {
    private List<Specialty> specialtyList;
    private List<Laboratory> laboratoryList;
    private List<Person> personList;

    public Department(int code, String name) {
        super(name, code);
        this.specialtyList = new LinkedList<>();
        this.laboratoryList = new LinkedList<>();
    }

    public List<Laboratory> getLaboratoryList() {
        return this.laboratoryList;
    }
    public List<Specialty> getSpecialtyList() {
        return this.specialtyList;
    }

    public Laboratory getLaboratory(int code) {
        for (int i = 0; i < laboratoryList.size(); i++) {
            if (laboratoryList.get(i).getCode() == code) {
                return laboratoryList.get(code);
            }
        }
        return null;
    }

    public Specialty getSpecialty(int code) {
        for (int i = 0; i < specialtyList.size(); i++) {
            if (specialtyList.get(i).getCode() == code) {
                return specialtyList.get(code);
            }
        }
        return null;
    }

    public List<Person> getPersonList() {
        if (personList != null && !personList.isEmpty()) {
            return personList;
        }
        List<Person> people = new ArrayList<>();
        for (Laboratory laboratory : laboratoryList) {
            people.addAll(laboratory.getProfessorList().stream().map(professor -> {
                professor.structDescription = String.format("кафедра: %s, %s", toString(), professor.structDescription);
                return professor;
            }).collect(Collectors.toList()));
        }
        for (Specialty specialty : specialtyList) {
            people.addAll(specialty.getPersonList().stream().map(person -> {
                person.structDescription = String.format("кафедра: %s, %s", toString(), person.structDescription);
                return person;
            }).collect(Collectors.toList()));
        }
        personList = people;
        return personList;
    }
}
