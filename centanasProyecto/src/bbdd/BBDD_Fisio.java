package bbdd;

import java.sql.SQLException;
import java.util.Vector;

import clases.Tratamiento;

/**
 * Clase BBDD_Fisio.
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
	 * Nueva sesion.
	 *
	 * @param t
	 *            the t
	 * @return true, if successful
	 */
	//COMPROBADO Y FUNCIONA
	public boolean nuevaSesion (centanasProyecto.Tratamiento t){
		String cadena="INSERT INTO sesion values ('"+t.getDni_Jugador()+"','"+t.getDni_fisio()+"','"+t.getFh_sesion()+"','"+
				t.getMotivo()+"','"+t.getDiagnostico()+"')";
		try{
			this.abrir();
			s=c.createStatement();
			s.executeUpdate(cadena);
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
	 * Dar alta medica.
	 *
	 * @param dni
	 *            the dni
	 * @return the int
	 */
	//COMPROBADO Y FUNCIONA
	public int darAltaMedica (String dni){
		String cadena="UPDATE jugadores SET Lesionado='No' WHERE Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadena);
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
	 * Dar baja medica.
	 *
	 * @param dni
	 *            the dni
	 * @return the int
	 */
	//COMPROBADO Y FUNCIONA
	public int darBajaMedica (String dni){
		String cadena="UPDATE jugadores SET Lesionado='Si' WHERE Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadena);
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
	 * Buscar jugadores lesionados.
	 *
	 * @param lesionado
	 *            the lesionado
	 * @return the vector
	 */
	//COMPROBADO Y FUNCIONA
	public Vector<String> buscarJugadoresLesionados(String lesionado){
		String cadena="SELECT Dni_Jugador FROM jugadores WHERE Lesionado='"+lesionado+"'";
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
	 * Buscar fisioterapeutas.
	 *
	 * @return the vector
	 */
	public Vector<String> buscarFisioterapeutas(){
		String cadena="SELECT Dni_Emple FROM empleados WHERE Cargo ='Fisioterapeuta'";
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
	
}
