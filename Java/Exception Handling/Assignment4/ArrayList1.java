//import java.util.ArrayList;
//import java.util.Collections;
//
//public class ArrayList1 {
//
//	public static void main(String[] args) {
//		ArrayList<Integer>arr = new ArrayList<>();
//		
//		arr.add(4);
//		arr.add(4);
//		arr.add(5);
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		
////		arr.set(4, 5);
////		arr.remove(2);
//		
////		for(Integer a:arr) {
////			if(a==4) {
////				arr.remove(a); 
////			}
////		}
//		
//		
//		
////		for (int i = arr.size() - 1; i >= 0; i--) {
////            if (arr.get(i) == 4) {
////                arr.remove(i); // Remove element 4
////            }
////        }
//		
////		When you iterate from the start of the list (index 0) to arr.size() - 1, removing elements causes the remaining elements to shift left, which can lead to skipping elements.
////		for (int i =0; i < arr.size(); i++) {
////            if (arr.get(i) == 4) {
////                arr.remove(i); // Remove element 4
////                i--;
////            }
////        }	
//		
////		System.out.println("Element at index 0: " + arr.get(0));
////        System.out.println("Element at index 2: " + arr.get(2));
//		
////		Collections.sort(arr);
//		
//		for(Integer a:arr) {
//			System.out.print(a+".");
//		}
//
//	}
//
//}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList1 {
    public static void main(String[] args) {
        // Create an ArrayList of Integers
        ArrayList<Integer> arr = new ArrayList<>();

        // a) Add elements to the ArrayList
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        System.out.println("After adding elements: " + arr);

        // b) Remove a particular element (let's remove element 30)
        arr.remove(Integer.valueOf(30));  // Removes the first occurrence of 30
        System.out.println("After removing element 30: " + arr);

        // c) Modify an element (let's modify index 2 to 100)
        arr.set(2, 100);  // Set value at index 2 to 100
        System.out.println("After modifying index 2 to 100: " + arr);

        // d) View all elements using Iterator
        System.out.print("View all elements using Iterator: ");
        Iterator<Integer> iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();  // For a new line

        // e) View a particular element (using get())
        int index = 1;  // Let's view the element at index 1
        System.out.println("Element at index " + index + " is: " + arr.get(index));

        // f) Sort the ArrayList in ascending order
        Collections.sort(arr);
        System.out.println("After sorting the list: " + arr);
    }
}

