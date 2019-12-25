package toop.project.uni.models;

import java.io.Serializable;

public class Subject implements Serializable {
    String name;

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return name.equals(o);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
