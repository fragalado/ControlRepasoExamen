package aplicacion.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Persona;
import aplicacion.servicios.ImplFicheros;
import aplicacion.servicios.ImplPersona;
import aplicacion.servicios.ImplPrincipal;
import aplicacion.servicios.InterfazFicheros;
import aplicacion.servicios.InterfazPersona;
import aplicacion.servicios.InterfazPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		// Inicializamos la interfaz principal y persona
		InterfazPrincipal intP = new ImplPrincipal();
		InterfazPersona intPersona = new ImplPersona();
		
		// Inicializamos la interfaz ficheros
		InterfazFicheros intF = new ImplFicheros();
		
		// Lista donde guardaremos los objetos de tipo Persona
		List<Persona> listaBD = new ArrayList<>();
		
		// Leemos el fichero
		List<String> listaFichero = intF.leeFichero("c:\\zDatosPrueba\\ControlRepasoExamenED.txt");
		
		// Si la lista del fichero no está vacía añadiremos a la lista Persona
		if(listaFichero.size() != 0) {
			String[] vAux;
			// Ej linea: nombre;apellidos;dni;fechaNac
			for (String aux : listaFichero) {
				vAux = aux.split(";");
				Persona p = new Persona();
				p.setNombre(vAux[0].strip());
				p.setApellidos(vAux[1].strip());
				p.setDni(vAux[2].strip());
				p.setFechaNac(LocalDate.parse(vAux[3].strip()));
				listaBD.add(p);
			}
		}
		
		// Mostramos el menu
		int opcion=-1;
		do {
			try {
				opcion = intP.Menu();
			} catch (Exception e) {
				System.err.println("** Error: El valor no tiene el formato correcto **");
			}
			
			switch (opcion) {
				case 1:
					// Crear Persona
					try {
						listaBD.add(intPersona.crearPersona());
					} catch (Exception e) {
						System.err.println("** Error: No se ha podido crear persona **");
					}
					break;
				case 2:
					// Eliminar Persona
					try {
						listaBD = intPersona.eliminarPersona(listaBD);
					} catch (Exception e) {
						System.err.println("** Error: No se ha podido eliminar persona **");
					}
					break;
				case 3:
					// Mostrar todas las personas
					try {
						intPersona.mostrarPersonas(listaBD);
					} catch (Exception e) {
						System.err.println("** Error: No se ha podido mostrar todas las personas **");
					}
					break;
				case 4:
					// Mostrar persona por dni
					try {
						intPersona.mostrarPersonaDNI(listaBD);
					} catch (Exception e) {
						System.err.println("** Error: No se ha podido mostrar la persona con el dni introducido **");
					}
					break;
				case 5:
					// Modificar Persona
					break;
				case 0:
					// Salir
					System.out.println("Saliendo...");
					break;
			}
		} while (opcion != 0);
		
		// Actualizamos el fichero
		intF.escribeFicheroSobreescribiendo("c:\\zDatosPrueba\\ControlRepasoExamenED.txt", listaBD);
	}

}
