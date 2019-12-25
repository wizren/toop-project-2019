package toop.project.uni.models;

import java.io.Serializable;

public class Account implements Serializable {
    private String login;
    private int passwordHash;
    private AccountType accountType;
    private Person person;

    public Account(String login, int passwordHash, AccountType accountType, Person person) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.accountType = accountType;
        this.person = person;
    }

    public boolean setPasswordHash(int oldHash, int newHash) {
        if (passwordHash == oldHash) {
            this.passwordHash = newHash;
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public String getLogin() {
        return login;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public boolean checkPassword(int hashCode) {
        return hashCode == passwordHash;
    }
}