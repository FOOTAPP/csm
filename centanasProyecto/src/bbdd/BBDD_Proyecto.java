package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BBDD_Proyecto extends BBDD_Conexion{

	protected static Statement s;
	protected static Statement s2;	
	protected static ResultSet reg;
	protected static ResultSet reg2;
	
	public BBDD_Proyecto(String bbdd){
		super (bbdd);
	}
	
	
	public Vector<String> buscarJugadores(){
		String cadena="SELECT Dni_Jugador FROM jugadores";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			Vector<String> jug=new Vector<String>();
			while(reg.next())
				jug.add(reg.getString(1));
			s.close();
			this.cerrar();
			return jug;	
		}
		catch ( SQLException e){
			this.cerrar();
			return null;
		}
	}
	
	public Vector<String> buscarEmpleado(){
		String cadena="SELECT Dni_Emple FROM empleados";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			Vector<String> emp=new Vector<String>();
			while(reg.next())
				emp.add(reg.getString(1));
			s.close();
			this.cerrar();
			return emp;	
		}
		catch ( SQLException e){
			this.cerrar();
			return null;
		}
	}
	public static boolean validarCuenta(String cuenta){
		String miCuenta[];
		try{
		if(!cuenta.substring(0, 2).equals("ES"))
			return false;
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
		if(cuenta.length() != 27 )
			return false;
		miCuenta=cuenta.split("-");
		if (miCuenta.length!=5)
			 return false;
		try{
		Integer.parseInt(miCuenta[0].substring(2, 4));
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
		catch(NumberFormatException e){
			return false;
		}
		
		for (int i=1;i<miCuenta.length;i++){
		try{
		Integer.parseInt(miCuenta[i]);
		}
		catch(NumberFormatException e){
			return false;
		}
		}
		return true;
	}
	
	
}