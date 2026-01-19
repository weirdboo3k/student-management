import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class StudentManagement {

    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==== 学生管理システム ====");
            System.out.println("1. 学生を登録");
            System.out.println("2. 学生一覧を表示");
            System.out.println("0. 終了");
            System.out.print("選択：");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addStudent(sc);
            } else if (choice == 2) {
                showStudents();
            } else if (choice == 0) {
                System.out.println("終了します。");
                break;
            } else {
                System.out.println("無効な選択です。");
            }
        }

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("学生ID：");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("名前：");
        String name = sc.nextLine();

        System.out.print("年齢：");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);
        studentList.add(student);

        System.out.println("学生を登録しました。");
    }

    static void showStudents() {
        System.out.println("---- 学生一覧 ----");
        for (Student s : studentList) {
            System.out.println(
                "ID: " + s.id +
                ", 名前: " + s.name +
                ", 年齢: " + s.age
            );
        }
    }
}
