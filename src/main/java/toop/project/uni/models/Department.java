package toop.project.uni.models;

import java.util.List;

public class Department {
    private List<Specialty> specialties;
    private List<Laboratory> laboratories;
    private Institute institute;
    private int code;

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Institute getInstitute() {
        return institute;
    }

    public int getCode() {
        return code;
    }
}
