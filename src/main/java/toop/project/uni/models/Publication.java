package toop.project.uni.models;

public class Publication {
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
