package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.MouseAdapter;

public class MenuPanel extends JPanel {
	private JButton btnProfile,btnSearchBooks,btnMyBooks,btnSingOut;
	public MenuPanel(ActionListener actionListener) {
		setSize(285, 636);
		setLayout(null);
		setBackground(MainWindow.MAINCOLOR);
		initComponents(actionListener);
	}
	//Metodo que inicializa todos los botones del menu
	private void initComponents(ActionListener listener) {
		btnProfile = new JButton();
		propertiesBtn(btnProfile);
		btnProfile.setText("Mi perfil");
		btnProfile.setIcon(new ImageIcon("data\\icons\\iconUserCircle.png"));
		btnProfile.setBounds(0, 136, 285, 53);
		btnProfile.addActionListener(listener);
		btnProfile.setActionCommand("SHOW_PROFILE");
        //Evento hover para el boton, necesita como parametro un objeto de MouseAdapter
        btnProfile.addMouseListener(this.mouseEntered());
        btnProfile.addMouseListener(this.mouseExited());
		add(btnProfile);
		
		btnSearchBooks = new JButton();
        propertiesBtn(btnSearchBooks);
        btnSearchBooks.setText("Buscar libros");
        btnSearchBooks.setIcon(new ImageIcon("data\\icons\\iconSearch.png"));
        btnSearchBooks.setBounds(0, 192, 285, 53);
        btnSearchBooks.addActionListener(listener);
        btnSearchBooks.setActionCommand("SEARCH_BOOKS");
        btnSearchBooks.addMouseListener(this.mouseEntered());
        btnSearchBooks.addMouseListener(this.mouseExited());
        add(btnSearchBooks);

        btnMyBooks = new JButton();
        propertiesBtn(btnMyBooks);
        btnMyBooks.setText("Mis libros rentados");
        btnMyBooks.setIcon(new ImageIcon("data\\icons\\iconBook.png"));
        btnMyBooks.setBounds(0, 247, 285, 53);
        btnMyBooks.addActionListener(listener);
        btnMyBooks.setActionCommand("MY_BOOKS");
        btnMyBooks.addMouseListener(this.mouseEntered());
        btnMyBooks.addMouseListener(this.mouseExited());
        add(btnMyBooks);
		
        btnSingOut = new JButton();
		propertiesBtn(btnSingOut);
		btnSingOut.setText("Cerrar sesi\u00F3n");
		btnSingOut.setIcon(new ImageIcon("data\\icons\\iconSingOut.png"));
		btnSingOut.setBounds(0, 302, 285, 53);
		btnSingOut.addActionListener(listener);
		btnSingOut.setActionCommand("LOGOUT");
        btnSingOut.addMouseListener(this.mouseEntered());
        btnSingOut.addMouseListener(this.mouseExited());
		add(btnSingOut);
	}
	private void propertiesBtn(JButton buttonToApply) {
		buttonToApply.setIconTextGap(6);
        buttonToApply.setMargin(new Insets(2, 30, 2, 4));
        buttonToApply.setHorizontalTextPosition(SwingConstants.RIGHT);
        buttonToApply.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
        buttonToApply.setForeground(Color.white);
        buttonToApply.setFont(new Font("Segoe UI", Font.BOLD, 20));
        buttonToApply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonToApply.setFocusable(false);
        buttonToApply.setBackground(MainWindow.MAINCOLOR);
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
		JButton btn = null;
		if(event.getSource() == btnProfile)
			btn = btnProfile;
		else if(event.getSource() == btnMyBooks)
			btn = btnMyBooks;
		else if(event.getSource() == btnSearchBooks)
			btn = btnSearchBooks;
		else if(event.getSource() == btnSingOut)
			btn = btnSingOut;
		btn.setBackground(MainWindow.HOVERCOLOR);
	}

	private void btnMouseExited(MouseEvent event) {
		JButton btn = null;
		if(event.getSource() == btnProfile)
			btn = btnProfile;
		else if(event.getSource() == btnMyBooks)
			btn = btnMyBooks;
		else if(event.getSource() == btnSearchBooks)
			btn = btnSearchBooks;
		else if(event.getSource() == btnSingOut)
			btn = btnSingOut;
		btn.setBackground(MainWindow.MAINCOLOR);
	}
	
}
