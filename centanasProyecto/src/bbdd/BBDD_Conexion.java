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

/**
 * Clase BBDD_Conexion.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
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
	
	/**
	 * Inicia una conexión de la BBDD.
	 *
	 * @param fileName no se usa
	 *            
	 */
	public BBDD_Conexion(String fileName) {	
		try{
			this.prop = new Properties(); // Almacena la prefrencia del usuario
			prop.loadFromXML(Files.newInputStream(Paths.get("xml\\mysql-properties.xml")));
		
			this.dbms = this.prop.getProperty("dbms"); // nombre del sistema de datos "mysql"
			this.driver = this.prop.getProperty("driver"); // manejador de la base de datos
			this.dbName = this.prop.getProperty("database_name"); // nombre del esquema de la bbdd
			this.usuario = this.prop.getProperty("user_name");  // usuario con la que me concto a la bbdd
			this.pass = this.prop.getProperty("password");  // contraseña del ususario
			this.serverName = this.prop.getProperty("server_name");  // servidor donde esta desplegada la bbdd
			this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));  //puerto donde esta la base de datos
			this.url = "jdbc:mysql://localhost/"+dbName;  // es la conexion en si
		}
		catch(FileNotFoundException e){
			System.out.println("No se encuentra el archivo de configuración");  
		}
		catch(InvalidPropertiesFormatException e){
			System.out.println("Error formato fichero de configuración");
		}
		catch(IOException e){
			System.out.println("Error abriendo fichero de configuración");
		}	
	}
	
	/**
	 * Abre.
	 */
	public void abrir(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); // carga los drivers para conectar
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c=DriverManager.getConnection(url,usuario,pass); // Crea objeto tipo conección
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	}	
	
	/**
	 * Cierra.
	 */
	public void cerrar(){
		try{
			c.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}

}
