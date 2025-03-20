import java.util.HashMap;
import java.util.Map;

// Student Management System
public class StudentManagementSystem {
    private HashMap<Integer, Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new HashMap<>();
    }

    // Add Student
    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("Student added successfully!");
    }

    // Update Student
    public void updateStudent(Integer id, String name, String course, Double marks) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setCourse(course);
            student.setMarks(marks);
            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete Student
    public void deleteStudent(Integer id) {
        if (students.remove(id) != null) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Search Student
    public void searchStudent(Integer id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println("Student Found: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Display All Students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("Student Records:");
            for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    // Business Logic: Get Scholarship Eligible Students
    public void getScholarshipEligibleStudents() {
        System.out.println("Students Eligible for Scholarship:");
        boolean found = false;
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            if (student.getMarks() >= 85) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students eligible for a scholarship.");
        }
    }

    // Main Method for Demonstration
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        // Adding Students
        system.addStudent(new Student(1, "Alice", "Computer Science", 90.0));
        system.addStudent(new Student(2, "Bob", "Mathematics", 75.0));
        system.addStudent(new Student(3, "Charlie", "Physics", 88.0));

        // Display All Students
        system.displayAllStudents();

        // Search for a Student
        system.searchStudent(2);

        // Update a Student
        system.updateStudent(2, "Bob Johnson", "Mathematics", 78.0);

        // Display All Students after Update
        system.displayAllStudents();

        // Delete a Student
        system.deleteStudent(3);

        // Display All Students after Deletion
        system.displayAllStudents();

        // Display Scholarship Eligible Students
        system.getScholarshipEligibleStudents();
    }
}
