package toop.project.uni.models;

import java.util.LinkedList;
import java.util.List;

public class Department extends UniStructure {
    private List<Specialty> specialtyList;
    private List<Laboratory> laboratoryList;

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
}
