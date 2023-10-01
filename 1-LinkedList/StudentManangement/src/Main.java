import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    enterStudentInfo(scanner, studentList);
                    break;
                case 2:
                    retrieveStudentInfo(scanner, studentList);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("1. Enter student information");
        System.out.println("2. Retrieve student information");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void enterStudentInfo(Scanner scanner, StudentList studentList) {
        String studentId, studentName, dateOfBirth, address;
        do {
            System.out.print("Enter Student ID (or 'q' to quit): ");
            studentId = scanner.nextLine();
            if (studentId.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Enter Student Name: ");
            studentName = scanner.nextLine();

            System.out.print("Enter Date of Birth: ");
            dateOfBirth = scanner.nextLine();

            System.out.print("Enter Address: ");
            address = scanner.nextLine();

            Student student = new Student(studentId, studentName, dateOfBirth, address);
            studentList.addStudent(student);
        } while (true);

        studentList.saveToFile();
    }

    public static void retrieveStudentInfo(Scanner scanner, StudentList studentList) {
        studentList.loadFromFile();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = studentList.getStudentById(studentId);

        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
        } else {
            System.out.println("Student not found.");
        }
    }
}