package clases;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Vector;

/**
 * Clase Aviso.
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
	 * Constructor Aviso.
	 *
	 * @param dni_emple
	 *            
	 * @param motivo
	 *           
	 */
	public Aviso(String dni_emple, String motivo) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
	}

	/**
	 * Gets dni_emple.
	 * Es utilizado en el método crearAviso de la clase BBDD_Aviso y en la clase LeerAviso2
	 * @return dni_emple tipo String
	 */
	public String getDni_emple() {
		return dni_emple;
	}

	/**
	 * Gets  motivo.
	 * Es utilizado en el método crearAviso de la clase BBDD_Aviso y en la clase LeerAviso2
	 * @return  motivo tipo String
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Gets  fh leido.
	 * Solo aqui
	 * @returnfh leido tipo LocalDateTime
	 */
	public LocalDateTime getFh_leido() {
		return fh_leido;
	}

	/**
	 * Gets  fh creado.
	 * Es utilizado en el método crearAviso de la clase BBDD_Aviso
	 * @return fh creado tipo LocalDateTime
	 */
	public LocalDateTime getFh_creado() {
		return fh_creado;
	}

	/**
	 * Gets destinatarios.
	 * Es utilizado en el método crearAviso de la Clase BBDD_Aviso
	 * @return destinatarios
	 */
	public Vector<String> getDestinatarios() {
		return destinatarios;
	}

	/**
	 * Metodo Getter date.
	 * Es utilizado en la clase LeerAviso2 ( que a su vez esta en el método actionPerformed de la Clase LeerAviso  y run ),  
	 * 
	 * @return  date
	 */
	public Date getDate() {
		return date;
	}
	
	
	
} 
