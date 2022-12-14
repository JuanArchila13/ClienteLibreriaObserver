package structure;

import java.util.ArrayList;

public class Response {
	private boolean isNotify;
	private String option;
	private boolean isValid;
	private ArrayList<Book> books;
	private ArrayList<CopyBook> booksRented;
	private Person profile;
	private String bookCount;
	
	public Response() {
		this.isNotify = false;
		this.books = new ArrayList<>();
		this.booksRented = new ArrayList<>();
	}

	public boolean isNotify() {
		return isNotify;
	}

	public void setNotify(boolean isNotify) {
		this.isNotify = isNotify;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<CopyBook> getBooksRented() {
		return booksRented;
	}

	public void setBooksRented(ArrayList<CopyBook> booksRented) {
		this.booksRented = booksRented;
	}

	public Person getProfile() {
		return profile;
	}

	public void setProfile(Person profile) {
		this.profile = profile;
	}

	public String getBookCount() {
		return bookCount;
	}

	public void setBookCount(String bookCount) {
		this.bookCount = bookCount;
	}
}
