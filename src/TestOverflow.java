class Student {
    int id;
    String name;
    int age;
    int math;
    int english;
    int science;

    Student(int id, String name, int age, int math, int english, int science) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.english = english;
        this.science = science;
    }

    int getTotal() {
        return math + english + science;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }
}

public class TestOverflow {
    public static void main(String[] args) {
        // Test with maximum valid scores
        Student s1 = new Student(1, "Test", 20, 100, 100, 100);
        System.out.println("Valid scores (100,100,100): Total=" + s1.getTotal() + ", Average=" + s1.getAverage());
        
        // Test with values that could overflow if scores weren't validated
        Student s2 = new Student(2, "Test2", 20, Integer.MAX_VALUE / 3, Integer.MAX_VALUE / 3, Integer.MAX_VALUE / 3);
        System.out.println("Large scores: Total=" + s2.getTotal() + ", Average=" + s2.getAverage());
        
        // Test potential overflow scenario
        Student s3 = new Student(3, "Test3", 20, 1000000000, 1000000000, 1000000000);
        System.out.println("Very large scores: Total=" + s3.getTotal() + ", Average=" + s3.getAverage());
    }
}
