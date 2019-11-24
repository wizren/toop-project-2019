package toop.project.uni.models;

import java.util.ArrayList;
import java.util.List;

public class Specialty {
    private int code;
    List<Group> groups;
    private Department department;
    Degree degree;

    public Specialty(int code,
                     Degree degree,
                     Department department) {
        this.groups = new ArrayList<Group>();
        this.code = degree.ordinal() * 10 + code;
    }

    public Department getDepartment() {
        return department;
    }

    public int getCode() {
        return code;
    }
}
