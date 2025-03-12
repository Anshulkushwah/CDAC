//import java.util.List;
//import java.util.ArrayList;

public class Library {
	
	String name;
	String address;
	Book1[] books;
	int bookCount ;
	
	 public Library(String name, String address, int capacity) {
	        this.name = name;
	        this.address = address;
	        this.books = new Book1[capacity];
	        this.bookCount = 0;
	    }
	
	 public void addBook(Book1 book) {
	        if (bookCount < books.length) {
	            books[bookCount] = book;  
	            bookCount++; 
	            System.out.println("Book added: " + book.title);
	        } else {
	            System.out.println("Library is full, cannot add more books.");
	        }
	    }
	 
	 // Method to display all books in the library
	 public void displayBooks() {
	        System.out.println("Books in " + name + " Library:");
	        if (bookCount == 0) {
	            System.out.println("No books available.");
	        } else {
	            for (int i = 0; i < bookCount; i++) {
	                books[i].displayBookDetails();
	                System.out.println("------------------------");
	            }
	        }
	 }
	 
	 public void searchBook(String title) {
		 boolean found = false;
		 
		 for(int i = 0; i<bookCount; i++) {
			if(books[i].title == title) {
				System.out.println("Book found:");
                books[i].displayBookDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title \"" + title + "\" not found.");
        }
	 }
	
	    
	
	public static void main(String[] args) {
		Library library = new Library("City Library", "123 Main St", 3);

        // Create some Book objects
        Book1 book1 = new Book1("The Catcher in the Rye", "J.D. Salinger", "978-0316769488");
        Book1 book2 = new Book1("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book1 book3 = new Book1("1984", "George Orwell", "978-0451524935");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Try adding another book (should fail as the library is full)
        Book1 book4 = new Book1("Moby Dick", "Herman Melville", "978-1503280786");
        library.addBook(book4);

        // Display all books in the library
        library.displayBooks();

        // Search for a book by title
        library.searchBook("1984");

        // Search for a non-existent book
        library.searchBook("The Catcher in the Rye");

	}
	
}

