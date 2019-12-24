package toop.project.uni.consoleapp;

//Точка входа в консольное приложение

import toop.project.uni.models.Account;
import toop.project.uni.services.Serializer;
import toop.project.uni.services.UniBase;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

class Main {
    private static UniBase uniBase;
    private static Serializer serializer;
    private static Scanner scanner;
    private static Account account;

    public static void main(String[] args) {
        prepare();
        mainMenu();
    }

    private static void prepare() {
        serializer = new Serializer("unibase.bin", "ПолитехЪ");
        uniBase = serializer.getBase();
        scanner = new Scanner(System.in);
    }

    private static void mainMenu() {
        System.out.format("Добро пожаловать в Университет %s!", uniBase.getUniversity().toString());
        System.out.println("1 - авторизация");
        System.out.println("2 - регистрация");
        System.out.println("0 - выход");
        switch (scanner.nextInt()) {
            case 0:
                return;
            case 1:
                authorization();
                return;
            case 2:
                registration();
                return;
            case 2128506:

                return;
            default:
                mainMenu();
                return;
        }
    }

    private static void authorization() {
        String login, password;
        System.out.println("Авторизация");
        System.out.println("Введите логин:");
        login = scanner.next();
        System.out.println("Введите пароль:");
        password = scanner.next();
        account = uniBase.getAuthentication().login(login, password);
        if (account == null) {
            System.out.println("Неверный логин/пароль. Повторите попытку. (Для выхода введите exit)");
            if (scanner.next().equals("exit")) {
                mainMenu();
                return;
            }
            authorization();
            return;
        }
        System.out.format("Вы вошли как %s", account.getLogin());
    }

    private static void registration() {
        System.out.println("Регистрация");
        System.out.println("Введите фамилию:");
        String surname = scanner.next();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите отчество:");
        String patronymic = scanner.next();
        System.out.println("Укажите дату рождения (ДД.ММ.ГГГГ):");
        String date = scanner.next();
        LocalDate birthDate = LocalDate.parse(date);
        uniBase.getUniversity().getPersonList()

    }

}