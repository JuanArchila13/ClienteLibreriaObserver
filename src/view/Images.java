package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Images extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnFile;
	private JLabel lblImage;
	public Images() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(10,10,500,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		initComponents(this);
	}
	private void initComponents(ActionListener actionListener) {
		btnFile = new JButton("Foto");
		btnFile.addActionListener(actionListener);
		contentPane.setLayout(null);
		btnFile.setActionCommand("FILE");
		btnFile.setBounds(175, 240, 100, 50);
		contentPane.add(btnFile);
		
		lblImage = new JLabel("New label");
		lblImage.setBounds(153, 21, 148, 204);
		contentPane.add(lblImage);
	}
	public String chooseImage() throws IOException {
		String path = "data//frontPages//libro1.jpg";
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png");
		fileChooser.setFileFilter(filter);
		
		int response = fileChooser.showOpenDialog(this);
		if(response == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();
			
			FileInputStream fileInput = new FileInputStream(path);
			byte[] bytesImage = fileInput.readAllBytes();
			int len = bytesImage.length;
			System.out.println(len);
			//Se debe crear mandar esta informacion para crear la imagen
			int nBytes;
			
			while((nBytes = fileInput.read()) != -1) {
				
			}
		}
		return path;
	}
	
	public void showImage(String path) {
		Image image = new ImageIcon(path).getImage();
		ImageIcon icon = new ImageIcon(image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(icon);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Images image = new Images();
		image.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("FILE")) {
			try {
				showImage(this.chooseImage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
