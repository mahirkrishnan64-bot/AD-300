import java.util.Scanner;

public class PercentToGpa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student's percent: ");
        double percent = input.nextDouble();

        if (percent > 100 || percent < 0) {
            System.out.println("Invalid percent. Enter a value from 0 to 100.");
        } else if (percent >= 95.0) {
            System.out.println("GPA: 4.0");
        } else if (percent >= 94.0) {
            System.out.println("GPA: 3.9");
        } else if (percent >= 93.0) {
            System.out.println("GPA: 3.8");
        } else if (percent >= 92.0) {
            System.out.println("GPA: 3.7");
        } else if (percent >= 91.0) {
            System.out.println("GPA: 3.6");
        } else if (percent >= 90.0) {
            System.out.println("GPA: 3.5");
        } else if (percent >= 89.0) {
            System.out.println("GPA: 3.4");
        } else if (percent >= 88.0) {
            System.out.println("GPA: 3.3");
        } else if (percent >= 87.0) {
            System.out.println("GPA: 3.2");
        } else if (percent >= 86.0) {
            System.out.println("GPA: 3.1");
        } else if (percent >= 85.0) {
            System.out.println("GPA: 3.0");
        } else if (percent >= 84.0) {
            System.out.println("GPA: 2.9");
        } else if (percent >= 83.0) {
            System.out.println("GPA: 2.8");
        } else if (percent >= 82.0) {
            System.out.println("GPA: 2.7");
        } else if (percent >= 81.0) {
            System.out.println("GPA: 2.6");
        } else if (percent >= 80.0) {
            System.out.println("GPA: 2.5");
        } else if (percent >= 79.0) {
            System.out.println("GPA: 2.4");
        } else if (percent >= 78.0) {
            System.out.println("GPA: 2.3");
        } else if (percent >= 77.0) {
            System.out.println("GPA: 2.2");
        } else if (percent >= 76.0) {
            System.out.println("GPA: 2.1");
        } else if (percent >= 75.0) {
            System.out.println("GPA: 2.0");
        } else if (percent >= 74.0) {
            System.out.println("GPA: 1.9");
        } else if (percent >= 73.0) {
            System.out.println("GPA: 1.8");
        } else if (percent >= 72.0) {
            System.out.println("GPA: 1.7");
        } else if (percent >= 71.0) {
            System.out.println("GPA: 1.6");
        } else if (percent >= 70.0) {
            System.out.println("GPA: 1.5");
        } else if (percent >= 69.0) {
            System.out.println("GPA: 1.4");
        } else if (percent >= 68.0) {
            System.out.println("GPA: 1.3");
        } else if (percent >= 67.0) {
            System.out.println("GPA: 1.2");
        } else if (percent >= 66.0) {
            System.out.println("GPA: 1.1");
        } else if (percent >= 65.0) {
            System.out.println("GPA: 1.0");
        } else {
            System.out.println("GPA: 0.0");
        }

        input.close();
    }
}