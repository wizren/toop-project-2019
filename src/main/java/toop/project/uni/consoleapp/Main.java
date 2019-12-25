package toop.project.uni.consoleapp;

//Точка входа в консольное приложение

import toop.project.uni.models.*;
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
        serializer.serializeData(uniBase);
    }

    private static void prepare() {
        serializer = new Serializer("/unibase.dat", "ПолитехЪ");
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
        System.out.println("1 - Просмотреть оценки за семестр ");
        System.out.println("2 - Просмотреть оценки за весь период обучения");
        System.out.println("3 - Добавить публикацию");
    }

    private static void professorMode() {
        System.out.println("1 - Поставить оценку");
        System.out.println("2 - Добавить публикацию");
    }

    private static void godMode() {
        System.out.println("1 - Добавить студента");
        System.out.println("2 - Отчислить студента");
        System.out.println("3 - Добавить преподавателя");
        System.out.println("4 - Уволить преподавателя");
        System.out.println("5 - Уничтожить весь университет");
        switch (scanner.nextInt()) {
            case 1:

        }
    }

    private static void manageGroup(Account account) {
        int i = 0;
        System.out.println("Укажите институт:");
        for (Institute institute : uniBase.getUniversity().getInstituteList()) {
            System.out.format("%d) %s\n", i, institute);
            i++;
        }
        System.out.format("%d) Добавить новый институт\n", i);
        int num = scanner.nextInt();
        Institute institute;
        if (num == i) {
            System.out.println("Введите название института:");
            String name = scanner.next();
            System.out.println("Введите код института:");
            int code = scanner.nextInt();
            institute = new Institute(name, code);
            uniBase.getUniversity().getInstituteList().add(institute);
            System.out.println("Институт добавлен");
        } else if (num >= 0 && num < i) {
            institute = uniBase.getUniversity().getInstituteList().get(num);
        } else {
            System.out.println("Произошла ошибка");
            return;
        }

        i = 0;
        System.out.println("Укажите кафедру:");
        for (Department department : institute.getDepartmentList()) {
            System.out.format("%d) %s\n", i, department);
            i++;
        }
        System.out.format("%d) Добавить новую кафедру\n", i);
        num = scanner.nextInt();
        Department department;
        if (num == i) {
            System.out.println("Введите название кафедры:");
            String name = scanner.next();
            System.out.println("Введите код кафедры:");
            int code = scanner.nextInt();
            department = new Department(code, name);
            institute.getDepartmentList().add(department);
            System.out.println("Кафедра добавлена");
        } else if (num >= 0 && num < i) {
            department = institute.getDepartmentList().get(num);
        } else {
            System.out.println("Произошла ошибка");
            return;
        }

        i = 0;
        System.out.println("Укажите Направление:");
        for (Specialty specialty : department.getSpecialtyList()) {
            System.out.format("%d) %s\n", i, specialty);
            i++;
        }
        System.out.format("%d) Добавить новое направление\n", i);
        num = scanner.nextInt();
        Specialty specialty;
        if (num == i) {
            System.out.println("Введите название направления:");
            String name = scanner.next();
            System.out.println("Введите код направления:");
            int code = scanner.nextInt();
            System.out.println("Степень: 0 - бакалавриат, 1 - магистратура, 2 - аспирантура " +
                    "(берем остаток от введенного Вами числа :) )");
            Degree degree;
            switch (scanner.nextInt() % 3) {
                case 0:
                    degree = Degree.Bachelor;
                    break;
                case 1:
                    degree = Degree.Master;
                    break;
                default:
                    degree = Degree.Postgraduate;
                    break;
            }
            specialty = new Specialty(code, name, degree);
            department.getSpecialtyList().add(specialty);
            System.out.println("Направление добавлено");
        } else if (num >= 0 && num < i) {
            specialty = department.getSpecialtyList().get(num);
        } else {
            System.out.println("Произошла ошибка");
            return;
        }

        i = 0;
        System.out.println("Укажите группу:");
        for (Group group : specialty.getGroupList()) {
            System.out.format("%d) %s\n", i, group);
            i++;
        }
        System.out.format("%d) Добавить новую группу\n", i);
        num = scanner.nextInt();
        Group group;
        if (num == i) {
            System.out.println("Введите номер группы:");
            int number = scanner.nextInt();
            System.out.println("Укажите курс обучения");
            int course = scanner.nextInt();
            group = new Group(number, course);
            specialty.getGroupList().add(group);
            System.out.println("Группа добавлена");
        } else if (num >= 0 && num < i) {
            group = specialty.getGroupList().get(num);
        } else {
            System.out.println("Произошла ошибка");
            return;
        }

        System.out.format("Вы находитесь в: %s, %s, %s, %s\n",institute, department, specialty, group);
        System.out.println("1 - Посмотреть список студентов");
        if (account.getAccountType() == AccountType.Professor) {
            System.out.println("2 - Выставить оценки");
        }
        if (account.getAccountType() == AccountType.God) {
            System.out.println("3 - Добавить студента");
            System.out.println("4 - Отчислить студента");
        }

        switch (scanner.nextInt()) {
            case 1:
                i = 0;
                for (Student student : group.getStudents()) {
                    i++;
                    System.out.format("%d) %s", i, student);
                }
                break;
            case 2:
                if (account.getAccountType() != AccountType.Professor) {
                    break;
                }
                System.out.println("Введите номер студента из списка:");
                int number = scanner.nextInt();
                GradeBook gradeBook = group.getStudents().get(number).getGradeBook();
                Professor prof = (Professor) account.getPerson();
                System.out.println("Введите название предмета, за который выставляется оценка:");
                String subj = scanner.next();
                Subject subject = new Subject(subj);
                if (!prof.getSubjects().contains(subject)) {
                    prof.getSubjects().add(subject);
                }
                System.out.println("Введите семестр, за который выставляется оценка:");
                int sem = scanner.nextInt();
                System.out.println("Введите оценку:");
                byte mark = scanner.nextByte();
                gradeBook.putMark(sem, subject, mark);
                System.out.println("Оценка выставлена!");
                break;
            case 3:
                if (account.getAccountType() != AccountType.God) {
                    break;
                }
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
                    break;
                }
                Student currentPerson = new Student(name, surname, patronymic, birthDate, uniBase.getUniversity());
                group.getStudents().add(currentPerson);
                System.out.println("Студент добавлен в группу!");
            case 4:
                if (account.getAccountType() != AccountType.Professor) {
                    break;
                }
                System.out.println("Введите номер студента из списка:");
                number = scanner.nextInt();
                currentPerson = group.getStudents().get(number);
                System.out.format("Вы действитель отчисляете %s? (Введите да)\n", currentPerson);
                if (scanner.next().equalsIgnoreCase("да")) {
                    group.getStudents().remove(currentPerson);
                    currentPerson.callDelegate();
                    System.out.println("Студент отчислен!");
                }

        }

    }
}