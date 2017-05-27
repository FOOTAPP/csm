package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class Empleado.
 */
public class Empleado {

	/** The telf. */
	private String nombre, dni_emple, email, cargo, cuenta, telf;
	
	/** The alta club. */
	private LocalDateTime alta_club;
	
	/** The f nac. */
	private LocalDate f_nac;
	
	/**
	 * Instantiates a new empleado.
	 *
	 * @param nombre
	 *            the nombre
	 * @param dni_emple
	 *            the dni emple
	 * @param email
	 *            the email
	 * @param cargo
	 *            the cargo
	 * @param cuenta
	 *            the cuenta
	 * @param telf
	 *            the telf
	 * @param alta_club
	 *            the alta club
	 * @param f_nac
	 *            the f nac
	 */
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
	
	/**
	 * Instantiates a new empleado.
	 *
	 * @param dni_emple
	 *            the dni emple
	 * @param cuenta
	 *            the cuenta
	 */
	public Empleado(String dni_emple,String cuenta) {
		super();
		this.dni_emple = dni_emple;
		this.cuenta = cuenta;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the cargo.
	 *
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Gets the cuenta.
	 *
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * Gets the telf.
	 *
	 * @return the telf
	 */
	public String getTelf() {
		return telf;
	}

	/**
	 * Gets the alta club.
	 *
	 * @return the alta club
	 */
	public LocalDateTime getAlta_club() {
		return alta_club;
	}

	/**
	 * Gets the f nac.
	 *
	 * @return the f nac
	 */
	public LocalDate getF_nac() {
		return f_nac;
	}
	
}
