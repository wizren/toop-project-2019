package toop.project.uni.models;

public class Account {
    private String login;
    private int passwordHash;
    private AccountType accountType;

    public Account(String login, int passwordHash, AccountType accountType) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.accountType = accountType;
    }

    public boolean setPasswordHash(int oldHash, int newHash) {
        if (passwordHash == oldHash) {
            this.passwordHash = newHash;
            return true;
        }
        return false;
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