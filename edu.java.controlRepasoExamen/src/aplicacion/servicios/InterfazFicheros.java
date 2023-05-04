package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Persona;

/**
 * Interfaz que define los métodos que darán servicio a los ficheros
 * @author frand
 *
 */
public interface InterfazFicheros {
	
	/**
	 * Método que lee el fichero y devuelve una lista con todas las lineas del fichero
	 * @param ruta
	 * @return
	 */
	public List<String> leeFichero(String ruta);
	
	/**
	 * Método que recibe la ruta del fichero y el texto que tenemos que escribir en el
	 * @param ruta
	 * @param texto
	 */
	public void escribeFichero(String ruta, String texto);
	
	/**
	 * Método que recibe la ruta del fichero y la lista de objetos de tipo persona
	 * El método borrará los datos del fichero y escribirá los datos de la lista pasada por parametros
	 * @param ruta
	 * @param listaBD
	 */
	public void escribeFicheroSobreescribiendo(String ruta, List<Persona> listaBD);
}
