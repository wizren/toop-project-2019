package toop.project.uni.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Laboratory extends UniStructure implements Serializable {
    private List<Professor> professorList;

    public Laboratory(String name, int code) {
        super(name, code);
        professorList = new LinkedList<>();
    }

    public List<Professor> getProfessorList() {
        return this.professorList.stream().map(professor -> {
            professor.structDescription = String.format("лабооратория: %s", toString());
            return professor;
        }).collect(Collectors.toList());
    }

    public Professor[] findProfessor(String phrase) {
        String[] phrases = phrase.split(" ");
        return professorList.stream().filter(professor -> {
            for (String onePhrase : phrases) {
                if (professor.getName().contains(phrase)
                        || professor.getSurname().contains(phrase)
                        || professor.getPatronymic().contains(phrase)) {
                    return true;
                }
            }
            return false;
        }).toArray(Professor[]::new);
    }
}
