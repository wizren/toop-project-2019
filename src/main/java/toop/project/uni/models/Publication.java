package toop.project.uni.models;

import java.io.Serializable;

public class Publication implements Serializable {
    String name;
    PublicationType type;
    int year;

    public enum PublicationType {
        article,
        research,
        tutorial,
        book
    }
}
