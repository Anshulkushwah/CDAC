
public class Book1 {

	String title;
	String author;
	String isbn;
	
	public Book1(String title,String author,String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}	
	public void displayBookDetails() {
	   System.out.println("Title: " + title);
	   System.out.println("Author: " + author);
	   System.out.println("ISBN: " + isbn);
	}
}

