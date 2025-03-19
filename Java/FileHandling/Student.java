
import java.io.Serializable;
public class Student implements Serializable {
	int sid;
	String name;
	float mark;
	
	public Student(int sid, String name, float mark)
	{
		
		this.sid = sid;
		this.name = name;
		this.mark= mark;
	}
	
	void displayStudent()
	   {
		   System.out.print(sid+name+mark);
	   }

}
