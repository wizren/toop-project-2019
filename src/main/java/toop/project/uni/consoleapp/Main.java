package toop.project.uni.consoleapp;

//Точка входа в консольное приложение

import toop.project.uni.models.Account;
import toop.project.uni.models.Person;
import toop.project.uni.services.Serializer;
import toop.project.uni.services.UniBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        System.out.format("Добро пожаловать в Университет %s!\n", uniBase.getUniversity().toString());
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
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
        System.out.println("Введите пароль:");
        //String onePassword =
    }

}