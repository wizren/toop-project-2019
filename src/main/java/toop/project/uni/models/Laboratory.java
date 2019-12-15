package toop.project.uni.models;

import java.util.LinkedList;
import java.util.List;

public class Laboratory extends UniStructure {
    private List<Professor> professorList;

    public Laboratory(String name, int code) {
        super(name, code);
        professorList = new LinkedList<>();
    }

    public List<Professor> getProfessorList() {
        return this.professorList;
    }

    public void addProfessor(Professor professor) {
        this.professorList.add(professor);
    }

    public Professor[] findProfessor(String phrase) {
        String[] phrases = phrase.split(" ");
        return professorList.stream().filter(professor -> {
            for (String onePhrase : phrases) {
                if (professor.name.contains(phrase)
                        || professor.surname.contains(phrase)
                        || professor.patronymic.contains(phrase)) {
                    return true;
                }
            }
            return false;
        }).toArray(Professor[]::new);
    }

    public String removeProfessor(Professor professor) {
        professorList.remove(professor);
        return professor.toString();
    }
}
