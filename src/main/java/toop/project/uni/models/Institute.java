package toop.project.uni.models;

import java.util.LinkedList;
import java.util.List;

public class Institute extends UniStructure {
    private List<Department> departmentList;

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
}