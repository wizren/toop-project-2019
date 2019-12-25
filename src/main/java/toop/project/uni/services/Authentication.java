package toop.project.uni.services;

import toop.project.uni.models.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Authentication implements Serializable {
    private List<Account> accounts;

    public Authentication() {
        this.accounts = new ArrayList<>();
    }

    public Account getGodAccount(String password) {
        for (Account account : accounts) {
            if (account.getAccountType() == AccountType.God) {
                return account.checkPassword(password.hashCode()) ? account : null;
            }
        }
        Account godAccount = new Account("god2007@polyteizm.net", password.hashCode(), AccountType.God);
        accounts.add(godAccount);
        return godAccount;
    }

    public Account login(String login, String password) {
        for (Account account : accounts) {
            if (login.equalsIgnoreCase(account.getLogin())) {
                return account.checkPassword(password.hashCode()) ? account : null;
            }
        }
        return null;
    }

    public boolean register(String login, String password, Person person) {
        if (person.getClass().equals(Student.class)) {
            accounts.add(new Account(login, password.hashCode(), AccountType.Student));
            return true;
        }
        if (person.getClass().equals(Professor.class)) {
            accounts.add(new Account(login, password.hashCode(), AccountType.Professor));
            return true;
        }
        return false;
    }

    public boolean removeAccount(Account account, String password) {
        if (account.checkPassword(password.hashCode())) {
            return accounts.remove(account);
        }
        return false;
    }
}
