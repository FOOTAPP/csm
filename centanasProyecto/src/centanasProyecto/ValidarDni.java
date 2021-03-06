package centanasProyecto;

/**
 * Clase ValidarDni.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class ValidarDni {
	/**
	Clase que permite validar un DNI.  
	Se crea un objeto del tipo ValidadorDNI y se le pasa un String a validar.
	@return true si DNI es correcto.
	Desarrollado por Manuel Mato.
	*/
	 
	    private String dni;
	 
	        /**
			 * Costructor ValidarDni.
			 *
			 * @param dni
			 *            
			 */
        	public ValidarDni(String dni) {
	            this.dni = dni;
	        }
	 
	     
	    /**
		 * M�todo Validar.
		 *  Es utilizado en el m�todo actionPerformed(ActionEvent) de las clases  DarAltaEmpleado, DarAltaEmpleado, DarAltaJugador,DarAltaJugador.
		 * @return true, si es correcto
		 */
    	public boolean validar() {
	 
	         
	        String letraMayuscula = ""; //Guardaremos la letra introducida en formato may�scula
	             
	        // Aqu� excluimos cadenas distintas a 9 caracteres que debe tener un dni y tambi�n si el �ltimo caracter no es una letra
	        if(dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false ) {
	            return false;
	        }
	 
	         
	        // Al superar la primera restricci�n, la letra la pasamos a may�scula
	        letraMayuscula = (this.dni.substring(8)).toUpperCase();
	 
	        // Por �ltimo validamos que s�lo tengo 8 d�gitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuaci�n
	        // Llamamos a los m�todos privados de la clase soloNumeros() y letraDNI()
	        if(soloNumeros() == true && letraDNI().equals(letraMayuscula)) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	 
	        /**
			 * M�todo Solo numeros.
			 *
			 * @return true, si es correcto
			 */
        	private boolean soloNumeros() {
	 
	            int i, j = 0;
	            String numero = ""; // Es el n�mero que se comprueba uno a uno por si hay alguna letra entre los 8 primeros d�gitos
	            String miDNI = ""; // Guardamos en una cadena los n�meros para despu�s calcular la letra
	            String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
	            try{
	            Integer.parseInt(this.dni.substring(0, 8));
	            }
	            catch(NumberFormatException e){
	            	return false;
	            }
	            return true;
	           /* for(i = 0; i < this.dni.length() - 1; i++) {
	                numero = this.dni.substring(i, i+1);
	 
	                for(j = 0; j < unoNueve.length; j++) {
	                    if(numero.equals(unoNueve[j])) {
	                        miDNI += unoNueve[j];
	                    }
	                }
	            }
	 
	            if(miDNI.length() != 8) {
	                return false;
	            }
	            else {
	                return true;
	            }*/
	        }
	 
	        /**
			 * M�todo letraDNI .
			 *
			 * @return string
			 */
        	private String letraDNI() {
	        // El m�todo es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella
	 
	        // pasar miNumero a integer
	        int miDNI = Integer.parseInt(this.dni.substring(0,8));
	        int resto = 0;
	        String miLetra = "";
	        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
	 
	        resto = miDNI % 23;
	 
	        miLetra = asignacionLetra[resto];
	 
	        return miLetra;
	    }
	}

