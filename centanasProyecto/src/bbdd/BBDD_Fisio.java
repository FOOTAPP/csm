package bbdd;

import java.sql.SQLException;
import java.util.Vector;

import clases.Tratamiento;

/**
 * Clase BBDD_Fisio.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class BBDD_Fisio extends BBDD_Proyecto{

	/**
	 * constructor BBDD_Fisio.
	 *
	 * @param bbdd
	 *            
	 */
	public BBDD_Fisio(String bbdd) {
		super(bbdd);
	}
	
	/**
	 * Método nuevaSesion, .
	 * Es utilizado en la clase VentanaGenerarInforme
	 * @param t
	 *           
	 * @return true, si es correcto.
	 */
	//COMPROBADO Y FUNCIONA
	public boolean nuevaSesion (centanasProyecto.Tratamiento t){//recibe e inserta datos del jugador de la  clase Tratamiento
		String cadena="INSERT INTO sesion values ('"+t.getDni_Jugador()+"','"+t.getDni_fisio()+"','"+t.getFh_sesion()+"','"+
				t.getMotivo()+"','"+t.getDiagnostico()+"')";
		try{
			this.abrir();
			s=c.createStatement();// metodo para obtener s (objeto Statement)
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
	 * Método darAltaMedica, actualiza estado del jugador para el alta médica.
	 * Es utilizado en la clase DarAltaMedica
	 * @param dni
	 *            
	 * @return  int
	 */
	//COMPROBADO Y FUNCIONA
	public int darAltaMedica (String dni){ //recibe un DNI como parametro, en caso de ser valido procede  a dar el alta medica
		String cadena="UPDATE jugadores SET Lesionado='No' WHERE Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();// metodo para obtener s (objeto Statement)
			int filas=s.executeUpdate(cadena);// Ejecuta la instrucción SQL en el objeto s 
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * Mètodo darBajaMedica, actualiza estado del jugador para la baja médica..
	 * Es utilizado en la clase ventanabajamedica
	 * @param dni
	 *          
	 * @return int
	 */
	//COMPROBADO Y FUNCIONA
	public int darBajaMedica (String dni){  //recibe un DNI como parametro, en caso de ser valido procede  a dar el baja medica
		String cadena="UPDATE jugadores SET Lesionado='Si' WHERE Dni_Jugador='"+dni+"'";// modifica la tabla jugadores a "lesionado=si" al jugador cuyo DNI se haya encontrado.
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadena);// similar al mètodo anterior
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
	/**
	 * Método buscarJugadoresLesionados.
	 * Es utilizado en las clases DarAltaMedica y ventanabajamedica
	 * @param una variable lesionado de tip String, "si" o "no"
	 *           
	 * @return un vector con jugadores lesionados
	 */
	//COMPROBADO Y FUNCIONA
	public Vector<String> buscarJugadoresLesionados(String lesionado){// selecciona los jugadores  lesionados
		String cadena="SELECT Dni_Jugador FROM jugadores WHERE Lesionado='"+lesionado+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			reg=s.executeQuery(cadena); // Con el objeto s, se utiliza el método executeQuery(), devuelve "reg" de tipo ResultSet(tabla)
			Vector<String> jug=new Vector<String>(); // instancia el vector jug para almacenar los jugadores lesionados
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
	 * Método buscarFisioterapeutas.
	 * Es utilizado en la clase VentanaGenerarInforme
	 * @return un vector con fisioterapeutas encontrados 
	 */
	public Vector<String> buscarFisioterapeutas(){
		String cadena="SELECT Dni_Emple FROM empleados WHERE Cargo ='Fisioterapeuta'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);// similar al anterior metodo, pero almacenar fisioterapeutas encontrados
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
	
}
