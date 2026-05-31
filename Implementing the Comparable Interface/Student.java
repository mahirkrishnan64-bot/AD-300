import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private double gpa;

    public Student(int studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return "Student{id=" + studentId + ", name='" + name + "', gpa=" + gpa + "}";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(101, "Ava", 3.2));
        students.add(new Student(102, "Brian", 3.9));
        students.add(new Student(103, "Chloe", 2.8));
        students.add(new Student(104, "Daniel", 3.5));
        students.add(new Student(105, "Ella", 3.9));
        students.add(new Student(106, "Frank", 3.0));

        Collections.sort(students);

        System.out.println("Students sorted by GPA (ascending):");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}