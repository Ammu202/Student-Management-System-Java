import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, age, grade);
                    studentDAO.addStudent(newStudent);
                    break;

                case 2:
                    List<Student> students = studentDAO.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();

                    Student updatedStudent = new Student(updateId, newName, newAge, newGrade);
                    studentDAO.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    studentDAO.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
