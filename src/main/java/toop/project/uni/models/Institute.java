package toop.project.uni.models;

import java.util.List;

public class Institute {
    private int code;
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public int getCode() {
        return code;
    }
}
