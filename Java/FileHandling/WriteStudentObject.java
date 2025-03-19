import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteStudentObject {

	public static void main(String[] args) throws IOException {
		Student s1 = new Student(1001, "Anshul", 10);
		Student s2 = new Student(1002,"Vaibhav",50);
		Student s3 = new Student(1003, "Ashish",60);
		
		ArrayList<Student> al = new ArrayList<>();
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		FileOutputStream fos = new FileOutputStream("student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		

//		oos.writeObject(s1);
//		oos.writeObject(s2);
//		oos.writeObject(s3);
		oos.writeObject(al);
		
		System.out.println("object write is over");
		oos.close();
		fos.close();

	}

}
