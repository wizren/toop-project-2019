package toop.project.uni.consoleapp;

//Точка входа в консольное приложение

import toop.project.uni.models.Account;
import toop.project.uni.models.Person;
import toop.project.uni.services.Serializer;
import toop.project.uni.services.UniBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    private static UniBase uniBase;
    private static Serializer serializer;
    private static Scanner scanner;
    private static Account account;

    public static void main(String[] args) {
        prepare();
        do {
            System.out.format("Добро пожаловать в Университет %s!\n", uniBase.getUniversity().toString());
        } while (mainMenu());
    }

    private static void prepare() {
        serializer = new Serializer("unibase.bin", "ПолитехЪ");
        uniBase = serializer.getBase();
        scanner = new Scanner(System.in);
    }

    private static boolean mainMenu() {
        System.out.println("1 - авторизация");
        System.out.println("2 - регистрация");
        System.out.println("0 - выход");
        switch (scanner.nextInt()) {
            case 0:
                return false;
            case 1:
                authorization();
                return true;
            case 2:
                registration();
                return true;
            case 2128506:
                getGodMod();
                return true;
            default:
                return true;
        }
    }

    private static void authorization() {
        scanner.reset();
        String login, password;
        System.out.println("Авторизация");
        System.out.println("Введите логин:");
        login = scanner.next();
        System.out.println("Введите пароль:");
        password = scanner.next();
        account = uniBase.getAuthentication().login(login, password);
        if (account == null) {
            System.out.println("Неверный логин/пароль. Повторите попытку");
            mainMenu();
        }
        System.out.format("Вы вошли как %s\n", account.getLogin());
        switch (account.getAccountType()) {
            case God:
                godMode();
                return;
            case Student:
                studentMode();
                return;
            case Professor:
                professorMode();
                return;
            default:
                System.out.println("Произошла неопознанная ошибка!");
                return;
        }
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
        LocalDate birthDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDate = LocalDate.parse(date, formatter);
        } catch (Exception ex) {
            System.out.println("Дата введена некорректно! В наказание выкидываем Вас в главное меню!");
            mainMenu();
            return;
        }
        Person currentPerson;
        Person[] foundPeople = uniBase.getUniversity()
                .getPersonList(false)
                .stream()
                .filter(person -> {
                    return person.getName().equals(name)
                            && person.getSurname().equals(surname)
                            && person.getPatronymic().equals(patronymic)
                            && person.getBirthDate().isEqual(birthDate);
                }).toArray(Person[]::new);
        switch (foundPeople.length) {
            case 0:
                System.out.println("Человек с такими данными не найден. " +
                        "Проверьте правильность введенных данных и повторите попытку.");
                mainMenu();
                return;
            case 1:
                Person person = foundPeople[0];
                System.out.format("%s %s - это вы?\n", person, person.structDescription);
                System.out.println("1 - да, 0 - нет");
                switch (scanner.nextInt()) {
                    case 1:
                        currentPerson = person;
                        break;
                    default:
                        System.out.println("Вы прервали регистрацию");
                        mainMenu();
                        return;
                }
                break;
            default:
                System.out.println("Нашлось несколько человек с такими данными. " +
                        "Укажите номер, стоящий напротив ваших данных");
                for (int i = 0; i < foundPeople.length; i++) {
                    System.out.format("%d) %s %s\n", i, foundPeople[i], foundPeople[i].structDescription);
                }

                int num = scanner.nextInt();

                while (num < 0 || num >= foundPeople.length) {
                    System.out.println("Введено некорректное число. Повторите ввод.");
                    num = scanner.nextInt();
                }
                currentPerson = foundPeople[num];
                break;
        }
        scanner.reset();
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Придумайте пароль:");
        String onePassword = scanner.next();
        System.out.println("Повторите пароль:");
        String secondPassword = scanner.next();
        while (!onePassword.equals(secondPassword)) {
            System.out.println("Введенные пароли не совпадают!");
            System.out.println("Придумайте пароль:");
            onePassword = scanner.next();
            System.out.println("Повторите пароль:");
            secondPassword = scanner.next();
        }
        System.out.println(uniBase.getAuthentication().register(login, onePassword, currentPerson)
                ? "Поздравляем, регистрация успешно завершена!"
                : "Что-то пошло не так. Повторите попытку позже");
    }

    private static void getGodMod() {
        System.out.println("Введите пароль!!!");
        String password = scanner.next();
        account = uniBase.getAuthentication().getGodAccount(password);
        if (account == null) {
            System.out.println("Вы не БОГ!!!");
            return;
        }
    }

    private static void studentMode() {

    }

    private static void professorMode() {

    }

    private static void godMode() {

    }
}