package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JFrame;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import structure.Book;
import structure.CopyBook;
import structure.Person;
import structure.ReadConfigs;
import structure.Request;
import structure.Response;
import view.MainWindow;
import view.Utilities;

public class ClientController implements ActionListener,Utilities{
	private Socket socket;
	private Net net;
	private MainWindow window;
	private ReadConfigs readConfigs;
	private boolean isSessionActive;
	private boolean isActive;
	
	public ClientController() throws UnknownHostException, IOException {
		window = new MainWindow(this);
		isSessionActive = false;
		isActive = true;
		this.readConfigs = new ReadConfigs();
		this.socket = new Socket(readConfigs.obtainHOST(),readConfigs.obtainPort());
		this.net = new Net(socket);
		this.net.getOutput().writeInt(0);
		Thread thread = new Thread(){
			public void run() {
				while (isActive) {
					verify();
				}
			}
		};
		thread.start();
		this.init();
	}
	
	private void verify() {
		try {
			if(isActive) {
				if(net.getInput().available() > 0) {
					Response response = new Response();
					response = net.getMyGson().fromJson(net.getInput().readUTF(), response.getClass());
					if(response.isNotify()) {
						if(isSessionActive) {
							initializeUserData(response.getBooks(), response.getBooksRented(), response.getProfile());
						}
					} else {
						if(response.getOption().equals("EXIT")) {
							isActive = false;
							window.dispose();
							socket.close();
						}
						protocol(response);
					}
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		window.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		try {
			switch (event) {
			case "LOGIN_USER":
				this.loginUser(event);
				break;
			case "CREATE_ACCOUNT_USER":
				this.createAccountUser(event);
				break;
			case "REGISTER_USER":
				window.initRegisterPanel();
				break;
			case "SHOW_PROFILE":
				window.putVisibilityProfile();
				break;
			case "SEARCH_BOOKS":
				window.putVisibilitySearchBook();
				break;
			case "MY_BOOKS":
				window.putVisibilityRentedBooks();
				break;
			case "RENT_BOOK":
				this.rentBook(event);
				break;
			case "CANCEL_RENT_BOOK":
				window.closeDialogRentedBook();
				break;
			case "LOGOUT":
				isSessionActive = false;
				window.initLoginPanel();
				break;
			case "BACK_TO_LOGIN":
				window.initLoginPanel();
				break;
			case "ACCEPT_MESSAGE":
				window.closeMessageDialog();
			break;
			case "EXIT":
				Request request = new Request();
				request.setAppOption(event);
				net.getOutput().writeUTF(net.getMyGson().toJson(request));
				break;
			case "MIN":
				window.setExtendedState(JFrame.ICONIFIED);
				break;

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	private void protocol(Response response) throws IOException {
		switch (response.getOption()) {
		case "LOGIN_USER":
			if(response.isValid()) {
				Response newResponse = net.getMyGson().fromJson(net.getInput().readUTF(), Response.class);
				if(!newResponse.isValid()) {
					isSessionActive = true;
					this.initializeUserView(newResponse.getBooks(), newResponse.getBooksRented(), newResponse.getProfile());
				}else {
					window.showMessageDialog(SESSION_IS_ACTIVE);
					window.clearFieldsLogin();
				}
			}else {
				window.showMessageDialog(ADMIN_NO_REGISTER);
				window.clearFieldsLogin();
			}
			break;
		case "CREATE_ACCOUNT_USER":
			if(!response.isValid()) {
				window.showMessageDialog(USER_CREATED);
				window.initLoginPanel();
			}else {
				window.showMessageDialog(USER_IS_CREATED);
				window.clearFieldsRegister();
			}
			break;
		case "LOGOUT":
			isSessionActive = false;
			break;
		case "RENT_BOOK":
			window.showMessageDialog(BOOK_RENTED_SUCCEFULLY);
			window.closeDialogRentedBook();
			break;
		}
	}
	
	private void loginUser(String option) throws IOException {
		Request request = new Request();
		request.setAppOption(option);
		request.setUserID(window.obtainUser());
		request.setPassword(window.obtainPassword());
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
	private void initializeUserView(ArrayList<Book> books, ArrayList<CopyBook> rentedBooks, Person user) throws JsonSyntaxException, IOException {
		window.setBookSet(books);
		window.setBooksRented(rentedBooks);
		window.setProfile(user);
		window.initComponentsUser();
	}
	
	private void initializeUserData(ArrayList<Book> books, ArrayList<CopyBook> rentedBooks, Person user) throws JsonSyntaxException, IOException {
		window.setVisible(false);
		Person profile = window.getProfile();
		window = new MainWindow(this);
		window.setBookSet(books);
		window.setBooksRented(rentedBooks);
		if(!isSessionActive) {
			window.initLoginPanel();
		}else {
			window.setProfile(profile);
			window.initData();
		}
		init();
	}
	
	private void createAccountUser(String option) throws IOException {
		Request request = new Request();
		request.setAppOption(option);
		request.setPerson(window.obtainNewUser());
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
	private void rentBook(String option) throws IOException {
		Request request = new Request();
		request.setBook(window.obtainRentBook());
		request.setPerson(window.getProfile());
		request.setAppOption(option);
		net.getOutput().writeUTF(net.getMyGson().toJson(request));
	}
	
	
	public static void main(String[] args) {
		try {
			new ClientController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
