package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import structure.Person;

public class RegisterPanel extends JPanel {
	private JPanel panelImage, panelLogin;
	private JTextField name,user;
	private JPasswordField password;
	private JButton btnCreateAccount,btnBack;
	private JTextField id;
	private JTextField lastName;
	private JTextField email;

	public RegisterPanel(ActionListener actionListener) {
		setSize(1200, 635);
		initComponents(actionListener);
	}
	private void initComponents(ActionListener listener) {
		setLayout(null);
		panelImage = new JPanel();
		panelImage.setBounds(0, 0, 452, 635);
		panelImage.setBackground(MainWindow.MAINCOLOR);
		add(panelImage);
		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(452, 0, 748, 635);
		panelLogin.setBackground(MainWindow.WHITECOLOR);
		
		//Componentes del panelRegistro
		JLabel lblTitle = new JLabel("Registro Usuario");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setForeground(MainWindow.STRONGBLACK);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(257,61,317,50);
		panelLogin.add(lblTitle);
		add(panelLogin);
		//Panel con informacion del usuario y contraseña a crear
		JPanel credentialsData = new JPanel();
		credentialsData.setBounds(103, 360, 609, 235);
		credentialsData.setBackground(MainWindow.WHITECOLOR);
		panelLogin.add(credentialsData);
		credentialsData.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(13, 43, 77, 18);
		lblUser.setForeground(MainWindow.MAINCOLOR);
		lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblUser.setBackground(MainWindow.WHITECOLOR);
		credentialsData.add(lblUser);
		
		user = new JTextField();
		user.setBounds(132, 28, 365, 33);
		user.setForeground(MainWindow.STRONGBLACK);
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(MainWindow.WHITECOLOR);
		user.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		user.setEnabled(false);
		credentialsData.add(user);
		
		JLabel invalidPassword = new JLabel("Dato no valido");
		invalidPassword.setForeground(Color.RED);
		invalidPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		invalidPassword.setBackground(new Color(235, 236, 240));
		invalidPassword.setBounds(507, 92, 113, 18);
		invalidPassword.setVisible(true);
		credentialsData.add(invalidPassword);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(10, 91, 103, 18);
		lblPassword.setForeground(MainWindow.MAINCOLOR);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPassword.setBackground(MainWindow.WHITECOLOR);
		credentialsData.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(132, 72, 365, 37);
		password.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		password.setForeground(MainWindow.STRONGBLACK);
		password.setBackground(MainWindow.WHITECOLOR);
		password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldsEmptyPasswordKeyReleased(evt, password, invalidPassword);
                areFieldsValid();
            }
        });
		credentialsData.add(password);
			
		btnCreateAccount = new JButton("Crear cuenta");
		btnCreateAccount.setBounds(118, 182, 365, 42);
		credentialsData.add(btnCreateAccount);
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setBackground(MainWindow.MAINCOLOR);
		btnCreateAccount.setForeground(MainWindow.WHITECOLOR);
		btnCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreateAccount.setFocusable(false);
		btnCreateAccount.addActionListener(listener);
		btnCreateAccount.setActionCommand("CREATE_ACCOUNT_USER");
		btnCreateAccount.addMouseListener(this.mouseEntered());
		btnCreateAccount.addMouseListener(this.mouseExited());
		btnCreateAccount.setEnabled(false);
		
		JLabel lblCrearCredenciales = new JLabel("Crear credenciales");
		lblCrearCredenciales.setForeground(MainWindow.MAINCOLOR);
		lblCrearCredenciales.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCrearCredenciales.setBackground(MainWindow.WHITECOLOR);
		lblCrearCredenciales.setBounds(0, 0, 165, 18);
		credentialsData.add(lblCrearCredenciales);
		
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon("data\\icons\\iconBack.png"));
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 23));
		btnBack.setBorder(null);
		btnBack.setBackground(MainWindow.MAINCOLOR);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setFocusable(false);
		btnBack.addActionListener(listener);
		btnBack.setActionCommand("BACK_TO_LOGIN");
		btnBack.addMouseListener(this.mouseEntered());
		btnBack.addMouseListener(this.mouseExited());
		btnBack.setBounds(26, 182, 54, 42);
		credentialsData.add(btnBack);
		initComponentsPersonalData();
	}
	private void initComponentsPersonalData() {
		JPanel personalData = new JPanel();
		personalData.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		personalData.setBounds(103, 130, 609, 219);
		personalData.setBackground(MainWindow.MAINCOLOR);
		panelLogin.add(personalData);
		personalData.setLayout(null);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 71, 77, 18);
		lblName.setForeground(MainWindow.WHITECOLOR);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblName.setBackground(MainWindow.MAINCOLOR);
		personalData.add(lblName);
	
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(MainWindow.WHITECOLOR);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblId.setBackground(MainWindow.MAINCOLOR);
		lblId.setBounds(10, 22, 77, 18);
		personalData.add(lblId);
		
		JLabel lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(MainWindow.WHITECOLOR);
		lblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblLastName.setBackground(MainWindow.MAINCOLOR);
		lblLastName.setBounds(10, 124, 98, 18);
		personalData.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Correo");
		lblEmail.setForeground(MainWindow.WHITECOLOR);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblEmail.setBackground(MainWindow.MAINCOLOR);
		lblEmail.setBounds(10, 174, 98, 18);
		personalData.add(lblEmail);
		
		JLabel invalidID = new JLabel("Dato no valido");
		invalidID.setForeground(Color.RED);
		invalidID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		invalidID.setBackground(new Color(235, 236, 240));
		invalidID.setBounds(496, 23, 113, 18);
		invalidID.setVisible(true);
		personalData.add(invalidID);
		
		id = new JTextField();
		id.setForeground(MainWindow.WHITECOLOR);
		id.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		id.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		id.setBackground(MainWindow.MAINCOLOR);
		id.setBounds(118, 11, 357, 29);
		id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberKeyRealeased(evt, id, invalidID);
                user.setText(id.getText());
                areFieldsValid();
            }
        });
		personalData.add(id);
		
		JLabel invalidName = new JLabel("Dato no valido");
		invalidName.setForeground(Color.RED);
		invalidName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		invalidName.setBackground(new Color(235, 236, 240));
		invalidName.setBounds(496, 72, 113, 18);
		invalidName.setVisible(true);
		personalData.add(invalidName);
		
		name = new JTextField();
		name.setBounds(118, 62, 357, 29);		
		name.setForeground(MainWindow.WHITECOLOR);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBackground(MainWindow.MAINCOLOR);
		name.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldsEmptyKeyReleased(evt, name, invalidName);
                areFieldsValid();
            }
        });
		personalData.add(name);
		
		JLabel invalidLastName = new JLabel("Dato no valido");
		invalidLastName.setForeground(Color.RED);
		invalidLastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		invalidLastName.setBackground(new Color(235, 236, 240));
		invalidLastName.setBounds(496, 125, 113, 18);
		invalidLastName.setVisible(true);
		personalData.add(invalidLastName);
		
		lastName = new JTextField();
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lastName.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		lastName.setBackground(MainWindow.MAINCOLOR);
		lastName.setBounds(118, 113, 357, 29);
		lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldsEmptyKeyReleased(evt, lastName, invalidLastName);
                areFieldsValid();
            }
        });
		personalData.add(lastName);
		
		JLabel invalidEmail = new JLabel("Dato no valido");
		invalidEmail.setForeground(Color.RED);
		invalidEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		invalidEmail.setBackground(new Color(235, 236, 240));
		invalidEmail.setBounds(496, 175, 113, 18);
		invalidEmail.setVisible(true);
		personalData.add(invalidEmail);
		
		email = new JTextField();
		email.setForeground(MainWindow.WHITECOLOR);
		email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		email.setBorder(new MatteBorder(0, 0, 2, 0, MainWindow.LIGHTGRAY));
		email.setBackground(MainWindow.MAINCOLOR);
		email.setBounds(118, 163, 357, 29);
		email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyRealeased(evt, email, invalidEmail);
                areFieldsValid();
            }
        });
		personalData.add(email);
	}
	//GETTERS
	public Person obtainNewUser() {
		return new Person(name.getText(),lastName.getText(),id.getText(),email.getText(),String.valueOf(password.getPassword()));
	}
	
	public void clearFields() {
		user.setText("");
		password.setText("");
		email.setText("");
		name.setText("");
		lastName.setText("");
		id.setText("");
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
		if (event.getSource() == btnBack)
			btnBack.setBackground(MainWindow.HOVERCOLOR);
		else if (event.getSource() == btnCreateAccount)
			btnCreateAccount.setBackground(MainWindow.HOVERCOLOR);
	}

	private void btnMouseExited(MouseEvent event) {
		if (event.getSource() == btnBack)
			btnBack.setBackground(MainWindow.MAINCOLOR);
		else if (event.getSource() == btnCreateAccount)
			btnCreateAccount.setBackground(MainWindow.MAINCOLOR);
	}
	
	private void numberKeyRealeased(java.awt.event.KeyEvent evt, JTextField textField, JLabel errorLabel) {
		if(isIntegerNumber(textField.getText()) || !textField.getText().equals("")) {
			errorLabel.setVisible(false);
			btnCreateAccount.setEnabled(true);	
		}else {
			errorLabel.setVisible(true);
			btnCreateAccount.setEnabled(false);
		}
	}
	
	private void emailKeyRealeased(java.awt.event.KeyEvent evt, JTextField textField, JLabel errorLabel) {
		if(isValidEmail(textField.getText())) {
			errorLabel.setVisible(false);
			btnCreateAccount.setEnabled(true);
		}else {
			errorLabel.setVisible(true);
			btnCreateAccount.setEnabled(false);
		}
	}
	
	private void fieldsEmptyKeyReleased(java.awt.event.KeyEvent evt, JTextField textField, JLabel errorLabel) {
		if(textField.getText().equals("")) {
			errorLabel.setVisible(true);
			btnCreateAccount.setEnabled(false);
		}else {
			errorLabel.setVisible(false);
			btnCreateAccount.setEnabled(true);
		}	
	}
	
	private void fieldsEmptyPasswordKeyReleased(java.awt.event.KeyEvent evt, JPasswordField passwordField, JLabel errorLabel) {
		if(String.valueOf(password.getPassword()).equals("")) {
			errorLabel.setVisible(true);
			btnCreateAccount.setEnabled(false);
		}else {
			errorLabel.setVisible(false);
			btnCreateAccount.setEnabled(true);
		}	
	}
	
	private void areFieldsValid() {
		if(!id.getText().equals("") && !name.getText().equals("") && !lastName.getText().equals("") && !email.getText().equals("") && !String.valueOf(password.getPassword()).equals("")) {
			btnCreateAccount.setEnabled(true);
		}else {
			btnCreateAccount.setEnabled(false);
		}
	}
	
	
	private boolean isIntegerNumber(String textNumber) {
		return textNumber.matches("^[0-9]+$");
	}

	private boolean isValidEmail(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
}
