package centanasProyecto;

import java.time.LocalDateTime;

/**
 * Clase Tratamiento.
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
	 * Es utilizado en el método nuevaSesion(Tratamiento) de la clase BBDD_Fisio 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase  VentanaGenerarInforme.
	 * @return dni_jugador tipo String
	 */
	public String getDni_Jugador() {
		return dni_jugador;
	}

	/**
	 * Gets  motivo.
	 * Es utilizado en el método nuevaSesion(Tratamiento) de la clase BBDD_Fisio 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase  VentanaGenerarInforme.
	 * @return motivo tipo String
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Gets  dni_fisio.
	 * Es utilizado en el método nuevaSesion(Tratamiento) de la clase BBDD_Fisio 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase  VentanaGenerarInforme.
	 * @return dni_fisio tipo String
	 */
	public String getDni_fisio() {
		return dni_fisio;
	}

	/**
	 * Gets diagnostico.
	 * Es utilizado en el método nuevaSesion(Tratamiento) de la clase BBDD_Fisio 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase  VentanaGenerarInforme.
	 * @return diagnostico tipo String
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Gets fh_sesion.
	 * LocalDateTime
	 * @return  fh_sesion tipo LocalDateTime
	 */
	public LocalDateTime getFh_sesion() {
		return fh_sesion;
	}
	
}
