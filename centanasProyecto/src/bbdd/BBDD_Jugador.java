package bbdd;

import java.sql.SQLException;
import clases.Jugador;

/**
 * Clase BBDD_Jugador.
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
	 * Método altaJugador,  alta a un nuevo jugador con todos sus datos personales.
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
			s.executeUpdate(cadena); // Ejecuta la instrucción SQL en el objeto s 
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
	 * Método borrarJugador, borra o da de baja a un jugador.
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
			int f=s.executeUpdate(cadena); // Ejecuta la instrucción SQL en el objeto s 
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
	 * Método actualizarCuentaJugador.
	 * Es utilizado en la clase ModificarCuentaJugador.
	 * @param j de tipo Jugador(datos de la clase Jugador);
	 *            
	 * @return int
	 */
	//COMPROBADO Y FUNCIONA
	public int actualizarCuentaJugador (Jugador j){ // recibe DNI del  jugadorer a modificar cuenta
		String cadena="UPDATE jugadores SET Cuenta_Bancaria='"+j.getCuenta()+"' WHERE Dni_Jugador='"+j.getDni_jugador()+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			int f=s.executeUpdate(cadena); // Ejecuta la instrucción SQL en el objeto s 
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
	 * Buscar dni.
	 *
	 * @param dni
	 *            the dni
	 * @return the int
	 */
	//COMPROBADO Y FUNCIONA
	public int buscarDni (String dni){
		String cadena="SELECT Dni_Jugador FROM jugadores where Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while(reg.next()){
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
	 * Buscar cuenta.
	 *
	 * @param cuenta
	 *            the cuenta
	 * @return the int
	 */
	//COMPROBADO Y FUNCIONA
	public int buscarCuenta (String cuenta){
		String cadena="SELECT Dni_Jugador FROM jugadores where Cuenta_Bancaria='"+cuenta+"'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while(reg.next()){
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
