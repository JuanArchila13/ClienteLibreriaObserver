package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class LoginPanel extends JPanel {
	private JTextField user;
	private JPasswordField password;
	private JButton btnLogin,btnRegister;

	public LoginPanel(ActionListener actionListener) {
		setSize(1200, 635);
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		setLayout(null);
		JPanel  panelImage = new JPanel();
		panelImage.setLayout(null);
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(MainWindow.MAINCOLOR);
		JLabel lblImage = new JLabel();
		lblImage.setBounds(0,0, 452, 635);
		Image image =new ImageIcon("data\\icons\\Imagen3.png").getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(icon);
		panelImage.add(lblImage);
		add(panelImage);
		
		JPanel  panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(MainWindow.WHITECOLOR);
		
		//Componentes del panelLogin
		JLabel lblTitle = new JLabel("Login Administrador");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.MAINCOLOR);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(238,75,334,50);
		panelLogin.add(lblTitle);
		
		user = new JTextField();
		user.setText("Usuario");
		user.setBounds(173,233,365,37);
		user.setForeground(MainWindow.STRONGBLACK);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(MainWindow.WHITECOLOR);
		user.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		user.addMouseListener(this.mousePressed());
		panelLogin.add(user);
		
		password = new JPasswordField();
		password.setText("*********");
		password.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		password.setBounds(173,305,365,37);
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(MainWindow.STRONGBLACK);
		password.setBackground(MainWindow.WHITECOLOR);
		password.addMouseListener(this.mousePressed());
		panelLogin.add(password);
	
		
		btnLogin = new JButton("Ingresar");
		btnLogin.setBorder(null);
		btnLogin.setBounds(173, 438, 365, 42);
		btnLogin.setBackground(MainWindow.MAINCOLOR);
		btnLogin.setForeground(MainWindow.WHITECOLOR);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(actionListener);
		btnLogin.setActionCommand("LOGIN_USER");
		btnLogin.addMouseListener(this.mouseEntered());
		btnLogin.addMouseListener(this.mouseExited());
		panelLogin.add(btnLogin);
		
		JLabel iconUser = new JLabel();
		iconUser.setIcon(new ImageIcon(MainWindow.USER_ICON_PATH));
		iconUser.setBounds(622, 235, 57, 51);
		panelLogin.add(iconUser);
		JLabel iconPassword = new JLabel();
		iconPassword.setIcon(new ImageIcon(MainWindow.PASSWORD_ICON_PATH));
		iconPassword.setBounds(622, 307, 57, 51);
		panelLogin.add(iconPassword);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegister.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.WHITECOLOR));
		btnRegister.setBounds(268, 509, 166, 27);
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnRegister.setForeground(MainWindow.GRAY);
		btnRegister.setBackground(MainWindow.WHITECOLOR);
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(actionListener);
		btnRegister.setActionCommand("REGISTER_USER");
		btnRegister.addMouseListener(this.mouseEntered());
		btnRegister.addMouseListener(this.mouseExited());
		panelLogin.add(btnRegister);
		
		add(panelLogin);
	}
	
	//GETTERS AND SETTERS
	public String obtainUser() {
		return user.getText();
	}
	
	public String obtainPassword() {
		return String.valueOf(password.getPassword());
	}
	
	public void clearFields() {
		this.user.setText("Usuario");
		this.password.setText("*********");
	}
	
	// Metodos para manejar el efecto Hover de los botones
	private MouseAdapter mouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (e.getSource() == btnRegister)
					btnRegisterHover((JButton) e.getSource());
				else if (e.getSource() == btnLogin)
					btnMouseEntered();
			}
		};
	}

	private MouseAdapter mouseExited() {
		return new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if (e.getSource() == btnRegister)
					btnRegisterHoverExit(btnRegister);
				else if (e.getSource() == btnLogin)
					btnMouseExited();
			}
		};
	}

	private void btnRegisterHover(JButton btnRegister) {
		btnRegister.setForeground(MainWindow.MAINCOLOR);
	}

	private void btnRegisterHoverExit(JButton btnRegister) {
		btnRegister.setForeground(MainWindow.STRONGGRAY);
	}

	private void btnMouseEntered() {
		btnLogin.setBackground(MainWindow.HOVERCOLOR);
	}

	private void btnMouseExited() {
		btnLogin.setBackground(MainWindow.MAINCOLOR);
	}
	
	
	//Metodos para el efecto de llenado de los campos de texto de usuario y contraseñ
	private MouseAdapter mousePressed() {
		return new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource().equals(user))
					txtUserMousePressed(e);
				else if(e.getSource().equals(password))
					txtPassMousePressed(e);
			}
		};
	}

	
	private void txtUserMousePressed(java.awt.event.MouseEvent e) {
		if(user.getText().equals("Usuario")) {
			user.setText("");
			user.setForeground(MainWindow.STRONGGRAY);
		}
		if(String.valueOf(password.getPassword()).isEmpty()) {
			password.setText("*********");
			password.setForeground(MainWindow.GRAY);
		}
	}
	private void txtPassMousePressed(java.awt.event.MouseEvent e) {
		
		if(String.valueOf(password.getPassword()).equals("*********")) {
			password.setText("");
			password.setForeground(MainWindow.GRAY);
		}
		if(user.getText().isEmpty()) {
			user.setText("Usuario");
			user.setForeground(MainWindow.STRONGGRAY);
		}
	}
	
}
