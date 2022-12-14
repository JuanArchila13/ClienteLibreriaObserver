package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structure.Book;
import structure.CopyBook;
import structure.Person;

import java.awt.Insets;

//CLIENT
public class MainWindow extends JFrame implements Utilities, MouseListener {
	private ArrayList<Book> bookSet;
	private ArrayList<CopyBook> booksRented;
	private Person profile;

	private JPanel contentPane;// Panel principal de la ventana
	private JPanel contentData, header, menuPanel, dataPanel;// Paneles para dividir el contenido en la ventana
	private JButton btnExit, btnMin;

	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private MenuPanel menu;
	private ProfilePanel profilePanel;
	private SearchBookPanel searchBookPanel;
	private RentedBooks rentedBooks;
	private BookDialog bookDialog;
	private WindowDialog windowDialog;
	private ActionListener listener;
	private int xMouse, yMouse;// atributos para controlar el desplazamiento de la ventana

	public MainWindow(ActionListener listener) {
		this.listener = listener;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(10, 10, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		initComponents();
		initLoginPanel();
	}

	// SETTERS PARA INFORMACIÓN
	public void setBookSet(ArrayList<Book> bookSet) {
		this.bookSet = bookSet;
	}

	public void setBooksRented(ArrayList<CopyBook> booksRented) {
		this.booksRented = booksRented;
	}

	public void setProfile(Person profile) {
		this.profile = profile;
	}

	public Person getProfile() {
		return this.profile;
	}

	// Metodo para inciar componentes generales de la GUI(Cabecera y un panel para
	// el contenido en contentPane)
	private void initComponents() {
		header = new JPanel();
		header.setBounds(0, 0, 1200, 45);
		header.setLayout(null);
		header.setBackground(WHITECOLOR);
		header.addMouseMotionListener(this.panelMouseDragged());
		header.addMouseListener(this.panelMousePressed());

		btnExit = new JButton();
		btnExit.setText("X");
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnExit.setForeground(WHITECOLOR);
		btnExit.setBackground(MAINCOLOR);
		btnExit.setBounds(1157, 0, 43, 43);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(1, 1, 1, 1));
		;
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(listener);
		btnExit.setActionCommand("EXIT");
		btnExit.setFocusable(false);
		btnExit.addMouseListener(this.mouseEntered());
		btnExit.addMouseListener(this.mouseExited());
		header.add(btnExit);
		getContentPane().add(header);

		btnMin = new JButton();
		btnMin.setText("-");
		btnMin.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		btnMin.setForeground(WHITECOLOR);
		btnMin.setBackground(MAINCOLOR);
		btnMin.setBounds(1113, 0, 43, 43);
		btnMin.setBorderPainted(false);
		btnMin.setMargin(new Insets(1, 1, 1, 1));
		;
		btnMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMin.setFocusable(false);
		btnMin.addActionListener(listener);
		btnMin.setActionCommand("MIN");
		btnMin.addMouseListener(this.mouseEntered());
		btnMin.addMouseListener(this.mouseExited());
		header.add(btnMin);
		getContentPane().add(header);

		contentData = new JPanel();
		contentData.setBounds(0, 43, 1200, 637);
		contentData.setLayout(null);
		contentPane.add(contentData);
	}

	// Metodo para iniciar componente del Login
	public void initLoginPanel() {
		loginPanel = new LoginPanel(listener);
		loginPanel.setSize(1200, 635);
		loginPanel.setLocation(0, 0);
		showPanel(contentData, loginPanel);
	}

	/**
	 * Metodo para iniciar panel de registro de nuevo usuario
	 */
	public void initRegisterPanel() {
		registerPanel = new RegisterPanel(listener);
		showPanel(contentData, registerPanel);
	}

	/**
	 * Metodo que inicia la interfaz de usuario (Menu y un panel lateral para el
	 * contenido) Este metodo se debe llamar siempre que el login sea exitoso.
	 */
	public void initComponentsUser() {
		dataPanel = new JPanel();// Panel que se actualiza de acuerdo a la opcion del menu selecionada
		dataPanel.setBounds(286, 1, 914, 635);
		dataPanel.setLayout(null);
		showPanel(contentData, dataPanel);
		contentData.add(dataPanel);

		menuPanel = new JPanel();
		menuPanel.setSize(285, 636);
		menuPanel.setLayout(null);
		contentData.add(menuPanel);

		menu = new MenuPanel(listener);
		menu.setSize(285, 636);
		menu.setLocation(0, 0);
		showPanel(menuPanel, menu);

		initAllUserPanels();
	}

