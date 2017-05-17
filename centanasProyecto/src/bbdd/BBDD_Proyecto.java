package bbdd;

import java.sql.ResultSet;
import java.sql.Statement;

public class BBDD_Proyecto extends BBDD_Conexion{

	protected static Statement s;
	protected static Statement s2;	
	protected static ResultSet reg;
	protected static ResultSet reg2;
	
	public BBDD_Proyecto(String bbdd){
		super (bbdd);
	}
	
}