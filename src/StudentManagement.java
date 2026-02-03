import java.util.ArrayList;
import java.util.Iterator;
import java.util.InputMismatchException;
import java.util.Scanner;

// 学生クラス：学生情報を格納
class Student {
    int id;          // 学生ID
    String name;     // 名前
    int age;         // 年齢
    int math;        // 数学の点数
    int english;     // 英語の点数
    int science;     // 理科の点数

    // コンストラクタ：学生オブジェクトを初期化
    Student(int id, String name, int age, int math, int english, int science) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.english = english;
        this.science = science;
    }

    // 合計点を計算するメソッド
    int getTotal() {
        return math + english + science;
    }

    // 平均点を計算するメソッド
    double getAverage() {
        return getTotal() / 3.0;
    }
}

public class StudentManagement {

    // 学生リスト：全ての学生情報を保存
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // メインループ：プログラムが終了するまで繰り返す
        while (true) {
            // メニューを表示
            System.out.println("\n==== 学生管理システム ====");
            System.out.println("1. 学生を登録");
            System.out.println("2. 学生一覧を表示");
            System.out.println("3. 学生情報を更新");
            System.out.println("4. 学生を削除");
            System.out.println("0. 終了");
            System.out.print("選択：");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // バッファをクリア

                // ユーザーの選択に応じて処理を実行
                if (choice == 1) {
                    addStudent(sc);
                } else if (choice == 2) {
                    showStudents();
                } else if (choice == 3) {
                    updateStudent(sc);
                } else if (choice == 4) {
                    deleteStudent(sc);
                } else if (choice == 0) {
                    System.out.println("終了します。");
                    break;
                } else {
                    System.out.println("無効な選択です。");
                }
            } catch (InputMismatchException e) {
                // 入力エラー処理：数字以外が入力された場合
                System.out.println("エラー：数字を入力してください。");
                sc.nextLine(); // バッファをクリア
            }
        }

        sc.close();
    }

    // 学生を登録するメソッド
    static void addStudent(Scanner sc) {
        try {
            // 学生IDの入力
            System.out.print("学生ID：");
            int id = sc.nextInt();
            sc.nextLine(); // バッファをクリア

            // IDの重複チェック：同じIDが既に存在する場合はエラー
            for (Student s : studentList) {
                if (s.id == id) {
                    System.out.println("エラー：このIDは既に存在します。");
                    return;
                }
            }

            // 名前の入力
            System.out.print("名前：");
            String name = sc.nextLine();

            // 年齢の入力
            System.out.print("年齢：");
            int age = sc.nextInt();
            
            // 年齢の妥当性チェック：0〜150の範囲内か確認
            if (age < 0 || age > 150) {
                System.out.println("エラー：年齢は0〜150の範囲で入力してください。");
                return;
            }

            // 数学の点数を入力
            System.out.print("数学の点数：");
            int math = sc.nextInt();
            
            // 点数の妥当性チェック（数学）：0〜100の範囲内か確認
            if (math < 0 || math > 100) {
                System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                return;
            }

            // 英語の点数を入力
            System.out.print("英語の点数：");
            int english = sc.nextInt();
            
            // 点数の妥当性チェック（英語）：0〜100の範囲内か確認
            if (english < 0 || english > 100) {
                System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                return;
            }

            // 理科の点数を入力
            System.out.print("理科の点数：");
            int science = sc.nextInt();
            
            // 点数の妥当性チェック（理科）：0〜100の範囲内か確認
            if (science < 0 || science > 100) {
                System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                return;
            }

            // 新しい学生オブジェクトを作成してリストに追加
            Student student = new Student(id, name, age, math, english, science);
            studentList.add(student);

            System.out.println("学生を登録しました。");
        } catch (InputMismatchException e) {
            // 入力形式エラー処理：不正な形式で入力された場合
            System.out.println("エラー：正しい形式で入力してください。");
            sc.nextLine(); // バッファをクリア
        }
    }

    // 学生一覧を表示するメソッド
    static void showStudents() {
        // リストが空の場合：登録されている学生がいない
        if (studentList.isEmpty()) {
            System.out.println("登録されている学生はいません。");
            return;
        }

        System.out.println("\n---- 学生一覧 ----");
        // 全学生の情報を表示：ID、名前、年齢、各科目の点数、合計、平均
        for (Student s : studentList) {
            System.out.println(
                "ID: " + s.id +
                ", 名前: " + s.name +
                ", 年齢: " + s.age +
                ", 数学: " + s.math +
                ", 英語: " + s.english +
                ", 理科: " + s.science +
                ", 合計: " + s.getTotal() +
                ", 平均: " + String.format("%.2f", s.getAverage())
            );
        }
    }

    // 学生情報を更新するメソッド
    static void updateStudent(Scanner sc) {
        try {
            // 更新する学生のIDを入力
            System.out.print("更新する学生ID：");
            int id = sc.nextInt();
            sc.nextLine(); // バッファをクリア

            // IDで学生を検索
            for (Student s : studentList) {
                if (s.id == id) {
                    // 新しい名前を入力
                    System.out.print("新しい名前：");
                    s.name = sc.nextLine();

                    // 新しい年齢を入力
                    System.out.print("新しい年齢：");
                    s.age = sc.nextInt();
                    
                    // 年齢の妥当性チェック：0〜150の範囲内か確認
                    if (s.age < 0 || s.age > 150) {
                        System.out.println("エラー：年齢は0〜150の範囲で入力してください。");
                        return;
                    }

                    // 数学の新しい点数を入力
                    System.out.print("数学の点数：");
                    s.math = sc.nextInt();
                    
                    // 点数の妥当性チェック（数学）：0〜100の範囲内か確認
                    if (s.math < 0 || s.math > 100) {
                        System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                        return;
                    }

                    // 英語の新しい点数を入力
                    System.out.print("英語の点数：");
                    s.english = sc.nextInt();
                    
                    // 点数の妥当性チェック（英語）：0〜100の範囲内か確認
                    if (s.english < 0 || s.english > 100) {
                        System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                        return;
                    }

                    // 理科の新しい点数を入力
                    System.out.print("理科の点数：");
                    s.science = sc.nextInt();
                    
                    // 点数の妥当性チェック（理科）：0〜100の範囲内か確認
                    if (s.science < 0 || s.science > 100) {
                        System.out.println("エラー：点数は0〜100の範囲で入力してください。");
                        return;
                    }

                    System.out.println("学生情報を更新しました。");
                    return;
                }
            }

            // 学生が見つからない場合
            System.out.println("該当する学生が見つかりません。");
        } catch (InputMismatchException e) {
            // 入力形式エラー処理：不正な形式で入力された場合
            System.out.println("エラー：正しい形式で入力してください。");
            sc.nextLine(); // バッファをクリア
        }
    }

    // 学生を削除するメソッド
    static void deleteStudent(Scanner sc) {
        try {
            // 削除する学生のIDを入力
            System.out.print("削除する学生ID：");
            int id = sc.nextInt();
            sc.nextLine(); // バッファをクリア

            // Iteratorを使用してConcurrentModificationExceptionを回避
            // ArrayListを繰り返し処理中に要素を削除する場合はIteratorを使用する
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                Student s = iterator.next();
                if (s.id == id) {
                    iterator.remove(); // 安全に削除
                    System.out.println("学生情報を削除しました。");
                    return;
                }
            }

            // 学生が見つからない場合
            System.out.println("該当する学生が見つかりません。");
        } catch (InputMismatchException e) {
            // 入力エラー処理：数字以外が入力された場合
            System.out.println("エラー：数字を入力してください。");
            sc.nextLine(); // バッファをクリア
        }
    }
}
