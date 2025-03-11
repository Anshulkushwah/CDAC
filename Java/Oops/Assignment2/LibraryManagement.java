// Base class
class Book {
    // Common attributes for all books
    String title;
    String author;
    String isbn;

    // Constructor to initialize the common attributes
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display book details (common for all types)
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

}

// Subclass for EBook
class EBook extends Book {
    // Specific attributes for EBook
    double fileSize; // in MB
    String downloadLink;

    // Constructor to initialize EBook-specific attributes
    public EBook(String title, String author, String isbn, double fileSize, String downloadLink) {
        super(title, author, isbn); // Calling the parent class constructor
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    // Overriding the displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails(); // Calling the parent class method
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Download Link: " + downloadLink);
    }

    public String checkAvailability() {
        return "EBook is available for download.";
    }
}

// Subclass for PrintedBook
class PrintedBook extends Book {
    // Specific attributes for PrintedBook
    int pageCount;
    String shelfLocation;

    // Constructor to initialize PrintedBook-specific attributes
    public PrintedBook(String title, String author, String isbn, int pageCount, String shelfLocation) {
        super(title, author, isbn); // Calling the parent class constructor
        this.pageCount = pageCount;
        this.shelfLocation = shelfLocation;
    }

    // Overriding the displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails(); // Calling the parent class method
        System.out.println("Page Count: " + pageCount);
        System.out.println("Shelf Location: " + shelfLocation);
    }

    public String checkAvailability() {
        return "Printed Book is available at " + shelfLocation + ".";
    }
}

// Main class to test the implementation
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an EBook object
        EBook ebook = new EBook("Java Programming", "John Doe", "1234567890", 5.0, "http://example.com/ebook");
        
        // Creating a PrintedBook object
        PrintedBook printedBook = new PrintedBook("Learn Java", "Jane Smith", "0987654321", 350, "Shelf A3");

        // Displaying details of both books
        System.out.println("EBook Details:");
        ebook.displayDetails();
        System.out.println(ebook.checkAvailability());
        System.out.println();

        System.out.println("Printed Book Details:");
        printedBook.displayDetails();
        System.out.println(printedBook.checkAvailability());
    }
}
