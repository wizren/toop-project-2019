package toop.project.uni.models;

import java.io.Serializable;

public class UniStructure implements Serializable {
    //Базовый класс для структурных подразделений университета

    private int code;
    private String name;

    public UniStructure(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public int getCode() {
        return code;
    }
}
