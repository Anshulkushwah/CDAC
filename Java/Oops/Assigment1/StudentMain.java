import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
        Student student = new Student();
        
        Scanner sc = new Scanner(System.in);
        
        // Taking student details as input
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        
        sc.nextLine();  // Consume the newline left over
        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        
        student.initializeDetails(id, name, marks);
        
        student.findResult();

        student.displayDetails();
        
        
        sc.close();

	}

}
