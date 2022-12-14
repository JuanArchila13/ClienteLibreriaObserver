package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import structure.CopyBook;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

public class RentedBooks extends JPanel {
	private ArrayList<CopyBook> bookSet;
	private JTable table;
	private JTextField txtTitle;
	
	public RentedBooks(ArrayList<CopyBook> bookSet) {
		setSize(914,635);
		setBackground(MainWindow.WHITECOLOR);
		setLayout(null);
		this.bookSet = bookSet;
		initComponents();
	}
	
	private void initComponents() {
		JLabel title_1 = new JLabel("Libros Alquilados");
		title_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		title_1.setForeground(MainWindow.MAINCOLOR);
		title_1.setBounds(315, 67, 257, 39);
		add(title_1);
		
		
		table = new JTable(showBooks(bookSet)) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setBounds(85, 249, 717, 334);
		table.setGridColor(MainWindow.MAINCOLOR);
		table.setBackground(MainWindow.BEIGE);
		table.setForeground(MainWindow.STRONGBLACK);
		this.styleTable();
		add(table);
		
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setFocusable(false);
		tableScroll.setBorder(new MatteBorder(2, 2, 2, 2, MainWindow.MAINCOLOR));
		tableScroll.setBounds(52, 213, 815, 334);
		tableScroll.setVisible(true);
		add(tableScroll);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		txtTitle.setText("Ingrese el titulo del libro");
		txtTitle.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		txtTitle.setBackground(MainWindow.BEIGE);
		txtTitle.setForeground(MainWindow.STRONGBLACK);
		txtTitle.setBounds(231, 149, 532, 34);
		txtTitle.setColumns(10);
		txtTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtTitle.setText("");
			}
		});
		txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
		add(txtTitle);
		
		JLabel title_1_1 = new JLabel("Buscar:");
		title_1_1.setForeground(new Color(46, 55, 100));
		title_1_1.setFont(new Font("SansSerif", Font.BOLD, 23));
		title_1_1.setBounds(129, 145, 92, 39);
		add(title_1_1);
		txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
	}
	public void styleTable() {
		table.setFont(new Font("SansSerif", Font.PLAIN, 20));
		table.setForeground(MainWindow.STRONGBLACK);
		table.setIntercellSpacing(new Dimension(10, 5));
		table.setGridColor(MainWindow.WHITECOLOR);
		table.setBackground(MainWindow.BEIGE);
		table.setSelectionBackground(MainWindow.LIGHTGRAY);
		table.setSelectionForeground(MainWindow.STRONGBLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(25);
		
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 23));
		table.getTableHeader().setBackground(MainWindow.MAINCOLOR);
		table.getTableHeader().setPreferredSize(new Dimension(20,20));
		table.getTableHeader().setForeground(MainWindow.LIGHTGRAY);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(140);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
	}
	private DefaultTableModel showBooks(ArrayList<CopyBook> bookSet) {
		String[] columns = {"Titulo", "ID", "Autor", "Año"};
		String[] registers = new String[4];
		DefaultTableModel model = new DefaultTableModel(null, columns);
		for (int i = 0; i < bookSet.size(); i++) {
			registers[0] = bookSet.get(i).getRentedBook().getTitle();
			registers[1] = String.valueOf(bookSet.get(i).getRentedBook().getBookID());
			registers[2] = bookSet.get(i).getRentedBook().getAuthor();
			registers[3] = bookSet.get(i).getRentedBook().getDepartureYear();
			model.addRow(registers);
		}
		return model;
	}
	
	public ArrayList<CopyBook> searchBooks(ArrayList<CopyBook> bookSet, String searchText){
		ArrayList<CopyBook> booksFound = new ArrayList<>();
		char[] textChars = searchText.toCharArray();
		if(textChars.length != 0) {
			for (int i = 0; i < bookSet.size(); i++) {
				String bookTitle = bookSet.get(i).getRentedBook().getTitle();
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
				if (areEquals) {
					booksFound.add(bookSet.get(i));
				}
			}			
		}else {
			return bookSet;
		}
		return booksFound;
	}
	
	private void updateTable(String searchText) {
		DefaultTableModel model = showBooks(searchBooks(bookSet, searchText));
		table.setModel(model);
	}
	
	private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
		updateTable(txtTitle.getText());
    }
}
