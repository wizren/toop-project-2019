package toop.project.uni.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Specialty extends UniStructure implements Serializable {
    private List<Group> groupList;
    private List<Person> personList;
    private Degree degree;

    public Specialty(int code, String name, Degree degree) {
        super(name, code);
        this.groupList = new ArrayList();
        this.degree = degree;
    }

    public Degree getDegree() {
        return this.degree;
    }

    public List<Group> getGroupList() {
        return this.groupList;
    }

    public Group getGroup(int code) {
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getNumber() == code) {
                return groupList.get(code);
            }
        }
        return null;
    }

    public List<Person> getPersonList() {
        if (personList != null && !personList.isEmpty()) {
            return personList;
        }
        List<Person> people = new ArrayList<>();
        for (Group group : groupList) {
            people.addAll(group.getStudents().stream().map(student -> {
                student.structDescription = String.format("специальность: %s, %s", toString(), student.structDescription);
                return student;
            }).collect(Collectors.toList()));
        }
        personList = people;
        return personList;
    }
}
