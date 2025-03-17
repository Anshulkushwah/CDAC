import java.util.Scanner;
//
//public class TryCatchFinally {
//	public static void CheckAge(int age) {
//		
//		if(age < 18) {
////			ArithmeticException a = new ArithmeticException("");
////			ArithmeticException a = new ArithmeticException("Age is below 18!");
//				throw new RuntimeException("Age is below 18!");
//			
//			throw a;
//		}
//		
//	}
//	
//
//	public static void main(String[] args) {
//		
//	
//		System.out.print("Enter your age: ");
//		Scanner scan = new Scanner(System.in);
//		
//		 int age1 = scan.nextInt();
//		 System.out.println("----------------------------------------------");
//		
//		try {
//			CheckAge(age1);
//            System.out.println("Age verification successful!");
//        } catch(Exception e) {
//            System.out.println("Error while checking age: " + e.getMessage());
//            System.out.println("----------------------------------------------");
//            System.out.println("Error while checking age: " + e);
//        } finally {
//            scan.close();
//        }
//
//	}
//
//}



public class TryCatchFinally {
	 public static void riskyMethod() throws ArithmeticException {
//		 throw new ArithmeticException("Cannot divide by zero!");
	        int result = 10 / 0;  // This will throw ArithmeticException
	    }

	    public static void main(String[] args) {
	        try {
	            riskyMethod();  // Calling a method that throws ArithmeticException
	        } catch (ArithmeticException e) {
	            // Handling ArithmeticException specifically
	            System.out.println("ArithmeticException caught: " + e.getMessage());
	        } catch (Exception e) {
	            // Handling other exceptions if they occur
	            System.out.println("Some other exception caught: " + e.getMessage());
	        }
	    }       
}
