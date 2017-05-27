package centanasProyecto;

import java.time.LocalDateTime;

/**
 * The Class Tratamiento.
 */
public class Tratamiento {

	/** The diagnostico. */
	private String dni_jugador, motivo, dni_fisio, diagnostico;
	
	/** The fh sesion. */
	private LocalDateTime fh_sesion;
	
	/**
	 * Instantiates a new tratamiento.
	 *
	 * @param dni_jugador
	 *            the dni jugador
	 * @param motivo
	 *            the motivo
	 * @param dni_fisio
	 *            the dni fisio
	 * @param diagnostico
	 *            the diagnostico
	 * @param fh_sesion
	 *            the fh sesion
	 */
	public Tratamiento(String dni_jugador, String motivo, String dni_fisio, String diagnostico, LocalDateTime fh_sesion) {
		super();
		this.dni_jugador = dni_jugador;
		this.motivo = motivo;
		this.dni_fisio = dni_fisio;
		this.diagnostico = diagnostico;
		this.fh_sesion = fh_sesion;
	}

	/**
	 * Gets the dni jugador.
	 *
	 * @return the dni jugador
	 */
	public String getDni_Jugador() {
		return dni_jugador;
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
	 * Gets the dni fisio.
	 *
	 * @return the dni fisio
	 */
	public String getDni_fisio() {
		return dni_fisio;
	}

	/**
	 * Gets the diagnostico.
	 *
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Gets the fh sesion.
	 *
	 * @return the fh sesion
	 */
	public LocalDateTime getFh_sesion() {
		return fh_sesion;
	}
	
}
