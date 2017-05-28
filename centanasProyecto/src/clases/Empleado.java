package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase Empleado.
 */
public class Empleado {

	
	private String nombre, dni_emple, email, cargo, cuenta, telf;
	private LocalDateTime alta_club;
	private LocalDate f_nac;
	
	/**
	 * Constructor Empleado.
	 *
	 * @param nombre
	 *           
	 * @param dni_emple
	 *            
	 * @param email
	 *            
	 * @param cargo
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
	 * Constructor  Empleado.
	 *
	 * @param dni_emple
	 *            
	 * @param cuenta
	 *            
	 */
	public Empleado(String dni_emple,String cuenta) {
		super();
		this.dni_emple = dni_emple;
		this.cuenta = cuenta;
	}

	/**
	 * Gets nombre.
	 * Es utilizado en el m�todo altaEmpleado de la clase BBDD_Empleado 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2.
	 * @return nombre tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets dni_emple.
	 * Es utilizado en el m�todo altaEmpleado(Empleado) de la clase BBDD_Empleado 
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2.
	 * Es utilizado en el m�todo actualizarCuentaEmpleado(Empleado) de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase ModificarCuentaEmpleado.
	 * @return dni_emple tipo String
	 */
	public String getDni_emple() {
		return dni_emple;
	}

	/**
	 * Gets email.
	 * Es utilizado en el m�todo altaEmpleado(Empleado) de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2.
	 * @return  email tipo String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets cargo.
	 * Es utilizado en el m�todo altaEmpleado(Empleado) de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2.
	 * @return cargo tipo String
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Gets cuenta.
	 * Es utilizado en el m�todo altaEmpleado(Empleado) de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2.
	 * Es utilizado en el m�todo actualizarCuentaEmpleado(Empleado) de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase ModificarCuentaEmpleado.
	 * @return cuenta tipo String
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * Gets  telf.
	 * Es utilizado en el m�todo altaEmpleado de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2
	 * @return telf tipo String
	 */
	public String getTelf() {
		return telf;
	}

	/**
	 * Gets alta_club.
	 * Es utilizado en el m�todo altaEmpleado de la clase BBDD_Empleado
	 *  y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2
	 * @return alta_club tipo LocalDateTime
	 */
	public LocalDateTime getAlta_club() {
		return alta_club;
	}

	/**
	 * Gets  f_nac.
	 * Es utilizado en el m�todo altaEmpleado de la clase BBDD_Empleado
	 * y a su vez este metodo es utilizado en el metodo actionPerformed(ActionEvent) de la clase DarAltaEmpleado y la clase DarAltaEmpleado2
	 * @return f nac tipo LocalDate
	 */
	public LocalDate getF_nac() {
		return f_nac;
	}
	
}
