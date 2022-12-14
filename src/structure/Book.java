package structure;

public class Book {
	private String title;
	private int bookID;
	private int quantity;
	private String author;
	private String departureYear;
	private String description;
	private String pathImage;//Le envio el 
	private byte [] bytesImage;
	
	public Book(String title, int bookID, int quantity, String author, String departureYear,String description,String pathImage) {
		super();
		this.title = title;
		this.bookID = bookID;
		this.quantity = quantity;
		this.author = author;
		this.departureYear = departureYear;
		this.description = description;
		this.pathImage = pathImage;
	}
	
	public void setBytesImage(byte[] bytesImage) {
		this.bytesImage = bytesImage;
	}
	
	public byte[] getBytesImage() {
		return bytesImage;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDepartureYear() {
		return departureYear;
	}
	
	public void setDepartureYear(String departureYear) {
		this.departureYear = departureYear;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPathImage() {
		return pathImage;
	}
	
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	public String toString() {
		return "Titulo: " + title + " | Autor: " + author + " | Cantidad: " + quantity;
	}
	
	public int compare(Book book) {
		int result = 0;
		if(!this.title.equals(book.getTitle())) {
			result = -1;
		}else {
			if(!this.author.equals(book.getAuthor())) {
				result = -1;
			}else {
				if(!this.departureYear.equals(book.getDepartureYear())) {
					result = -1;
				}
			}
		}
		return result;
	}
	
}
