package toop.project.uni.consoleapp;

//Точка входа в консольное приложение

import toop.project.uni.models.*;

import java.util.Scanner;

class Main {
    private static Univesity univesity;

    public static void main(String[] args) {
        univesity = new Univesity("ГОВНО");
        System.out.println("Добро пожаловать в Университет "+ univesity.toString() + "!");
        System.out.println("Введите свой ID: ");
        Scanner scanner = new Scanner((System.in));
        int loginInput = scanner.nextInt();
        //здесь мы сравниваем введенный  ID с тем какие есть (корректный ввели или нет)
        System.out.println("Введите свой пароль: ");
        int passwordInput = scanner.nextInt();
        //здесь мы сравниваем введенный  пароль (правильный или нет, если нет вывести ошибку неверный пароль)
        for (Institute institute : univesity.getInstituteList()) {
            for (Department department : institute.getDepartmentList()) {
                for (Laboratory laboratory : department.getLaboratoryList()) {
                    for (Professor professor : laboratory.getProfessorList()) {

                    }
                }
                for (Specialty specialty : department.getSpecialtyList()) {
                    for (Group group : specialty.getGroupList()) {

                    }
                }
            }
        }

        if ( == препод)
                {
                    //добавить оценку студенту
                    //добавить в список публикаций публикацию
                    //отчислить нахуй всех))))))
                    System.out.println("Выберите дальнейшее действие:");
                    System.out.println("Поставить оценку - 1");
                    System.out.println("Добавить публикацию - 2");


                }
        else() { if (ID_input == student){
            //если студент
         //вывести его оценки за текущий семестр
        //по запросу вывести оценки за все время обучения
        //добавить в список публикаций публикацию}
            System.out.println("Выберите дальнейшее действие:");
            System.out.println("Просмотреть оценки за семестр - 1");
            System.out.println("Просмотреть оценки за весь период обучения - 2");
            System.out.println("Добавить публикацию - 3");
        else {
        // режим бога: можно отчислить/добавить студента/группу студентов
                System.out.println("Выберите дальнейшее действие:");
                System.out.println("Добавить студента - 1");
                System.out.println("Отчислить студента - 2");
                System.out.println("Добавить преподавателя - 3");
                System.out.println("Уволить преподавателя - 4");
                System.out.println("Уничтожить весь университет - 5");
        }
        }

        }
    }


}