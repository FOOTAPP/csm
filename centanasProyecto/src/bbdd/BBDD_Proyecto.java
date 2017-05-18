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
}