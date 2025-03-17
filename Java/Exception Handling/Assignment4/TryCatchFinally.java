//In Java, throw and throws are two distinct keywords related to exception handling, but they serve different purposes. Let's explore the difference between throw and throws.
//
//1. throw (Used to throw an exception)
//Purpose: The throw keyword is used to actually throw an exception within a method or a block of code. When throw is used, it creates an instance of an exception and transfers control to the nearest enclosing catch block (if any) or the calling method if it is not caught.
//
//Where to use: It is used inside the method body to explicitly throw an exception.

//throws (Used to declare an exception)
//Purpose: The throws keyword is used to declare that a method might throw one or more exceptions. It is used in the method signature to tell the compiler and the calling code that this method may throw a specific type of exception, and the caller is responsible for handling it (either with a try-catch or by declaring it with throws again).
//
//Where to use: It is used in the method declaration to indicate that the method could throw a certain type of exception.



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
