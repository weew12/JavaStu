package site.weew12.chapter11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java比较器
 * Comparable
 * Comparator
 *
 * @author weew12
 */
public class CompareTest {

    public static void test1() {
        Boolean[] bools = {true, false, false, false, true};
        Arrays.sort(bools);
        for (Boolean bool : bools) {
            System.out.print(bool + " ");
        }
    }

    /**
     * 使用Comparable的方法实现自然排序
     * 按照students的id实现从小到大排序
     */
    public static void test2() {
        Student[] students = new Student[5];
        students[0] = new Student(3, "张三", 90, 23);
        students[1] = new Student(1, "熊大", 100, 22);
        students[2] = new Student(5, "王五", 75, 25);
        students[3] = new Student(4, "李四", 85, 24);
        students[4] = new Student(2, "熊二", 85, 18);

        System.out.println(students[0].compareTo(students[1]));
        System.out.println(students[1].compareTo(students[2]));
        System.out.println(students[2].compareTo(students[2]));

        System.out.println("所有学生：");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        System.out.println("按照学号排序：");
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public static void test3() {
        Student[] arr = new Student[5];
        arr[0] = new Student(3, "张三", 90, 23);
        arr[1] = new Student(1, "熊大", 100, 22);
        arr[2] = new Student(5, "王五", 75, 25);
        arr[3] = new Student(4, "李四", 85, 24);
        arr[4] = new Student(2, "熊二", 85, 18);

        System.out.println("所有学生：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Arrays.sort(arr, new StudentScoreComparator());

        System.out.println("按照成绩排序：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
}

class Student implements Comparable {
    private int id;
    private String name;
    private int score;
    private int age;

    public Student(int id, String name, int score, int age) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.id - student.id;
    }
}

/**
 * 定制学生类的比较器
 *      首先比较学生的成绩
 *      如果成绩相同则比较学号id
 */
class StudentScoreComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student2 = (Student) o2;
        int result = student.getScore() - student2.getScore();
        return result != 0 ? result : student.getId() - student2.getId();
    }
}