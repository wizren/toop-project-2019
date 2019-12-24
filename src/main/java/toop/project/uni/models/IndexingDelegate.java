package toop.project.uni.models;

import java.util.List;

public interface IndexingDelegate {
    List<Person> getPersonList(boolean forceUpdate);
}
