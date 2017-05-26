package bbdd;

import java.sql.SQLException;
import clases.Empleado;

public class BBDD_Empleado extends BBDD_Proyecto{

	public BBDD_Empleado(String bbdd) {
		super(bbdd);
	}

	//COMPROBADO Y FUNCIONA
	public int altaEmpleado (Empleado emp){
		String cadena="INSERT INTO empleados values ('"+emp.getDni_emple()+"','"+emp.getNombre()+"','"+emp.getF_nac()+"','"+
				emp.getTelf()+"','"+emp.getAlta_club()+"','"+emp.getCuenta()+"','"+emp.getCargo()+"','"+emp.getEmail()+"')";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadena);
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
	
	//COMPROBADO Y FUNCIONA
	public int borrarEmpleado (String dni){
		String cadena="DELETE FROM empleados WHERE Dni_Emple='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
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
	
	//COMPROBADO Y FUNCIONA
	public int actualizarCuentaEmpleado (Empleado emp){
		String cadena="UPDATE empleados SET Cuenta_Bancaria='"+emp.getCuenta()+"' WHERE Dni_Emple='"+emp.getDni_emple()+"'";
		try{
			this.abrir();
			s=c.createStatement();
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
	
	
	//COMPROBADO Y FUNCIONA
	public int buscarDni (String dni){
		String cadena="SELECT Dni_Emple FROM empleados where Dni_Emple='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while(reg.next())
				return 1;
			return 0;
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
	
	public int buscarCuenta (String cuenta){
		String cadena="SELECT Dni_Emple FROM empleados where Cuenta_Bancaria='"+cuenta+"'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while(reg.next()){
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
	
	
	public int buscarCargo (){
		String cadena="SELECT Cargo FROM empleados where Cargo='ENTRENADOR'";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadena);
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
