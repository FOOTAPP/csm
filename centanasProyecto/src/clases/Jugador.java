package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class Jugador.
 */
public class Jugador {

	/** The telf. */
	private String nombre, dni_jugador, email, demarcacion, cuenta, telf;
	
	/** The alta club. */
	private LocalDateTime alta_club;
	
	/** The f nac. */
	private LocalDate f_nac;
	
	/** The lesionado. */
	private boolean lesionado=false;
	
	/**
	 * Instantiates a new jugador.
	 *
	 * @param nombre
	 *            the nombre
	 * @param dni_jugador
	 *            the dni jugador
	 * @param email
	 *            the email
	 * @param demarcacion
	 *            the demarcacion
	 * @param cuenta
	 *            the cuenta
	 * @param telf
	 *            the telf
	 * @param alta_club
	 *            the alta club
	 * @param f_nac
	 *            the f nac
	 */
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
	
	/**
	 * Instantiates a new jugador.
	 *
	 * @param dni_jugador
	 *            the dni jugador
	 * @param cuenta
	 *            the cuenta
	 */
	public Jugador(String dni_jugador, String cuenta){
		super();
		this.dni_jugador = dni_jugador;
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
	 * Gets the dni jugador.
	 *
	 * @return the dni jugador
	 */
	public String getDni_jugador() {
		return dni_jugador;
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
	 * Gets the demarcacion.
	 *
	 * @return the demarcacion
	 */
	public String getDemarcacion() {
		return demarcacion;
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

	/**
	 * Checks if is lesionado.
	 *
	 * @return true, if is lesionado
	 */
	public boolean isLesionado() {
		return lesionado;
	}
	
	
}
