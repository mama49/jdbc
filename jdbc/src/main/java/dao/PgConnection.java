package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PgConnection {

	private static Connection connection;
	
	private PgConnection() {
		try {
			// je charge mon fichier de configuration
			InputStream input = new FileInputStream("config.properties");
			Properties properties = new Properties();
			// je charge les propriétés
			properties.load(input);
			// je récupère les valeurs des propriétés
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			// j'initialise la connexion à la BDD
			connection = DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getInstance(){
		if(connection == null)
			new PgConnection();
		
		return connection;	
	}	
	 
}
