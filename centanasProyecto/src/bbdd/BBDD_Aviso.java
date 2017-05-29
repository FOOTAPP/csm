package bbdd;

import java.sql.SQLException;
import java.util.Vector;
import clases.Aviso;

/**
 * Clase BBDD_Aviso.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria 
 * @version 29.05.2017
 */
public class BBDD_Aviso extends BBDD_Proyecto{

	/**
	 * constructor BBDD_Aviso extiende de la clase BBDD_Proyecto.
	 *
	 * @param bbdd
	 *           
	 */
	public BBDD_Aviso(String bbdd) {
		super(bbdd);
	}
	
	/**
	 * Metodo crearAviso.
	 * Es utilizado en la clase CrearAviso (método actionPerformed )
	 * @param a de la clase Aviso
	 *          
	 * @return true, si es correcto
	 */
	//COMPROBADO Y FUNCIONA
	public boolean crearAviso(Aviso a){ // extrae Dni_Emple, MOtivo, Fh_creado de la tabla avisos para crear un aviso
		String cadena1="INSERT INTO avisos (Dni_Emple, Motivo, FH_Creacion) values ('"+a.getDni_emple()+"','"+a.getMotivo()+"','"+a.getFh_creado()+"')";
		
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			s.executeUpdate(cadena1);// Ejecuta la instrucción SQL en el objeto s 
			reg=s.executeQuery("SELECT MAX(N_Aviso) FROM avisos");// Obtiene el ultimo numero del campo N_Avisos de la tabla avisos
			if (reg.next()){// si queda un proximo registro, crea un vector  destinatarios
				Vector<String> destinatarios=new Vector<String>();
				destinatarios=a.getDestinatarios(); 
				int nmensaje=reg.getInt(1);		// lee el campo N_aviso
				for(String d: destinatarios){// recorre el vector destinatarios y almacena en cadena2 el insert
					String cadena2="INSERT INTO avisos_dest values("+ nmensaje +",'"+ d +"')";
					s.executeUpdate(cadena2); // Ejecuta la instrucción SQL en el objeto s 
				}	
			}	
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
	 * Método leerAvisos.
	 * Es utilizado en la clase LeerAviso (método actionPerformed ),  método actionPerformed de las clases LeerAviso2,
	 * VentanaOpciones, VentanaOpcionesEntrenador
	 * @param dni
	 *           
	 * @return un vector de la Clase Aviso
	 */
	//COMPROBADO Y FUNCIONA
	public Vector<Aviso> leerAvisos(String dni){ // obtiene el numero de aviso de la tabla avisos_dest den destinatario introducido como parametro (DNI)
		String cadena="SELECT N_Aviso FROM avisos_dest WHERE Destinatario='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			reg = s.executeQuery(cadena); // Ejecuta la instrucción SQL en el objeto s 
			Vector<Aviso> avisos=new Vector<Aviso>(); //vector de la clase Aviso que almacena, numero de aviso, dni_empleado y motivo
			Vector<String> naviso=new Vector<String>(); // vercor naviso
			while(reg.next()){ //mientra quede proximo registro, adiciona numero de aviso de la tabla avisos_dest
				naviso.add(reg.getString(1)); 
			}
			for(String na: naviso){
				s2=c.createStatement();
				String cadena3="UPDATE avisos SET FH_Leido=CURRENT_TIMESTAMP where N_Aviso="+na+" AND FH_Leido is NULL";
				s.executeUpdate(cadena3); // Ejecuta la instrucción SQL en el objeto s 
				String cadena2="SELECT Dni_Emple, Motivo, FH_Creacion FROM avisos WHERE N_Aviso="+na;
				reg2 = s2.executeQuery(cadena2); // Ejecuta la instrucción SQL en el objeto s 
				while(reg2.next()) // comentado en el vector avisos
					avisos.add(new Aviso(reg2.getString(1),reg2.getString(2), reg2.getDate(3)));
				s2.close();
			}
			s.close();
			this.cerrar();
			return avisos;
		}
		catch ( SQLException e){
			return null;
		}
	}
	
}
