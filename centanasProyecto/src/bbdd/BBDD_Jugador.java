package bbdd;

import java.sql.SQLException;
import clases.Jugador;

public class BBDD_Jugador extends BBDD_Proyecto{

	public BBDD_Jugador(String bbdd) {
		super(bbdd);
	}
	
	//COMPROBADO Y FUNCIONA
	public boolean altaJugador (Jugador j){
		String cadena="INSERT INTO jugadores values ('"+j.getDni_jugador()+"','"+j.getNombre()+"','"+j.getF_nac()+"','"+
				j.getTelf()+"','"+j.getAlta_club()+"','"+j.getCuenta()+"','"+j.getDemarcacion()+"','"+j.getEmail()+"','No')";
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
	public int borrarJugador (String dni){
		String cadena="DELETE FROM jugadores WHERE Dni_Jugador='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int f=s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	//COMPROBADO Y FUNCIONA
	public int actualizarCuentaJugador (Jugador j){
		String cadena="UPDATE jugadores SET Cuenta_Bancaria='"+j.getCuenta()+"' WHERE Dni_Jugador='"+j.getDni_jugador()+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int f=s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return f;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
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
	
	
	

}
