package toop.project.uni.models;

import java.util.ArrayList;
import java.util.List;

public class Specialty extends UniStructure {
    private List<Group> groupList;
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
}
