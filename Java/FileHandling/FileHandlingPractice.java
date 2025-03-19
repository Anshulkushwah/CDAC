import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//public class FileHandlingPractice  {
//
//	public static void main(String[] args) {
//		
//		File file = new File("Temp.txt");
//		
//		  	try {
//		  		if (file.createNewFile()) {
//	                System.out.println("File created: " + file.getName());
//	            } else {
//	                System.out.println("File already exists : "+file.exists());
//	                
//	                System.out.println(file.getAbsolutePath());
//	            }
//		  	}catch(IOException e) {
//		  		System.out.println("An error occurred: " + e.getMessage());
//		  	}
//
//	}
//
//}


//public class FileHandlingPractice  {
//
//	public static void main(String[] args) {
//		
//		try {
//			
//			FileWriter fw = new FileWriter("test.txt",true);
//			InputStreamReader isr = new InputStreamReader(System.in);
//			BufferedReader br = new BufferedReader(isr);
//			
//			String str;
//			
//			while(!(str = br.readLine()).equals("end")) {
//				fw.write(str + "\n");
//
//			}
//			System.out.println("Data written to file successfully.");
//			fw.close(); 
//		}catch(IOException e) {
//			System.out.println("An error occurred: " + e.getMessage());
//		}
//
//	}
//
//}



public class FileHandlingPractice  {

	public static void main(String[] args) throws IOException {
		
		
			FileReader fr = new FileReader("test.txt");
			
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			
			while( (str=br.readLine())!= null) {
				System.out.println(str);
			}
			
			

	}

}