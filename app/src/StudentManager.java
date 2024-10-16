import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void editStudent(String id, String newName, double newScore) {
        Student student = findStudent(id);
        if (student != null) {
            // Create a new student with the updated information
            Student updatedStudent = new Student(id, newName, newScore);
            // Remove the old student and add the new student with the updated information
            removeStudent(id);
            addStudent(updatedStudent);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}