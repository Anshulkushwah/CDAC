import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadStudentObject {
	
	private static void findresult(Student s)
	{
		if(s.mark>16)
		{
			System.out.print(" pass");
		}else
			System.out.print(" fail");
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("student.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
//		Student s1 =(Student) ois.readObject();
//		Student s2 =(Student) ois.readObject();
//		Student s3 =(Student) ois.readObject();
//		
//		s1.displayStudent();
//		s2.displayStudent();
//		s3.displayStudent();
		
		
		Student s;
		
		try
		{
		while((s= (Student) ois.readObject())!=null)
		{
			s.displayStudent();
			findresult(s);
			
			System.out.println();
		}
		}catch(EOFException e)
		{
			System.out.println("end of file");
		}
		
		fis.close();
		ois.close();
	}
}
