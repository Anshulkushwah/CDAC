import java.util.ArrayList;

public class EmployeeMain extends Employee {
	
	
	ArrayList<Employee>al = new ArrayList<>();

	public EmployeeMain(int id, String name, String designation, double salary,double ex) {
		super(id, name, designation, salary,ex);
		
	}
	
	public void getPromotionEligibleEmployees() {
	    for (Employee temp : al) {
	    	if(temp.ex >= 5) {
				System.out.println(temp.name+" CONGRATULATION ! you are eligible for promotion");
			}
	    }
	}
	
	public void addEmployee(int id, String name, String designation, double salary,double ex) {
		EmployeeMain Em = new EmployeeMain(id,name,designation, salary,ex);
		al.add(Em);
		System.out.println("Employee add succesfully");
		
	}
		
	public void updateEmployee (int Lastid,int newid) {
		boolean check =false;
		for(Employee temp : al) {
			if(temp.id == Lastid) {
				temp.id = newid;
				check = true;
				System.out.println(temp.name+" Id update succesfully");
				 break;
			}
		}
		
		if(!check) System.out.println("Id Not found in database");
			
	}
	
	public void Delete_Employee (int id) {
		
		boolean check =false;
		for(Employee temp : al) {
			if(temp.id == id) {
				al.remove(temp);
				check = true;
				System.out.println(temp.name+" Employee remove succesfully");
				break;
			}
		}
		
		if(!check) System.out.println("Employee Not found in database");
		
	}
	
	public void searchEmployee (int id) {
		boolean check =false;
		for(Employee temp : al) {
			if(temp.id == id) {
				check = true;
				temp.getEmpData();
				break;
			}
		}
		
		if(!check) System.out.println("Employee Not found in database");
	}
	
	public void displayAllEmployees () {
		  boolean check = false;

		    for (Employee temp : al) {
		        temp.getEmpData();
		        check = true; 
		    }

		    if (!check) {
		        System.out.println("No employees found in the database.");
		    }
	}

	public static void main(String[] args) {
		
		EmployeeMain employeeMain = new EmployeeMain(0, "", "", 0.0, 0.0);
		
		employeeMain.addEmployee(102, "Anshul", "Manager", 2000, 5);
		employeeMain.addEmployee(103, "Ravi", "Developer", 1500, 3);
		employeeMain.addEmployee(104, "Priya", "HR", 1800, 4);
		employeeMain.addEmployee(105, "Kiran", "Tester", 1400, 2);
		employeeMain.addEmployee(106, "Neha", "Designer", 1600, 6);
		
		
		employeeMain.displayAllEmployees();
		employeeMain.getPromotionEligibleEmployees();
		employeeMain.searchEmployee(102);
		employeeMain.updateEmployee(102, 103);
		employeeMain.Delete_Employee(103);
		employeeMain.displayAllEmployees();
		employeeMain.getPromotionEligibleEmployees();


	}

}
