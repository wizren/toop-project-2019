package toop.project.uni.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Institute extends UniStructure {
    private List<Department> departmentList;
    private List<Person> personList;

    public Institute(String name, int code) {
        super(name, code);
        departmentList = new LinkedList<>();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public Department getDepartment(int code) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getCode() == code) {
                return departmentList.get(code);
            }
        }
        return null;
    }

    public List<Person> getPersonList() {
        if (personList != null && !personList.isEmpty()) {
            return personList;
        }
        List<Person> people = new ArrayList<>();
        for (Department department : departmentList) {
            people.addAll(department.getPersonList().stream().map(person -> {
                person.structDescription = String.format("институт: %s, %s", toString(), person.structDescription);
                return person;
            }).collect(Collectors.toList()));
        }
        personList = people;
        return personList;
    }
}