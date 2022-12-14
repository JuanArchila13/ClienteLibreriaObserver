package structure;

public class CopyBook {
	private Book rentedBook;
	private String userID;

	public CopyBook(Book rentedBook, String userID) {
		this.rentedBook = rentedBook;
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}
	
	public Book getRentedBook() {
		return this.rentedBook;
	}
}
