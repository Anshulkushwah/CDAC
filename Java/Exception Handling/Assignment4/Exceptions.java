public class Exceptions {

    // Method to demonstrate throws
    public static void testThrows() throws ArithmeticException {
        // Throwing an exception deliberately
        throw new ArithmeticException("This is an ArithmeticException thrown by testThrows method.");
    }

    public static void main(String[] args) {
        // 1. Try-catch-finally combination
        try {
            System.out.println("Trying to divide by zero.");
            System.out.println("----------------------------------------------");
            int result = 10 / 0;  // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
     
        } finally {
            System.out.println("This is the 'finally' block. It executes no matter what.");
            System.out.println("----------------------------------------------");

        }

        // 2. Multiple catch blocks
        try {
            System.out.println("Trying to parse a string to integer.");
            System.out.println("----------------------------------------------");
            int num = Integer.parseInt("abc"); // This will cause NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
            System.out.println("----------------------------------------------");
        } catch (Exception e) {
            System.out.println("Caught a generic Exception: " + e.getMessage());
            
        } finally {
            System.out.println("This is the 'finally' block after multiple catches.");
            System.out.println("----------------------------------------------");
        }

        // 3. Try-finally combination (no catch)
        try {
            System.out.println("Trying to throw an exception with testThrows method.");
            System.out.println("----------------------------------------------");
            testThrows(); // This will throw an ArithmeticException
        } finally {
            System.out.println("This is the 'finally' block after testThrows method.");
            System.out.println("----------------------------------------------");
        }

        // 4. Nested try blocks
        try {
            System.out.println("Outer try block.");
            try {
                System.out.println("Inner try block.");
                int[] arr = new int[5];
                arr[10] = 50;  // This will cause ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught ArrayIndexOutOfBoundsException in inner block: " + e.getMessage());
                System.out.println("----------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Caught a general exception in the outer block: " + e.getMessage());
            System.out.println("----------------------------------------------");
        } finally {
            System.out.println("Finally block after nested try blocks.");
            System.out.println("----------------------------------------------");
        }
    }
}

