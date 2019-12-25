package toop.project.uni.models;

import java.io.Serializable;

public class Role implements Serializable {
    public static final int Teacher = 1;
    public static final int Lecturer = 2;
    public static final int Tutor = 4; //научный руководитель
    public static final int Explorer = 8;
}