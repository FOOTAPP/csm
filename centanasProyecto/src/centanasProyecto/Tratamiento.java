package centanasProyecto;

import java.time.LocalDateTime;

public class Tratamiento {

	private String dni_jugador, motivo, dni_fisio, diagnostico;
	private LocalDateTime fh_sesion;
	
	public Tratamiento(String dni_jugador, String motivo, String dni_fisio, String diagnostico, LocalDateTime fh_sesion) {
		super();
		this.dni_jugador = dni_jugador;
		this.motivo = motivo;
		this.dni_fisio = dni_fisio;
		this.diagnostico = diagnostico;
		this.fh_sesion = fh_sesion;
	}

	public String getDni_Jugador() {
		return dni_jugador;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getDni_fisio() {
		return dni_fisio;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public LocalDateTime getFh_sesion() {
		return fh_sesion;
	}
	
}
