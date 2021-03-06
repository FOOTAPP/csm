package bbdd;

import java.sql.SQLException;
import clases.Jugador;

/**
 * Clase BBDD_Jugador.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class BBDD_Jugador extends BBDD_Proyecto{

	/**
	 * constructor BBDD_Jugador.
	 *
	 * @param bbdd
	 *            
	 */
	public BBDD_Jugador(String bbdd) {
		super(bbdd);
	}
	
	/**
	 * M�todo altaJugador,  alta a un nuevo jugador con todos sus datos personales.
	 * Es utilizado en las clases DarAltaJugador y DarAltaJugador2 .
	 * @param j de tipo Jugador(datos de la clase Jugador);
	 *            
	 * @return true, si es correcto.
	 */
	//COMPROBADO Y FUNCIONA
	public boolean altaJugador (Jugador j){ //recibe datos del jugador a insertar
		String cadena="INSERT INTO jugadores values ('"+j.getDni_jugador()+"','"+j.getNombre()+"','"+j.getF_nac()+"','"+
				j.getTelf()+"','"+j.getAlta_club()+"','"+j.getCuenta()+"','"+j.getDemarcacion()+"','"+j.getEmail()+"','No')";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			s.executeUpdate(cadena); // Ejecuta la instrucci�n SQL en el objeto s 
			s.close();
			this.cerrar();
			return true;
		}
		catch ( SQLException e){
			this.cerrar();
			return false;
		}
	}
	
	/**
	 * M�todo borrarJugador, borra o da de baja a un jugador.
	 * Es utilizado en las clases DarBajaJugador y DarBajaEmpleado2 .
	 * @param dni
	 *          
	 * @return  int
	 */
	//COMPROBADO Y FUNCIONA
	public int borrarJugador (String dni){ // recibe DNI del  jugadorer a borrar
		String cadena="DELETE FROM jugadores WHERE Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			int f=s.executeUpdate(cadena); // Ejecuta la instrucci�n SQL en el objeto s 
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * M�todo actualizarCuentaJugador.
	 * Es utilizado en la clase ModificarCuentaJugador.
	 * @param j de tipo Jugador(datos de la clase Jugador);
	 *            
	 * @return int
	 */
	//COMPROBADO Y FUNCIONA
	public int actualizarCuentaJugador (Jugador j){ // actualiza cuenta bancaria utilizando el dni del jugador de la clase jugador
		String cadena="UPDATE jugadores SET Cuenta_Bancaria='"+j.getCuenta()+"' WHERE Dni_Jugador='"+j.getDni_jugador()+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			int f=s.executeUpdate(cadena); // Ejecuta la instrucci�n SQL en el objeto s 
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
	/**
	 * M�todo buscarDni, busca el DNI del jugador pasando un parametro de busqueda.
	 * Es utilizado en las clases DarAltaJugador y  DarAltaJugador2.
	 * @param dni
	 *            
	 * @return int
	 */
	//COMPROBADO Y FUNCIONA
	public int buscarDni (String dni){ // busca el dni de los jugadores pasando un parametro valido
		String cadena="SELECT Dni_Jugador FROM jugadores where Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			reg=s.executeQuery(cadena); // Con el objeto s, se utiliza el m�todo executeQuery(), devuelve "reg" de tipo ResultSet
			while(reg.next()){ //mientras exista un pr�ximo registro, retorna 1 o 0 si no hay mas registros
				s.close();
				this.cerrar();
				return 1;
			}
			s.close();
			this.cerrar();
			return 0; 
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * Metodo BuscarCuenta.
	 * Es utilizado en las clases DarAltaJugador y ModificarCuentaJugador .
	 * @param cuenta
	 *            
	 * @return  int
	 */
	//COMPROBADO Y FUNCIONA
	public int buscarCuenta (String cuenta){// busca el dni de los jugadores pasando un parametro cuenta valido
		String cadena="SELECT Dni_Jugador FROM jugadores where Cuenta_Bancaria='"+cuenta+"'";
		try{
			this.abrir();
			s=c.createStatement(); // similar al anterior
			reg=s.executeQuery(cadena);
			while(reg.next()){ //mientras exista un pr�ximo registro, retorna 1 o 0 si no hay mas registros
				s.close();
				this.cerrar();
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	

}
