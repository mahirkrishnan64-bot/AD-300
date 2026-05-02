public class Main {
    public static void main(String[] args) {
        School school = new School("Springfield High");

        Department science = new Department("Science");
        Department mathematics = new Department("Mathematics");

        Teacher t1 = new Teacher("Mr. Smith", "Biology");
        Teacher t2 = new Teacher("Mrs. Jones", "Chemistry");
        Teacher t3 = new Teacher("Mr. White", "Calculus");
        Teacher t4 = new Teacher("Ms. Black", "Algebra");

        Student s1 = new Student("John Doe", "Grade 10");
        Student s2 = new Student("Jane Doe", "Grade 12");
        Student s3 = new Student("Jim Beam", "Grade 11");
        Student s4 = new Student("Tim Cook", "Grade 10");
        Student s5 = new Student("Ann Taylor", "Grade 11");
        Student s6 = new Student("Gary Oak", "Grade 12");

        science.addTeacher(t1);
        science.addTeacher(t2);
        science.addStudent(s1);
        science.addStudent(s2);
        science.addStudent(s3);

        mathematics.addTeacher(t3);
        mathematics.addTeacher(t4);
        mathematics.addStudent(s4);
        mathematics.addStudent(s5);
        mathematics.addStudent(s6);

        school.addDepartment(science);
        school.addDepartment(mathematics);

        System.out.println("School: " + school.getName());
        System.out.println("Departments:");
        for (Department dept : school.getAllDepartments()) {
            System.out.println("- " + dept.getName());
        }

        System.out.println();

        for (Department dept : school.getAllDepartments()) {
            System.out.println(dept.getName() + " Department");

            System.out.println("- Teachers:");
            for (Teacher teacher : dept.getAllTeachers()) {
                System.out.println("  " + teacher.getName() + " (" + teacher.getSubject() + ")");
            }

            System.out.println("- Students:");
            for (Student student : dept.getAllStudents()) {
                System.out.println("  " + student.getName() + " (" + student.getGradeLevel() + ")");
            }

            System.out.println();
        }
    }
}