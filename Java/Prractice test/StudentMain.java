import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentMain {

	private static final String FILE_NAME = "students.txt";
    private ArrayList<Student> Al = new ArrayList<>();
    
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(Al); // Serialize the ArrayList<Student>
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	public void addStudent(Student student) throws IOException {
		Al.add(student);
		saveToFile();
	} 
	
	@SuppressWarnings("unchecked")
	public void readFromFile() throws ClassNotFoundException {
	    try (FileInputStream fis = new FileInputStream(FILE_NAME);
	         ObjectInputStream ois = new ObjectInputStream(fis)) {
	        Al.clear();
	        Al = (ArrayList<Student>) ois.readObject();
	        Al.forEach(Student::display); // Cleaner way to display all students
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println();
	}
	
	public void removeStudent(int studentId) throws IOException {
        Al.removeIf(student -> student.getStudentId() == studentId);
        saveToFile();
    }

	public void findStudentById(int studentId) {
		
		boolean check = false;
        for (Student student : Al) {
            if (student.getStudentId() == studentId) {
                student.display();
                check = true;
            }
        }
        if(!check)System.out.println("Student not found ");
    }
	
	public void updateMarks(int studentId, double newMarks) throws IOException {
        for (Student student : Al) {
            if (student.getStudentId() == studentId) {
                student.setMarks(newMarks);
                break;
            }
        }
        saveToFile();
    }
	
	public void displayStudents() {
        for (Student student : Al) {
            student.display();
        }
    }
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		StudentMain manager = new StudentMain();
		 manager.addStudent(new Student(1, "Anshul", "Math", 85.5));
	     manager.addStudent(new Student(2, "Sita", "Science", 90.0));
	     manager.addStudent(new Student(3, "Raj", "History", 76.3));
	     manager.addStudent(new Student(4, "Lila", "Art", 88.8));
	     manager.addStudent(new Student(5, "Vikram", "Engineering", 93.2));
	     
	     
	     	System.out.println("Reading from file:");
	        manager.readFromFile();
	        
	        System.out.println("Display from file:");
	        manager.displayStudents();

	        System.out.println("\nFinding student with ID 3:");
	        manager.findStudentById(3);

	        System.out.println("\nRemoving student with ID 2:");
	        manager.removeStudent(2);
	        manager.displayStudents();

	        System.out.println("\nUpdating marks for student with ID 4:");
	        manager.updateMarks(4, 95.0);
	        manager.displayStudents();
		
	}

}
