package aplicacion.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Persona;

/**
 * Implementación de la interfaz persona
 * @author frand
 *
 */
public class ImplPersona implements InterfazPersona {

	@Override
	public Persona crearPersona() {
		// nombre, apellidos, dni, fechaNac
		// Scanner para leer
		Scanner sc = new Scanner(System.in);
		// Objeto Persona que devolveremos
		Persona p = new Persona();
		
		// Pedimos el nombre
		System.out.print("Introduzca el nombre de la persona: ");
		p.setNombre(sc.nextLine());
		
		// Pedimos los apellidos
		System.out.print("Introduzca los apellidos de la persona: ");
		p.setApellidos(sc.nextLine());
		
		// Pedimos el dni
		System.out.print("Introduzca el dni de la persona: ");
		p.setDni(sc.nextLine());
		
		// Pedimos la fecha de nacimiento
		System.out.print("Introduzca la fecha de nacimiento de la persona [0000-00-00]: ");
		p.setFechaNac(LocalDate.parse(sc.nextLine()));
		
		// Escribimos la persona en el fichero
		InterfazFicheros intF = new ImplFicheros();
		String escribir = p.getNombre()+";"+p.getApellidos()+";"+p.getDni()+";"+p.getFechaNac();
		intF.escribeFichero("c:\\zDatosPrueba\\ControlRepasoExamenED.txt", escribir);
		
		// Devolvemos el objeto Persona
		return p;
	}

	@Override
	public List<Persona> eliminarPersona(List<Persona> listaBD) {
		
		// Pedimos el dni y obtenemos la persona
		Persona p = buscaPersonaPorDni(listaBD);
		
		if(p != null)
			listaBD.remove(p);
		
		// Devolvemos la lista
		return listaBD;
		
	}

	@Override
	public void mostrarPersonas(List<Persona> listaBD) {
		for (Persona aux : listaBD) {
			System.out.println(aux.toString());
		}
		
	}

	@Override
	public void mostrarPersonaDNI(List<Persona> listaBD) {
		
		// Pedimos el dni y obtenemos la persona
		Persona p = buscaPersonaPorDni(listaBD);
		
		if(p != null)
			System.out.println(p.toString());
		
	}

	@Override
	public List<Persona> modificarPersona(List<Persona> listaBD) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Método que busca el objeto Persona que contenga el dni pedido y lo devuelve
	 * @param listaBD
	 * @return
	 */
	private Persona buscaPersonaPorDni(List<Persona> listaBD) {
		// Scanner para leer
		Scanner sc = new Scanner(System.in);
		
		// Declaramos un objeto Persona
		Persona p = null;
		
		// Pedimos el dni y buscamos en la lista el dni
		System.out.print("Introduzca el dni de la persona: ");
		String dniPersona = sc.next();
		
		boolean esEncontrado = false;
		for (Persona aux : listaBD) {
			if(aux.getDni().equals(dniPersona)) {
				p = aux;
				esEncontrado=true;
				break;
			}
		}
		
		// Si no se ha encontrado mostramos mensaje de error
		if(!esEncontrado)
			System.err.println("** Error: No existe persona con el dni introducido **");
		
		// Devolvemos
		return p;
	}

}
