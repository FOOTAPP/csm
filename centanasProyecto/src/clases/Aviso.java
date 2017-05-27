package clases;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Vector;

/**
 * The Class Aviso.
 */
public class Aviso {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return dni_emple + ", " + motivo + ", " + date;
	}

	/** The motivo. */
	private String dni_emple, motivo;
	
	/** The fh creado. */
	private LocalDateTime fh_leido, fh_creado;
	
	/** The destinatarios. */
	private Vector<String> destinatarios;
	
	/** The date. */
	private Date date;
	
	/**
	 * Instantiates a new aviso.
	 *
	 * @param dni_emple
	 *            the dni emple
	 * @param motivo
	 *            the motivo
	 * @param fh_creado
	 *            the fh creado
	 * @param destinatarios
	 *            the destinatarios
	 */
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado, Vector<String> destinatarios) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
		this.destinatarios = destinatarios;
	}
	
	/**
	 * Instantiates a new aviso.
	 *
	 * @param dni_emple
	 *            the dni emple
	 * @param motivo
	 *            the motivo
	 * @param fh_creado
	 *            the fh creado
	 */
	public Aviso(String dni_emple, String motivo, LocalDateTime fh_creado) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.fh_creado = fh_creado;
	}

	/**
	 * Instantiates a new aviso.
	 *
	 * @param dni_emple
	 *            the dni emple
	 * @param motivo
	 *            the motivo
	 * @param date
	 *            the date
	 */
	public Aviso(String dni_emple, String motivo, Date date) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
		this.date = date;
	}
	
	/**
	 * Instantiates a new aviso.
	 *
	 * @param dni_emple
	 *            the dni emple
	 * @param motivo
	 *            the motivo
	 */
	public Aviso(String dni_emple, String motivo) {
		super();
		this.dni_emple = dni_emple;
		this.motivo = motivo;
	}

	/**
	 * Gets the dni emple.
	 *
	 * @return the dni emple
	 */
	public String getDni_emple() {
		return dni_emple;
	}

	/**
	 * Gets the motivo.
	 *
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Gets the fh leido.
	 *
	 * @return the fh leido
	 */
	public LocalDateTime getFh_leido() {
		return fh_leido;
	}

	/**
	 * Gets the fh creado.
	 *
	 * @return the fh creado
	 */
	public LocalDateTime getFh_creado() {
		return fh_creado;
	}

	/**
	 * Gets the destinatarios.
	 *
	 * @return the destinatarios
	 */
	public Vector<String> getDestinatarios() {
		return destinatarios;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	
	
} 
