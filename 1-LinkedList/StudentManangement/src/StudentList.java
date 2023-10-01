import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class StudentList {
    private List<Student> studentList;
    private final String fileName = "sinhvien.txt";

    public StudentList() {
        studentList = new LinkedList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : studentList) {
                String line = student.getStudentId() + "," + student.getStudentName() + ","
                        + student.getDateOfBirth() + "," + student.getAddress();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data saved to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data to the file.");
        }
    }

    public void loadFromFile() {
        studentList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String studentId = parts[0];
                    String studentName = parts[1];
                    String dateOfBirth = parts[2];
                    String address = parts[3];
                    studentList.add(new Student(studentId, studentName, dateOfBirth, address));
                }
            }
            System.out.println("Data loaded from the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading the data from the file.");
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    
    public Student getStudentById(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}