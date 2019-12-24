package toop.project.uni.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class University extends UniStructure implements IndexingDelegate {
    private List<Institute> instituteList;
    private List<Person> personList;

    public University(String name) {
        super(name, 0);
        this.instituteList = new LinkedList();
    }

    public List<Institute> getInstituteList() {
        return instituteList;
    }

    public Institute getInstitute(int code) {
        for (int i = 0; i < instituteList.size(); i++) {
            if (instituteList.get(i).getCode() == code) {
                return instituteList.get(code);
            }
        }
        return null;
    }

    public List<Person> getPersonList(boolean forceUpdate) {
        if (personList != null && !personList.isEmpty() && !forceUpdate) {
            return personList;
        }
        List<Person> people = new ArrayList<>();
        for (Institute institute : instituteList) {
            people.addAll(institute.getPersonList());
        }
        personList = people;
        return personList;
    }
}
