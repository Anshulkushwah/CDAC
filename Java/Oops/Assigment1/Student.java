
public class Student {

	int id;
    String name;
    int marks;
    String result;

    public void initializeDetails(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void findResult() {
        if (marks >= 40) {
            result = "Pass";
        } else {
            result = "Fail";
        }
    }

    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Result: " + result);
    }
}
