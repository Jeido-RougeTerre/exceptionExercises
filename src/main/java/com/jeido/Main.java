package com.jeido;

import com.jeido.entity.Student;
import com.jeido.exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                    == choose an exercise ==
                    1. Gestion d'une conversion de type incorrecte
                    2. Racine Carre
                    3. Gestion d'un accès à un élément inexistant dans un tableau
                    4. Création d'une exception personnalisée
                    0. Quit
                    >\s""");

            String input = sc.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> one();
                    case 2 -> two();
                    case 3 -> three();
                    case 4 -> four();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid choice ! [0-4]");
                }
                System.out.print("[Press ENTER] ");
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice ! [0-4]");
            }
        }
    }

    private static void one() {
        boolean flag = false;
        while (!flag) {
            System.out.print("Enter integer: ");
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                System.out.println(number + " is a Integer");
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a Integer");
            }
        }
    }

    private static void two() {
        while (true) {
            System.out.print("Enter a positive integer: ");
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0) {
                    throw new NumberFormatException();
                }
                System.out.println("√(" + number + ") = " + Math.sqrt(number));
                return;
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a Positive Integer");
            }
        }
    }

    private static void three() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        while (true) {
            System.out.printf("Array : %s\nAccess Index : ", Arrays.toString(numbers));
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0) {
                    throw new NumberFormatException();
                }
                int i = numbers[number];
                System.out.printf("%d is in array at index %s%n", i, number);
                return;
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a positive Integer");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(input + " is out of bounds");
            }
        }
    }

    private static void four() {
        while (true) {
            System.out.print("""
                    == Student Manager ==
                    1. Show student list
                    2. Add student
                    0. Quit
                    >\s""");
            String input = sc.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> listStudents();
                    case 2 -> addStudent();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice ! [0-2]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice ! [0-2]");
            }
            System.out.print("[Press ENTER] ");
            sc.nextLine();
        }
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("Student List is empty!");
            return;
        }

        System.out.println("Student List :");
        students.forEach(System.out::println);
    }

    private static void addStudent() {
        while (true) {
            System.out.println("Adding a student");
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.print("age(18-84): ");
            String ageString = sc.nextLine();
            try {
                int age = Integer.parseInt(ageString);
                Student student = new Student(name, age);
                students.add(student);
                System.out.println("Student added : " + student);
                return;
            } catch (NumberFormatException | InvalidAgeException e) {
                System.out.println("Invalid age ! [18-84]");
            }
        }
    }
}