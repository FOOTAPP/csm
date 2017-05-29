package bbdd;

import java.sql.SQLException;
import clases.Empleado;

/**
 * Clase BBDD_Empleado.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria 
 * @version 29.05.2017
 */
public class BBDD_Empleado extends BBDD_Proyecto{

	/**
	 * constructor BBDD_Empleado extiende de la clase BBDD_Proyecto.
	 *
	 * @param bbdd
	 *            
	 */
	public BBDD_Empleado(String bbdd) {
		super(bbdd);
	}

	/**
	 * Método altaEmpleado.
	 * Es utilizado en las clases DarBajaEmpleado (método actionPerformed ) y DarBajaEmpleado2(método actionPerformed).
	 * @param emp de tipo Empleado
	 *        
	 * @return  int filas
	 */
	//COMPROBADO Y FUNCIONA
	public int altaEmpleado (Empleado emp){ // inserta a los empleados que se dan de alta, recibe parametro de la clase Empleado
		String cadena="INSERT INTO empleados values ('"+emp.getDni_emple()+"','"+emp.getNombre()+"','"+emp.getF_nac()+"','"+
				emp.getTelf()+"','"+emp.getAlta_club()+"','"+emp.getCuenta()+"','"+emp.getCargo()+"','"+emp.getEmail()+"')";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			int filas=s.executeUpdate(cadena);// Ejecuta la instrucción SQL en el objeto s  y devuelve filas actualizadas
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			int i=e.getErrorCode();
			if (e.getErrorCode()==1062)
				return -1;
			this.cerrar();
			return 0;
		}
	}
	
	/**
	 * Método borrarEmpleado, borrar el registro del empleado indicado identificado por su DNI .
	 * Es utilizado en las clases DarBajaEmpleado (método actionPerformed ) y DarBajaEmpleado2(método actionPerformed).
	 * @param dni
	 *        
	 * @return  int numero de filas
	 */
	//COMPROBADO Y FUNCIONA
	public int borrarEmpleado (String dni){ // borra empleados de parametro DNI
		String cadena="DELETE FROM empleados WHERE Dni_Emple='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();// metodo para obtener s (objeto Statement)
			int filas=s.executeUpdate(cadena); // Ejecuta la instrucción SQL en el objeto s  y devuelve filas borradas
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * Método que Actualiza cuenta de empleado.
	 * Es utilizado en la clase  (método actionPerformed ) .
	 * @param emp
	 *            
	 * @return  int numero de filas
	 */
	//COMPROBADO Y FUNCIONA
	public int actualizarCuentaEmpleado (Empleado emp){// actualiza cuentas de empleados indicados por un parametro DNI de la clase Empleado
		String cadena="UPDATE empleados SET Cuenta_Bancaria='"+emp.getCuenta()+"' WHERE Dni_Emple='"+emp.getDni_emple()+"'";
		try{
			this.abrir();
			s=c.createStatement(); // similar al metodo anterior, devuelve filas o -1 si no lo encuentra
			int filas=s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
	/**
	 * Método buscarDni, busca  empleado del DNI indicado.
	 * Es utilizado en las clases DarAltaEmpleado (método actionPerformed ) y DarAltaEmpleado2(método actionPerformed).
	 * @param dni
	 
	 * @return  int 1, si es correcto o -1 si no lo es.
	 */
	//COMPROBADO Y FUNCIONA
	public int buscarDni (String dni){
		String cadena="SELECT Dni_Emple FROM empleados where Dni_Emple='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement(); // metodo para obtener s (objeto Statement)
			reg=s.executeQuery(cadena);// Con el objeto s, se utiliza el método executeQuery(), devuelve "reg" de tipo ResultSet (tabla)
			while(reg.next()) // mientras queden registros, devuelve 1 
				return 1;
			return 0;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	/**
	 * Método buscarCuenta, obtiene los DNIs  de empleados de una cuenta indicada.
	 * Es utilizado en las clases DarAltaEmpleado (método actionPerformed ) y ModificarCuentaEmpleado(método actionPerformed).
	 * @param cuenta
	 *         
	 * @return  int 1, si la cuenta  o 0 si no
	 */
	public int buscarCuenta (String cuenta){ 
		String cadena="SELECT Dni_Emple FROM empleados where Cuenta_Bancaria='"+cuenta+"'";
		try{
			this.abrir();
			s=c.createStatement();// metodo para obtener s (objeto Statement)
			reg=s.executeQuery(cadena);// Con el objeto s, se utiliza el método executeQuery(), devuelve "reg" de tipo ResultSet (tabla)
			while(reg.next()){// mientras queden registros lee el Resultset, devuelve 1 
				s.close();
				this.cerrar();
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
	/**
	 * Método buscarCargo, obtiene los empleados con cargo "ENTRENADOR" .
	 * Es utilizado en la clase DarAltaEmpleado (método actionPerformed )
	 * @return the int
	 */
	public int buscarCargo (){
		String cadena="SELECT Cargo FROM empleados where Cargo='ENTRENADOR'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);// similar al anterior método
			while(reg.next())
				return 1;
			return 0;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	
}
