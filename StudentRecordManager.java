import java.util.Map;
import java.util.TreeMap;

public class StudentRecordManager {
    private final TreeMap<Integer, Student> records = new TreeMap<>();

    public boolean addStudentRecord(int studentId, String name, double gpa) {
        if (records.containsKey(studentId)) {
            System.out.println("Add failed: Student ID " + studentId + " already exists.");
            return false;
        }

        records.put(studentId, new Student(studentId, name, gpa));
        System.out.println("Added: " + records.get(studentId));
        return true;
    }

    public boolean deleteStudentRecord(int studentId) {
        Student removed = records.remove(studentId);

        if (removed == null) {
            System.out.println("Delete failed: No student found with ID " + studentId + ".");
            return false;
        }

        System.out.println("Deleted: " + removed);
        return true;
    }

    public boolean updateStudentRecord(int studentId, double newGpa) {
        Student student = records.get(studentId);

        if (student == null) {
            System.out.println("Update failed: No student found with ID " + studentId + ".");
            return false;
        }

        student.setGpa(newGpa);
        System.out.println("Updated: " + student);
        return true;
    }

    public void displayAllRecords() {
        System.out.println("\nAll student records (sorted by student ID):");

        if (records.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Map.Entry<Integer, Student> entry : records.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void displayStudentsAboveGpa(double threshold) {
        System.out.printf("\nStudents with GPA higher than %.2f:\n", threshold);

        boolean found = false;
        for (Student student : records.values()) {
            if (student.getGpa() > threshold) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found above the specified GPA.");
        }
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();

        System.out.println("=== Adding 5 student records ===");
        manager.addStudentRecord(1005, "Ava Patel", 3.40);
        manager.addStudentRecord(1002, "Liam Chen", 3.90);
        manager.addStudentRecord(1008, "Mia Johnson", 2.95);
        manager.addStudentRecord(1001, "Noah Garcia", 3.15);
        manager.addStudentRecord(1004, "Emma Wilson", 3.75);

        manager.displayAllRecords();

        System.out.println("\n=== Updating GPA for student 1008 ===");
        manager.updateStudentRecord(1008, 3.25);
        manager.displayAllRecords();

        System.out.println("\n=== Deleting student 1004 ===");
        manager.deleteStudentRecord(1004);
        manager.displayAllRecords();

        manager.displayStudentsAboveGpa(3.0);

        System.out.println("\n=== Additional Test Cases ===");

        System.out.println("\nTest Case 1: Add duplicate student ID");
        manager.addStudentRecord(1002, "Duplicate Student", 3.50);

        System.out.println("\nTest Case 2: Update non-existent student");
        manager.updateStudentRecord(9999, 3.80);

        System.out.println("\nTest Case 3: Delete non-existent student");
        manager.deleteStudentRecord(7777);

        System.out.println("\nTest Case 4: Show students above 3.8 GPA");
        manager.displayStudentsAboveGpa(3.8);

        System.out.println("\nTest Case 5: Show students above 4.0 GPA");
        manager.displayStudentsAboveGpa(4.0);
    }
}

class Student {
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

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + " | GPA: " + String.format("%.2f", gpa);
    }
}