import java.util.ArrayList;
import java.util.List;

public class Library {
	// Add the missing implementation to this class
	public List<Book> books = new ArrayList<Book>();
	private String address;

	public Library(String libAddress) {
		address = libAddress;
	}

	private void addBook(Book newBook) {
		books.add(newBook);

	}

	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");

	}

	public void printAddress() {
		System.out.println(address);

	}

	public String getAddress() {
		return address;
	}

	public void borrowBook(String title) {
		int q = books.size();
		for (int i = 0; i < q; i++)
			if (books.get(i).getTitle().equals(title))
				if (books.get(i).isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				} else {
					System.out.println("You successfully borrowed " + title + '\n');
					books.get(i).borrowed();
					books.get(i).borrowed = true;
					return;
				}

		System.out.println("Sorry, this book is not in our catalog.");

	}

	public void printAvailableBooks() {
		if (books.size() == 0)
			System.out.println("No book in catalogue");
		for (int i = 0; i < books.size(); i++) {
			if (!books.get(i).isBorrowed()) {
				System.out.print(books.get(i).getTitle() + '\n');
			}
		}
	}

	public void returnBook(String title) {
		int q = books.size();
		for (int i = 0; i < q; i++) {
			if (books.get(i).getTitle().equals(title))
				if (books.get(i).isBorrowed()) {
					System.out.println("You successfully returned " + title);
					books.get(i).returned();
					return;
				} else {
					System.out.println("This book was not borrowed.");
					return;
				}

		}
	}

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

}