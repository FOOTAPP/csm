package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Clase BBDD_Proyecto.
 * Clase padre de BBDD_Aviso,BBDD_Empleado,BBDD_Fisio,BBDD_Jugador.
 */
public class BBDD_Proyecto extends BBDD_Conexion{

	
	protected static Statement s; // objeto tipo Statement,  
	protected static Statement s2; // objeto tipo Statement,
	protected static ResultSet reg; // objeto tipo ResultSet,
	protected static ResultSet reg2; // objeto tipo ResultSet,
	
	/**
	 * Costructor BBDD proyecto.
	 *
	 * @parametro bbdd
	 *           
	 */
	public BBDD_Proyecto(String bbdd){
		super (bbdd);
	}
	
	
	/**
	 * Método BuscarJugadores, devuelve un vector con los DNIs de los jugadores.
	 * Es utilizado en las clases DarbajaJugador, DarbajaJugador2,  ModificarCuentaJugador y VentanaGenerarInforme
	 *
	 * @return the vector
	 */
	public Vector<String> buscarJugadores(){
		String cadena="SELECT Dni_Jugador FROM jugadores";// selecciona el dni de los jugadores
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			reg=s.executeQuery(cadena); // Con el objeto s, se utiliza el método executeQuery(), devuelve "reg" tipo ResultSet 
			Vector<String> jug=new Vector<String>();
			while(reg.next()) // mientras exista un próximo registro, añade Dni_Jugador
				jug.add(reg.getString(1));
			s.close();
			this.cerrar();
			return jug;	// retorna los jugadores encontrados
		}
		catch ( SQLException e){
			this.cerrar();
			return null;
		}
	}
	
	/**
	 * Método BuscarEmpleado, devuelve un vector con los DNIs de los Empleado.
	 * Es utilizado en las clases CrearAviso, DarBajaEmpleado, DarBajaEmpleado2 y ModificarCuentaEmpleado
	 *
	 * @return un vector
	 */
	public Vector<String> buscarEmpleado(){
		String cadena="SELECT Dni_Emple FROM empleados";// selecciona el dni de los empleados
		try{
			this.abrir();
			s=c.createStatement(); // similar al metodo anterior
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
	 * Método estático validarCuenta, valida una cuenta u devuelve true o false.
	 * Es utilizado en las clases DarAltaEmpleado, DarAltaJugador, ModificarCuentaJugador y ModificarCuentaEmpleado
	 *
	 * @param cuenta
	 *            
	 * @return true o false
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
	 * Metodo Validar correo,valida una correo y devuelve true o false..
	 * Es utilizado en las clases DarAltaEmpleado, DarAltaJugador.
	 * @param correo
	 *           
	 * @return true, si es correcto.
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
	 * Método Validaredad, valida la edad que sea mayor de 18 años.
	 * Es utilizado en las clases DarAltaEmpleado, DarAltaJugador.
	 * @param fnacimiento (fecha de nacimiento)
	 *            
	 * @return true, si es correcto.
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
	 * Método validarTelefono, valida el numero de teléfono o móvil.
	 * Es utilizado en las clases DarAltaEmpleado, DarAltaJugador.
	 * @param telefono
	 *        
	 * @return true, si es correcto.
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
	 * Metodo buscarPresi, obtiene el DNI del presidente.
	 * Es utilizado en las clases ModificarCuentaEmpleado, ModificarCuentaJugador y VentanaOpciones.
	 * @return  string
	 */
 	public String buscarPresi (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='PRESIDENTE'"; // Selecciona el dni del presidente
			try{
				this.abrir();
				s=c.createStatement();// similar al metodo anterior
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
		 * Metodo buscarEntrenador, obtiene el DNI del entrenador.
		 * Es utilizado en las clases CrearAviso,LeerAviso y VentanaOpcionesEntrenador.
		 * @return  string
		 */
		public String buscarEntrenador (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='ENTRENADOR'";// Selecciona el dni del entrenador
			try{
				this.abrir();
				s=c.createStatement(); // similar al metodo anterior
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
		 * Metodo buscarFinanciero, obtiene el DNI del financiero. .
		 * Es utilizado en la clase VentanaOpcionesFinanciero.
		 * @return string
		 */
		public String buscarFinanciero (){
			String cadena="SELECT Dni_Emple FROM empleados where cargo='FINANCIERO'"; // Selecciona el dni del financiero
			try{
				this.abrir();
				s=c.createStatement(); // similar al metodo anterior
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