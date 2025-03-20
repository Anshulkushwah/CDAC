
public class Employee {

		int id;
		String name;
		String designation;
		double salary;
		double ex;
		
		
		public Employee(int id, String name, String designation, double salary,double ex) {
			this.id = id;
			this.name = name;
			this.designation = designation;
			this.salary = salary;
			this.ex = ex;
		}
		
		public void getEmpData() {
			
			System.out.println(
					"Employe Id : "+this.id+
					" Name : "+ this.name+
					" designation : "+this.name+
					" salary : "+this.salary
					);
			
		}
		
		public void getPromotionEligibleEmployees() {
			System.out.println(this.name + " is eligible for promotion based on the default criteria.");
		}
}
