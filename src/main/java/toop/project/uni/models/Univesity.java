package toop.project.uni.models;

import java.util.LinkedList;
import java.util.List;

public class Univesity extends UniStructure {
    private List<Institute> instituteList;

    public Univesity(String name) {
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

}
