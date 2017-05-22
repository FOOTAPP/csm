package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Empleado {

	private String nombre, dni_emple, email, cargo, cuenta, telf;
	private LocalDateTime alta_club;
	private LocalDate f_nac;
	
	public Empleado(String nombre, String dni_emple, String email, String cargo, String cuenta, String telf,
			LocalDateTime alta_club, LocalDate f_nac) {
		super();
		this.nombre = nombre;
		this.dni_emple = dni_emple;
		this.email = email;
		this.cargo = cargo;
		this.cuenta = cuenta;
		this.telf = telf;
		this.alta_club = alta_club;
		this.f_nac = f_nac;
	}
	
	public Empleado(String dni_emple,String cuenta) {
		super();
		this.dni_emple = dni_emple;
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni_emple() {
		return dni_emple;
	}

	public String getEmail() {
		return email;
	}

	public String getCargo() {
		return cargo;
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
	
}
