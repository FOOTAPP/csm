package clases;

import java.time.LocalDateTime;

/**
 * Clase Tratamiento.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class Tratamiento {

	private String dni_jugador, motivo, dni_fisio, diagnostico;
	private LocalDateTime fh_sesion;
	
	/**
	 * Constructor Tratamiento.
	 *
	 * @param dni_jugador
	 *          
	 * @param motivo
	 *     
	 * @param dni_fisio
	 *           
	 * @param diagnostico
	 *           
	 * @param fh_sesion
	 *        
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
	 * Gets dni_jugador.
	 * solo aquí
	 * @return dni_jugador tipo String
	 */
	public String getDni_Jugador() {
		return dni_jugador;
	}

	/**
	 * Gets  motivo.
	 * solo aquí
	 * @return  motivo tipo String
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Gets dni_fisio.
	 * solo aquí
	 * @return  dni_fisio tipo String
	 */
	public String getDni_fisio() {
		return dni_fisio;
	}

	/**
	 * Gets diagnostico.
	 * solo aquí
	 * @return  diagnostico tipo String
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Gets fh_sesion.
	 * solo aquí
	 * @return fh_sesion tipo LocalDateTime
	 */
	public LocalDateTime getFh_sesion() {
		return fh_sesion;
	}
	
}
