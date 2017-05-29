package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase Jugador.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class Jugador {
	
	private String nombre, dni_jugador, email, demarcacion, cuenta, telf;
	private LocalDateTime alta_club;
	private LocalDate f_nac;
	private boolean lesionado=false;
	
	/**
	 * Constructor Jugador.
	 *
	 * @param nombre
	 *           
	 * @param dni_jugador
	 *        
	 * @param email
	 *            
	 * @param demarcacion
	 *           
	 * @param cuenta
	 *         
	 * @param telf
	 *       
	 * @param alta_club
	 *        
	 * @param f_nac
	 *        
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
	 * Constructor Jugador.
	 *
	 * @param dni_jugador
	 *           
	 * @param cuenta
	 *       
	 */
	public Jugador(String dni_jugador, String cuenta){
		super();
		this.dni_jugador = dni_jugador;
		this.cuenta = cuenta;
	}

	/**
	 * Gets nombre.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2.
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the dni jugador.
	 * Es utilizado en el método ModificarCuentaJugador(Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase ModificarCuentaJugador.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2.
	 * @return the dni jugador
	 */
	public String getDni_jugador() {
		return dni_jugador;
	}

	/**
	 * Gets email.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2.
	 * @return  email tipo String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets demarcacion.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2.
	 * @return demarcacion
	 */
	public String getDemarcacion() {
		return demarcacion;
	}

	/**
	 * Gets cuenta.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2. 
	 * Es utilizado en el método actualizarCuentaJugador(Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase ModificarCuentaJugador
	 * @return cuenta tipo String
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * Gets telf.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2 
	 * @return telf tipo String
	 */
	public String getTelf() {
		return telf;
	}

	/**
	 * Gets alta_club.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2 
	 * @return alta_club tipo LocalDateTime
	 */
	public LocalDateTime getAlta_club() {
		return alta_club;
	}

	/**
	 * Gets f_nac.
	 * Es utilizado en el método altaJugador (Jugador) de la clase BBDD_Jugador
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaJugador y la clase DarAltaJugador2
	 * @return f_nac tipo LocalDate
	 */
	public LocalDate getF_nac() {
		return f_nac;
	}

	/**
	 * Método  si es lesionado.
	 * solo aquí
	 * @return true, si es lesionado tipo boolean
	 */
	public boolean isLesionado() {
		return lesionado;
	}
	
	
}
