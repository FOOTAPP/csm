package clases;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Vector;

/**
 * Clase Aviso.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 */
public class Aviso {

	
	@Override
	public String toString() {
		return dni_emple + ", " + motivo + ", " + date;
	}
	
	private String dni_emple, motivo;
	private LocalDateTime fh_leido, fh_creado;
	private Vector<String> destinatarios;
	private Date date;
	
	/**
	 * Constructor Aviso.
	 *
	 * @param dni_emple
	 *            
	 * @param motivo
	 *           
	 * @param fh_creado
	 *            
	 * @param destinatarios
	 *            
	 */
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado, Vector<String> destinatarios) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
		this.destinatarios = destinatarios;
	}
	
	/**
	 * Constructor Aviso.
	 *
	 * @param dni_emple
	 *            
	 * @param motivo
	 *           
	 * @param fh_creado
	 *            
	 */
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
	}

	/**
	 * Constructor Aviso.
	 *
	 * @param dni_emple
	 *            
	 * @param motivo
	 *            
	 * @param date
	 *          
	 */
	public Aviso(String dni_emple, String motivo, Date date) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.date = date;
	}
	

	/**
	 * Gets dni_emple.
	 * Es utilizado en el m�todo crearAviso(Aviso) de la clase BBDD_Aviso
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase CrearAviso.
	 * Es utilizado la clase LeerAviso2(Aviso, String)
	 * y a su vez esta clase es utilizado en el metodo actionPerformed(ActionEvent) de la clase LeerAviso,
	 * y a su vez esta clase es utilizado en el metodo run() de la clase LeerAviso2.
	 * @return dni_emple tipo String
	 */
	public String getDni_emple() {
		return dni_emple;
	}

	/**
	 * Gets  motivo.
	 * Es utilizado en el m�todo crearAviso(Aviso) de la clase BBDD_Aviso
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase CrearAviso.
	 * Es utilizado la clase LeerAviso2(Aviso, String)
	 * y a su vez esta clase es utilizado en el metodo actionPerformed(ActionEvent) de la clase LeerAviso,
	 * y a su vez esta clase es utilizado en el metodo run() de la clase LeerAviso2.
	 * @return  motivo tipo String
	 */
	public String getMotivo() {
		return motivo;
	}


	/**
	 * Gets  fh creado.
	 * Es utilizado en el m�todo crearAviso de la clase BBDD_Aviso
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase CrearAviso
	 * @return fh creado tipo LocalDateTime
	 */
	public LocalDateTime getFh_creado() {
		return fh_creado;
	}

	/**
	 * Gets destinatarios.
	 * Es utilizado en el m�todo crearAviso de la Clase BBDD_Aviso
	 *  y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase CrearAviso
	 * @return destinatarios tipo Vector
	 */
	public Vector<String> getDestinatarios() {
		return destinatarios;
	}

	/**
	 * Metodo Getter date.
	 * Es utilizado en la clase LeerAviso2 (Aviso,String )
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase LeerAviso, 
	 * y  metodo run() de la clase LeerAviso2
	 * 
	 * @return  date tipo Date
	 */
	public Date getDate() {
		return date;
	}
	
	
	
} 
