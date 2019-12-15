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

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public String removeDepartment(int code) {
        Department department = getDepartment(code);
        if (department != null) {
            departmentList.remove(department);
            return department.toString();
        }
        return null;
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