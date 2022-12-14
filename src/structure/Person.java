package structure;

public class Person {
	private String name;
	private String lastName;
	private String ID;
	private String email;
	private String password;
	private boolean isSessionStarted;

	public Person(String name, String lastName,String ID, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.ID = ID;
		this.email = email;
		this.password = password;
		this.isSessionStarted = false;
	}
	
	public Person(String ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getID() {
		return ID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	
	public boolean isSessionStarted() {
		return isSessionStarted;
	}
	
	public void setSessionStarted(boolean sessionStarted) {
		this.isSessionStarted = sessionStarted;
	}
	
	public int compare(Person person) {
		return getID().compareToIgnoreCase(person.getID());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", ID=" + ID + ", email=" + email + ", password="
				+ password + ", isSessionStarted=" + isSessionStarted + "]";
	}
}
