package structure;

public class Request {
	private String appOption;
	private String userID;
	private String password;
	private Person person;
	private Book book;
	private int bookID;
	
	public String getAppOption() {
		return appOption;
	}
	
	public void setAppOption(String appOption) {
		this.appOption = appOption;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	
}
