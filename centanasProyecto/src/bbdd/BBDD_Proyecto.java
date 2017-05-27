package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * The Class BBDD_Proyecto.
 */
public class BBDD_Proyecto extends BBDD_Conexion{

	/** The s. */
	protected static Statement s;
	
	/** The s 2. */
	protected static Statement s2;	
	
	/** The reg. */
	protected static ResultSet reg;
	
	/** The reg 2. */
	protected static ResultSet reg2;
	
	/**
	 * Instantiates a new BBD D proyecto.
	 *
	 * @param bbdd
	 *            the bbdd
	 */
	public BBDD_Proyecto(String bbdd){
		super (bbdd);
	}
	
	
	/**
	 * Buscar jugadores.
	 *
	 * @return the vector
	 */
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
	
	/**
	 * Buscar empleado.
	 *
	 * @return the vector
	 */
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
	
	/**
	 * Validar cuenta.
	 *
	 * @param cuenta
	 *            the cuenta
	 * @return true, if successful
	 */
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
	
	 /**
	 * Validar correo.
	 *
	 * @param correo
	 *            the correo
	 * @return true, if successful
	 */
 	public boolean validarCorreo(String correo){
			boolean letra=false;
			boolean fin=false;
			for (int cont=0; cont < correo.length(); cont++)
				if(correo.charAt(cont) == '@')
					letra=true;
			if(correo.endsWith(".es") || correo.endsWith(".com"))
				fin=true;
			if(letra == true && fin == true)
				return true;
			else
				return false;
		}
	 
	 /**
	 * Validar edad.
	 *
	 * @param fnacimiento
	 *            the fnacimiento
	 * @return true, if successful
	 */
 	public boolean validarEdad(LocalDate fnacimiento){
			GregorianCalendar hoy=new GregorianCalendar();
			int anio=fnacimiento.getYear();
			int mes=fnacimiento.getMonthValue();
			int dia=fnacimiento.getDayOfMonth();
			GregorianCalendar fechanacimiento=new GregorianCalendar(anio, mes, dia);
			int edad=(int) ((hoy.getTimeInMillis()-fechanacimiento.getTimeInMillis())/(1000*3600));
			if(edad >= 18)
				return true;
			else
				return false;
		}
	 
	 /**
	 * Validar telefono.
	 *
	 * @param telefono
	 *            the telefono
	 * @return true, if successful
	 */
 	public boolean validarTelefono(String telefono){
			boolean primero=false;
			boolean extension=false;
			if(telefono.charAt(0) == '6' || telefono.charAt(0) == '7' || telefono.charAt(0) == '9')
				primero=true;
			if(telefono.length() == 9)
				extension=true;
			if(primero == true && extension == true)
				return true;
			else
				return false;
		}
	
	 /**
	 * Buscar presi.
	 *
	 * @return the string
	 */
 	public String buscarPresi (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='PRESIDENTE'";
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadena);
				while(reg.next())
					return reg.getString(1);
				return null;
			}
			catch ( SQLException e){
				this.cerrar();
				return null;
			}
		}
		
		/**
		 * Buscar entrenador.
		 *
		 * @return the string
		 */
		public String buscarEntrenador (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='ENTRENADOR'";
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadena);
				while(reg.next())
					return reg.getString(1);
				return null;
			}
			catch ( SQLException e){
				this.cerrar();
				return null;
			}
		}
		
		/**
		 * Buscar financiero.
		 *
		 * @return the string
		 */
		public String buscarFinanciero (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='FINANCIERO'";
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadena);
				while(reg.next())
					return reg.getString(1);
				return null;
			}
			catch ( SQLException e){
				this.cerrar();
				return null;
			}
		}
	
}