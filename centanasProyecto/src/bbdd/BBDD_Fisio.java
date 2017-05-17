package bbdd;

import java.sql.SQLException;
import java.util.Vector;

import clases.Tratamiento;

public class BBDD_Fisio extends BBDD_Proyecto{

	public BBDD_Fisio(String bbdd) {
		super(bbdd);
	}
	
	//COMPROBADO Y FUNCIONA
	public boolean nuevaSesion (Tratamiento t){
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
}
