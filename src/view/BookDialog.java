package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import structure.Book;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BookDialog extends JDialog {
	private JPanel bookPanel;
	private JButton btnRentBook,btnCancel;
	private Book book;
	public BookDialog(boolean mode,JFrame frame,ActionListener actionListener, Book book) {
		super(frame,mode);
		this.book = book;
		setSize(534,375);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		initComponents(actionListener,book);
		putButtonActivated(book.getQuantity());
		getContentPane().add(bookPanel);
		bookPanel.setLayout(null);
		
	}
	public void initComponents(ActionListener actionListener,Book book) {
		
		getContentPane().setLayout(null);
		this.bookPanel = new JPanel();
		bookPanel.setBounds(0,0,518,336);
		JLabel lblTitle = new JLabel();
		lblTitle.setText(book.getTitle());
		lblTitle.setBounds(188, 11, 320, 31);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookPanel.add(lblTitle);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(18, 11, 160, 234);
		//Image image = new ImageIcon(book.getBytesImage()).getImage();
		
		//ImageIcon icon = new ImageIcon(image.getScaledInstance(202, 270, Image.SCALE_SMOOTH));
		//lblImage.setIcon(icon);

		bookPanel.add(lblImage);
		
		JLabel lblAuthor = new JLabel(book.getAuthor());
		lblAuthor.setBounds(188, 53, 320, 20);
		lblAuthor.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblAuthor.setForeground(MainWindow.MAINCOLOR);
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYear = new JLabel(book.getDepartureYear());
		lblYear.setBounds(188, 74, 320, 20);
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblYear.setForeground(MainWindow.MAINCOLOR);
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(book.getDescription());
		textArea.setBounds(197, 125, 311, 110);
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textArea.setEnabled(false);
		textArea.setForeground(MainWindow.STRONGBLACK);
		textArea.setBackground(MainWindow.WHITECOLOR);
		bookPanel.add(textArea);
		
		
	    JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(197, 125, 311, 110);
        bookPanel.add(scroll);
        
		
		btnRentBook = new JButton("Rentar");
		btnRentBook.setBounds(196, 246, 125, 39);
		btnRentBook.setAlignmentX(CENTER_ALIGNMENT);
		btnRentBook.setForeground(MainWindow.WHITECOLOR);
		btnRentBook.setBackground(MainWindow.MAINCOLOR);
		btnRentBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRentBook.setFocusable(false);
		btnRentBook.addActionListener(actionListener);
		btnRentBook.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.HOVERCOLOR);
					btn.setForeground(MainWindow.STRONGBLACK);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MainWindow.MAINCOLOR);
				if(e.getSource().equals(btnRentBook)){
					JButton btn = (JButton)e.getSource();
					btn.setBackground(MainWindow.MAINCOLOR);
					btn.setForeground(MainWindow.WHITECOLOR);
				}
			}
		});
		btnRentBook.setActionCommand("RENT_BOOK");
		btnRentBook.setAlignmentX(BOTTOM_ALIGNMENT);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(383, 246, 125, 39);
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		btnCancel.setForeground(MainWindow.WHITECOLOR);
		btnCancel.setBackground(MainWindow.MAINCOLOR);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(actionListener);
		btnCancel.setActionCommand("CANCEL_RENT_BOOK");
		btnCancel.addMouseListener(this.mouseClicked());
		btnCancel.addMouseListener(this.mouseEntered());
		
		bookPanel.add(lblAuthor);
		bookPanel.add(lblYear);
		verifyQuantity();
		bookPanel.add(btnRentBook);
		bookPanel.add(btnCancel);
		
		getContentPane().add(bookPanel);
	}
	private MouseAdapter mouseClicked() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
			
		};
	}
	public MouseAdapter mouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMouseEntered(e);
			}
		};
	}
	public MouseAdapter mouseExited() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMouseExited(e);
			}
		};
	}
	
	private void putButtonActivated(int quantity) {
		if(quantity != 0) {
			btnRentBook.setEnabled(true);
		}else {
			btnRentBook.setEnabled(false);
		}
		
	}
	
	private void btnMouseEntered(MouseEvent event) {
		if (event.getSource() == btnRentBook)
			btnRentBook.setBackground(MainWindow.HOVERCOLOR);
		else if (event.getSource() == btnCancel)
			btnCancel.setBackground(MainWindow.HOVERCOLOR);
	}

	private void btnMouseExited(MouseEvent event) {
		if (event.getSource() == btnRentBook)
			btnRentBook.setBackground(MainWindow.MAINCOLOR);
		else if (event.getSource() == btnCancel)
			btnCancel.setBackground(MainWindow.MAINCOLOR);
	}

	private void verifyQuantity() {
		if(book.getQuantity() == 0) {
			btnRentBook.setEnabled(false);
		}
	}
	
	public Book obtainRentedBook() {
		this.book.setBytesImage(null);
		return this.book;
	}
	
}
