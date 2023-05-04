package aplicacion.servicios;

import java.util.Scanner;

/**
 * Implementación de la interfaz principal
 * @author frand
 *
 */
public class ImplPrincipal implements InterfazPrincipal {

	@Override
	public int Menu() {
		Scanner sc = new Scanner(System.in);
		
		int opcion;
		do {
			System.out.println("1. Crear Persona");
			System.out.println("2. Eliminar Persona");
			System.out.println("3. Mostrar todas las personas");
			System.out.println("4. Mostrar persona por dni");
			System.out.println("5 Modificar Persona");
			System.out.println("0. Salir");
			System.out.print("Introduce una opción: ");
			
			opcion = sc.nextInt();
			
			if(opcion < 0 || opcion > 5)
				System.err.println("** Error: La opción no está dentro del rango **");
		} while (opcion < 0 || opcion > 5);
		return opcion;
	}

}
