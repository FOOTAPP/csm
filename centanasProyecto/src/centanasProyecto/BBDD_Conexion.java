package centanasProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD_Conexion {

	private String base;
	private String usuario;
	private String pass;
	private String url;
	protected Connection c;
	
	public BBDD_Conexion(String bbdd){		
		base=bbdd;
		usuario="groot";
		pass="yosoygroot";
		url="jdbc:mysql://localhost/"+base;
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
