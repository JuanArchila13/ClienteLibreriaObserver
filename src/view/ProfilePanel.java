package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import structure.Person;

import javax.swing.SwingConstants;

public class ProfilePanel extends JPanel {
	private JLabel userName, userEmail, userAge, userID;
	
	public ProfilePanel(Person user) {
		setBorder(new LineBorder(Color.BLACK));
		setSize(914,635);
		setBackground(MainWindow.WHITECOLOR);
		setLayout(null);
		initComponents(user);
	}

	public void initComponents(Person user) {
		JLabel title = new JLabel("Mi Perfil");
		title.setFont(new Font("SansSerif", Font.BOLD, 38));
		title.setForeground(MainWindow.MAINCOLOR);
		title.setBounds(362, 47, 159, 49);
		add(title);
		
		JLabel userNameLabel = new JLabel("Nombre");
		userNameLabel.setForeground(new Color(46, 55, 100));
		userNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userNameLabel.setBounds(159, 151, 159, 49);
		add(userNameLabel);
		
		JLabel userEmailLabel = new JLabel("Correo Electronico");
		userEmailLabel.setForeground(new Color(46, 55, 100));
		userEmailLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userEmailLabel.setBounds(537, 151, 399, 49);
		add(userEmailLabel);
		
		JLabel userIDLabel = new JLabel("ID");
		userIDLabel.setForeground(new Color(46, 55, 100));
		userIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
		userIDLabel.setBounds(372, 333, 159, 49);
		userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(userIDLabel);
		
		userName = new JLabel();
		userName.setText(user.getName());
		userName.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userName.setForeground(MainWindow.STRONGBLACK);
		userName.setHorizontalAlignment(JLabel.CENTER);
		userName.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userName.setBackground(MainWindow.BEIGE);
		userName.setBounds(64, 236, 309, 34);
		userName.setOpaque(true);
		add(userName);
		
		userEmail = new JLabel();
		userEmail.setText(user.getEmail());
		userEmail.setOpaque(true);
		userEmail.setHorizontalAlignment(SwingConstants.CENTER);
		userEmail.setForeground(new Color(14, 29, 38));
		userEmail.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userEmail.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userEmail.setBackground(new Color(242, 242, 199));
		userEmail.setBounds(527, 236, 309, 34);
		add(userEmail);
		
	
		
		userID = new JLabel();
		userID.setText(user.getID());
		userID.setOpaque(true);
		userID.setHorizontalAlignment(SwingConstants.CENTER);
		userID.setForeground(new Color(14, 29, 38));
		userID.setFont(new Font("SansSerif", Font.ITALIC, 20));
		userID.setBorder(new MatteBorder(1, 1, 1, 1, MainWindow.MAINCOLOR));
		userID.setBackground(new Color(242, 242, 199));
		userID.setBounds(278, 418, 309, 34);
		add(userID);
	}
	
}
