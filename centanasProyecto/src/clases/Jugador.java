package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Jugador {

	private String nombre, dni_jugador, email, demarcacion, cuenta, telf;
	private LocalDateTime alta_club;
	private LocalDate f_nac;
	private boolean lesionado=false;
	
	public Jugador(String nombre, String dni_jugador, String email, String demarcacion, String cuenta, String telf,
			LocalDateTime alta_club, LocalDate f_nac) {
		super();
		this.nombre = nombre;
		this.dni_jugador = dni_jugador;
		this.email = email;
		this.demarcacion = demarcacion;
		this.cuenta = cuenta;
		this.telf = telf;
		this.alta_club = alta_club;
		this.f_nac = f_nac;
	}
	
	public Jugador(String dni_jugador, String cuenta){
		super();
		this.dni_jugador = dni_jugador;
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni_jugador() {
		return dni_jugador;
	}

	public String getEmail() {
		return email;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public String getCuenta() {
		return cuenta;
	}

	public String getTelf() {
		return telf;
	}

	public LocalDateTime getAlta_club() {
		return alta_club;
	}

	public LocalDate getF_nac() {
		return f_nac;
	}

	public boolean isLesionado() {
		return lesionado;
	}
	
	
}
