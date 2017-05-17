package bbdd;

import java.sql.SQLException;
import java.util.Vector;
import clases.Aviso;

public class BBDD_Aviso extends BBDD_Proyecto{

	public BBDD_Aviso(String bbdd) {
		super(bbdd);
	}
	
	//COMPROBADO Y FUNCIONA
	public boolean crearAviso(Aviso a){
		String cadena1="INSERT INTO avisos (Dni_Emple, Motivo, FH_Creacion) values ('"+a.getDni_emple()+"','"+a.getMotivo()+"','"+a.getFh_creado()+"')";
		
		try{
			this.abrir();
			s=c.createStatement();
			s.executeUpdate(cadena1);
			reg=s.executeQuery("SELECT MAX(N_Aviso) FROM avisos");
			if (reg.next()){
				Vector<String> destinatarios=new Vector<String>();
				destinatarios=a.getDestinatarios();
				int nmensaje=reg.getInt(1);		
				for(String d: destinatarios){
					String cadena2="INSERT INTO avisos_dest values("+ nmensaje +",'"+ d +"')";
					s.executeUpdate(cadena2);
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
	
	//COMPROBADO Y FUNCIONA
	public Vector<Aviso> leerAvisos(String dni){
		String cadena="SELECT N_Aviso FROM avisos_dest WHERE Destinatario='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			reg = s.executeQuery(cadena);
			Vector<Aviso> avisos=new Vector<Aviso>();
			Vector<String> naviso=new Vector<String>();
			while(reg.next()){
				naviso.add(reg.getString(1));
			}
			for(String na: naviso){
				s2=c.createStatement();
				String cadena3="UPDATE avisos SET FH_Leido=CURRENT_TIMESTAMP where N_Aviso="+na+" AND FH_Leido is NULL";
				s.executeUpdate(cadena3);
				String cadena2="SELECT Dni_Emple, Motivo, FH_Creacion FROM avisos WHERE N_Aviso="+na;
				reg2 = s2.executeQuery(cadena2);
				while(reg2.next())
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
