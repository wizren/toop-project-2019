package toop.project.uni.models;

//Абстрактная модель человека, которая будет расширятся другими классами

public class People {
    public String name;
    public String surname;

    People(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
