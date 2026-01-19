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
            System.out.println("3. 学生情報を更新");
            System.out.println("4. 学生を削除");
            System.out.println("0. 終了");
            System.out.print("選択：");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addStudent(sc);
            } else if (choice == 2) {
                showStudents();
            }else if (choice == 3) {
                updateStudent(sc);
            }else if (choice == 4) {
                deleteStudent(sc);
            }else if (choice == 0) {
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
    static void deleteStudent(Scanner sc) {
    System.out.print("削除する学生ID：");
    int id = sc.nextInt();
    sc.nextLine();

    for (Student s : studentList) {
        if (s.id == id) {
            studentList.remove(s);
            System.out.println("学生情報を削除しました。");
            return;
        }
    }

    System.out.println("該当する学生が見つかりません。");
}
    static void updateStudent(Scanner sc) {
    System.out.print("更新する学生ID：");
    int id = sc.nextInt();
    sc.nextLine();

    for (Student s : studentList) {
        if (s.id == id) {
            System.out.print("新しい名前：");
            s.name = sc.nextLine();

            System.out.print("新しい年齢：");
            s.age = sc.nextInt();

            System.out.println("学生情報を更新しました。");
            return;
        }
    }

    System.out.println("該当する学生が見つかりません。");
}

}
