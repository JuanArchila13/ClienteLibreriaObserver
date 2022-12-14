package structure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ReadConfigs {
	private Properties properties;
	private FileInputStream input;
	private final String PROPERTIES_PATH = "data/config/configs.properties";
	
	public ReadConfigs() {
		this.properties = new Properties();
		try {
			this.input = new FileInputStream(PROPERTIES_PATH);
			properties.load(input);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer archivo de configuraciones.");
			e.printStackTrace();
		}
	}
	public int obtainPort() {
		System.out.println(properties.getProperty("IPConfig"));
		return Integer.parseInt(properties.getProperty("IPConfig"));
	}
	
	public String obtainHOST() {
		return properties.getProperty("HOST");
	}
}
