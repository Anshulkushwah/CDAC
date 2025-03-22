import java.io.Serializable;

public class Student implements Serializable {
	
//public class Student{	

	 int studentId;
	 String name;
	 String course;
	 double marks;
	 
	public Student(int studentId, String name, String course, double marks) {
		this.studentId = studentId;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
//    public String toString() {
//		return String.format("ID: %d, Name: %s, Course: %s, Marks: %.2f", studentId, name, course, marks);
//	}
	public void display() {
		System.out.println("studentId : "+this.studentId+" name : "+this.name+" course : "+this.course+" marks : "+this.marks);
	}
	
	
}
