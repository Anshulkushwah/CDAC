
public class Emp {
	int empno;
	String empname;
	String designation;
	String dept;
	int salary;
	
	public void readEmpData(int empno,String empname,
			String designation,String dept,int salary) {
		
		this.empno = empno;
		this.empname = empname;
		this.designation = designation;
		this.dept = dept;
		this.salary = salary;
	}
	
	public void displayEmpData() {
		System.out.println("Please find below employe data : ");
		System.out.println("Employe Number      : "+empno);
		System.out.println("Employe Name        : "+empname);
		System.out.println("Employe Designation : "+designation);
		System.out.println("Employe Department  : "+dept);
		System.out.println("Employe Salary      : "+salary);
		
	}

};
