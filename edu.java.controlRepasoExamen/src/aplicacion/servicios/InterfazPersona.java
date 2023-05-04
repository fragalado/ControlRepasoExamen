package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Persona;

/**
 * Interfaz que define los métodos que darán servicio a persona
 * @author frand
 *
 */
public interface InterfazPersona {
	
	/**
	 * Método que crea un objeto de tipo Persona y lo devuelve
	 * @return
	 */
	public Persona crearPersona();
	
	/**
	 * Método que elimina un objeto de tipo Persona por el dni
	 * @param listaBD
	 */
	public List<Persona> eliminarPersona(List<Persona> listaBD);
	
	/**
	 * Método que muestra por consola todos los objetos Persona
	 * @param listaBD
	 */
	public void mostrarPersonas(List<Persona> listaBD);
	
	/**
	 * Método que muestra Persona por dni
	 * @param listaBD
	 */
	public void mostrarPersonaDNI(List<Persona> listaBD);
	
	/**
	 * Método que modifica un objeto Persona segun el DNI
	 * @param listaBD
	 * @return
	 */
	public List<Persona> modificarPersona(List<Persona> listaBD);
}