	private void initAllUserPanels() {
		searchBookPanel = new SearchBookPanel(listener, this.mouseClickedItem(), this.bookSet);
		searchBookPanel.setVisible(true);
		searchBookPanel.setLocation(0, 0);
		dataPanel.add(searchBookPanel);

		rentedBooks = new RentedBooks(this.booksRented);
		rentedBooks.setLocation(0, 0);
		rentedBooks.setVisible(false);
		dataPanel.add(rentedBooks);

		profilePanel = new ProfilePanel(profile);
		profilePanel.setLocation(0, 0);
		profilePanel.setVisible(false);
		dataPanel.add(profilePanel);
	}

	// Actualización de ventana al recibir noticifacion
	public void initData() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/*
		contentData = new JPanel();
		contentData.setBounds(0, 43, 1200, 637);
		contentData.setLayout(null);
		contentPane.add(contentData);
		*/
	
		initComponents();
		initComponentsUser();
		initAllUserPanels();
	}

	public void putVisibilitySearchBook() {
		rentedBooks.setVisible(false);
		profilePanel.setVisible(false);
		searchBookPanel.setVisible(true);
	}

	public void putVisibilityProfile() {
		searchBookPanel.setVisible(false);
		rentedBooks.setVisible(false);
		profilePanel.setVisible(true);
	}

	public void putVisibilityRentedBooks() {
		searchBookPanel.setVisible(false);
		profilePanel.setVisible(false);
		rentedBooks.setVisible(true);
	}

	/*
	 * Metodo encargado de repintar un panel, recibe como parametro el panel en
	 * donde se quiere pintar un segundo panel.
	 */
	private void showPanel(JPanel contentPanel, JPanel panel) {
		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	private void showDialogRentedBook(Item item) {
		bookDialog = new BookDialog(true, this, listener, item.obtainBook());
		bookDialog.setVisible(true);
		bookDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void showMessageDialog(String message) {
		windowDialog = new WindowDialog(true, this, listener, message);
		windowDialog.setVisible(true);
		windowDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void clearFieldsLogin() {
		loginPanel.clearFields();
	}

	public void clearFieldsRegister() {
		registerPanel.clearFields();
	}

	public void closeMessageDialog() {
		windowDialog.dispose();
	}

	public void closeDialogRentedBook() {
		bookDialog.dispose();
	}

	// Metodos para obtener datos del usuario

	public String obtainUser() {
		return loginPanel.obtainUser();
	}

	public String obtainPassword() {
		return loginPanel.obtainPassword();
	}

	public Person obtainNewUser() {
		return registerPanel.obtainNewUser();
	}

	public Book obtainRentBook() {
		return bookDialog.obtainRentedBook();
	}

	// Metodos para el desplazamiento de la ventana
	@SuppressWarnings("unchecked")
	private void btnMoveMousePressed(MouseEvent event) {
		xMouse = event.getX();
		yMouse = event.getY();
	}

	private void btnMoveMouseDragged(MouseEvent event) {
		int x = event.getXOnScreen();
		int y = event.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	/*
	 * Metodo que retorna un objeto MouseAdapter necesario para agregar al panel
	 * eventos de tipo MousePressed Invoca a un metodo propio de la clase WindowMain
	 */
	private MouseAdapter panelMousePressed() {
		return new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				btnMoveMousePressed(event);
			}
		};
	}

	/*
	 * Metodo que retorna un objeto MouseMotionListener necesario para agregar al
	 * panel eventos de tipo MousePressed
	 */
	public MouseMotionListener panelMouseDragged() {
		return new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				btnMoveMouseDragged(evt);
			}
		};
	}

	// Metodos para manejar el efecto Hover de los botones
	private MouseAdapter mouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMouseEntered(e);
			}
		};
	}

	private MouseAdapter mouseExited() {
		return new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnMouseExited(e);
			}
		};
	}

	private void btnMouseEntered(MouseEvent event) {
		if (event.getSource() == btnExit)
			btnExit.setBackground(HOVERCOLOR);
		else if (event.getSource() == btnMin)
			btnMin.setBackground(HOVERCOLOR);
	}

	private void btnMouseExited(MouseEvent event) {
		if (event.getSource() == btnExit)
			btnExit.setBackground(MAINCOLOR);
		else if (event.getSource() == btnMin)
			btnMin.setBackground(MAINCOLOR);
	}

	// Revisar porque el mouse adapter no esta enviando en si la accion del mouse
	// listener
	private MouseAdapter mouseClickedItem() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDialogRentedBook((Item) e.getSource());
			}
		};
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().getClass().equals(Item.class)) {
			Item item = (Item) e.getSource();
			System.out.println("Clic en item");
			bookDialog = new BookDialog(true, this, listener, item.obtainBook());
			bookDialog.setVisible(true);
			bookDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
