package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import structure.Book;

import javax.swing.JTextField;

public class SearchBookPanel extends JPanel {

	private JPanel queryPanel;
	private BooksPanel booksPanel;
	private JPanel contentQueryPanel, contentBookPanel;
	private JTextField title,author,year;
	private ArrayList<Book> bookSet;
	private ActionListener listener;
	private MouseListener mouseListener;
	public SearchBookPanel(ActionListener listener,MouseListener mouseListener,ArrayList<Book> bookSet) {
		this.listener = listener;
		this.mouseListener = mouseListener;
		this.bookSet = bookSet;
		setSize(914,635);
		setLocation(0,0);
		setBackground(MainWindow.WHITECOLOR);
		setLayout(null);
		initComponents();
	}
	
	private void initComponents() {
		contentQueryPanel = new JPanel();
		contentQueryPanel.setLayout(null);
		contentQueryPanel.setBounds(31, 11, 857, 173);
		add(contentQueryPanel);
		
		contentBookPanel = new JPanel();
		contentBookPanel.setLayout(null);
		contentBookPanel.setBounds(31, 210, 855, 401);
		add(contentBookPanel);
		
		initQueryPanel();
		initBooksPanel(bookSet);
	}
	
	private void initQueryPanel() {
		queryPanel = new JPanel();
		queryPanel.setBounds(0, 0, 857, 173);
		queryPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("Sistema de B\u00FAsqueda de Libros");
		lblTitle.setBounds(148, 11, 487, 40);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		queryPanel.add(lblTitle);
		
		JLabel lblBookTitle = new JLabel("Titulo del libro");
		lblBookTitle.setBounds(158, 62, 118, 25);
		lblBookTitle.setForeground(MainWindow.STRONGBLACK);
		lblBookTitle.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBookTitle.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblBookTitle);
		
		
		JLabel lblAuthor = new JLabel("Autor");
		lblAuthor.setBounds(158, 103, 107, 25);
		lblAuthor.setForeground(MainWindow.STRONGBLACK);
		lblAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAuthor.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblAuthor);
		
		JLabel lblYear = new JLabel("A\u00F1o");
		lblYear.setBounds(158, 139, 107, 25);
		lblYear.setForeground(MainWindow.STRONGBLACK);
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblYear.setHorizontalTextPosition(SwingConstants.RIGHT);
		queryPanel.add(lblYear);

		title = new JTextField();
		title.setColumns(10);
		title.setBounds(275, 62, 227, 25);
		title.setForeground(MainWindow.STRONGGRAY);
		title.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		title.setBackground(MainWindow.WHITECOLOR);
		title.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
		queryPanel.add(title);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(275, 98, 227, 25);
		author.setForeground(MainWindow.STRONGGRAY);
		author.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		author.setBackground(MainWindow.WHITECOLOR);
		author.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
		queryPanel.add(author);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(275, 134, 227, 25);
		year.setForeground(MainWindow.STRONGGRAY);
		year.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		year.setBackground(MainWindow.WHITECOLOR);
		year.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
		queryPanel.add(year);
		
		showPanel(contentQueryPanel, queryPanel);
	}
	private void initBooksPanel(ArrayList<Book> bookSet) {
		
		booksPanel = new BooksPanel(listener,mouseListener,bookSet);
		booksPanel.setBounds(0,0, 855, 401);
		
		JScrollPane scrollPane = new JScrollPane(booksPanel);
		scrollPane.setBounds(0,0, 855, 401);
		showPanel(contentBookPanel, scrollPane);
		
	}
	public void showPanel(JPanel contentPanel,JScrollPane scroll) {
		contentPanel.removeAll();
		contentPanel.add(scroll);
		contentPanel.revalidate();
		contentPanel.repaint();
	}
	public void showPanel(JPanel contentPanel,JPanel panel) {
		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.revalidate();
		contentPanel.repaint();
	}
	//Metodo para el filtro con eventos de teclado busqueda de libros por titulo
	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		update(title.getText(),author.getText(),year.getText());
    }
	private void update(String searchText,String searchAuthor, String searchYear) {
		ArrayList<Book> auxBookSet = this.searchBooks(bookSet,searchText,searchAuthor,searchYear );
		initBooksPanel(auxBookSet);
	}
	public ArrayList<Book> searchBooks(ArrayList<Book> bookSet, String searchTitle,String searchAuthor, String searchYear){
		ArrayList<Book> booksFound = new ArrayList<>();
		char[] textChars = searchTitle.toCharArray();
		char[] authorChars = searchAuthor.toCharArray();
		char[] yearChars = searchYear.toCharArray();
		
			if(textChars.length != 0) {
				for (int i = 0; i < bookSet.size(); i++) {
					if (isSimilarWithTitle(bookSet.get(i), searchTitle)) {
						booksFound.add(bookSet.get(i));
					}
				}	
			}else if(authorChars.length != 0 || yearChars.length != 0){
				booksFound = bookSet;
			}
			if(authorChars.length != 0) {
				ArrayList<Book> aux  = new ArrayList<>();
				for (int i = 0; i < booksFound.size(); i++) {
					if (isSimilarWithAuthor(booksFound.get(i), searchAuthor)) {
						aux.add(booksFound.get(i));
					}
				}	
				booksFound = aux;
			}
			if(yearChars.length != 0) {
				ArrayList<Book> aux  = new ArrayList<>();
				for (int i = 0; i < booksFound.size(); i++) {
					if (isSimilarWithYear(booksFound.get(i), searchYear)) {
						aux.add(booksFound.get(i));
					}
				}	
				booksFound = aux;
			}
			if(textChars.length == 0 && authorChars.length == 0 && yearChars.length == 0)
				return bookSet;
		return booksFound;
	}
	private boolean isSimilarWithTitle(Book actBook, String searchText) {
		char[] textChars = searchText.toCharArray();
		String bookTitle = actBook.getTitle();
		boolean areEquals = true;
		for (int j = 0; j < textChars.length && areEquals; j++) {
			if(bookTitle.length() >= textChars.length) {
				String actChar = String.valueOf(bookTitle.charAt(j));
				if(actChar.compareToIgnoreCase(String.valueOf(textChars[j])) != 0) {
					areEquals = false; 
				}
			}else {
				areEquals = false;
			}
		}
		return areEquals;
	}
	private boolean isSimilarWithAuthor(Book actBook, String searchAuthor) {
		char[] textChars = searchAuthor.toCharArray();
		String bookTitle = actBook.getAuthor();
		boolean areEquals = true;
		for (int j = 0; j < textChars.length && areEquals; j++) {
			if(bookTitle.length() >= textChars.length) {
				String actChar = String.valueOf(bookTitle.charAt(j));
				if(actChar.compareToIgnoreCase(String.valueOf(textChars[j])) != 0) {
					areEquals = false; 
				}
			}else {
				areEquals = false;
			}
		}
		return areEquals;
	}
	private boolean isSimilarWithYear(Book actBook, String searchYear) {
		char[] textChars = searchYear.toCharArray();
		String bookTitle = actBook.getDepartureYear();
		boolean areEquals = true;
		for (int j = 0; j < textChars.length && areEquals; j++) {
			if(bookTitle.length() >= textChars.length) {
				String actChar = String.valueOf(bookTitle.charAt(j));
				if(actChar.compareToIgnoreCase(String.valueOf(textChars[j])) != 0) {
					areEquals = false; 
				}
			}else {
				areEquals = false;
			}
		}
		return areEquals;
	}
}