package toop.project.uni.services;

import toop.project.uni.models.University;

import java.io.Serializable;

public class UniBase implements Serializable {
    private University university;
    private Authentication authentication;

    UniBase(Authentication authentication, University university) {
        this.authentication = authentication;
        this.university = university;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public University getUniversity() {
        return university;
    }
}
