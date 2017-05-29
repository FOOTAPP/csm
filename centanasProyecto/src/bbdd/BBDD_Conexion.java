package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class BBDD_Conexion {

	private String base;
	private String usuario;
	private String pass;
	private String url;
	protected Connection c;
	private Properties prop;
	private String dbms;
	private String driver;
	private String dbName;
	private String serverName;
	private int portNumber;
	/*
	public BBDD_Conexion(String bbdd){		
		base=bbdd;
		usuario="groot";
		pass="yosoygroot";
		url="jdbc:mysql://localhost/"+base;
	}
	*/
	
	public BBDD_Conexion(String fileName) {	
		try{
			this.prop = new Properties();
			prop.loadFromXML(BBDD_Conexion.class.getResourceAsStream("/Recursos/mysql-properties.xml"));
			//prop.loadFromXML(Files.newInputStream(Paths.get("mysql-properties.xml")));
		
			this.dbms = this.prop.getProperty("dbms");
			this.driver = this.prop.getProperty("driver");
			this.dbName = this.prop.getProperty("database_name");
			this.usuario = this.prop.getProperty("user_name");
			this.pass = this.prop.getProperty("password");
			this.serverName = this.prop.getProperty("server_name");
			this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));
			this.url = "jdbc:mysql://localhost/"+dbName;
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"No se encuentra el archivo de configuración");
			//System.out.println("No se encuentra el archivo de configuración");  
		}
		catch(InvalidPropertiesFormatException e){
			JOptionPane.showMessageDialog(null, "Error formato fichero de configuración");
			//System.out.println("Error formato fichero de configuración");
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error abriendo fichero de configuración");
			//System.out.println("Error abriendo fichero de configuración");
		}	
	}
	
	public void abrir(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c=DriverManager.getConnection(url,usuario,pass);
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	}	
	
	public void cerrar(){
		try{
			c.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}

}
