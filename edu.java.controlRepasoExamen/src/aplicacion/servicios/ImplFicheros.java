package aplicacion.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Persona;

/**
 * Implementación de la interfaz ficheros
 * @author frand
 *
 */
public class ImplFicheros implements InterfazFicheros {

	@Override
	public List<String> leeFichero(String ruta) {
		
		// Lista que devolveremos con todo el texto del fichero
		List<String> lista = new ArrayList<>();
		
		// Variables para leer el fichero
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea = br.readLine()) != null)
				lista.add(linea);
		} catch (Exception e) {
			System.err.println("** Error: No se ha podido abrir el fichero **");
		} finally {
			// Cerramos el fichero
			try {
				if(fr != null)
					fr.close();
			} catch (Exception e) {
				System.err.println("** Error: No se ha podido cerrar el fichero **");
			}
		}
		
		return lista;
	}

	@Override
	public void escribeFichero(String ruta, String texto) {
		
		// Variables necesarias para escribir en un fichero
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta, true);
			pw = new PrintWriter(fw);
			
			// Escribimos el texto
			pw.println(texto);
			
		} catch (Exception e) {
			System.err.println("** Error: No se ha podido abrir el fichero **");
		} finally {
			// Cerramos el fichero
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e) {
				System.err.println("** Error: No se ha podido cerrar el fichero **");
			}
		}
		
	}

	@Override
	public void escribeFicheroSobreescribiendo(String ruta, List<Persona> listaBD) {
		// Variables necesarias para escribir en un fichero
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			
			// Escribimos los datos de la lista
			for (Persona aux : listaBD) {
				pw.println(aux.getNombre()+";"+aux.getApellidos()+";"+aux.getDni()+";"+aux.getFechaNac());
			}
			
		} catch (Exception e) {
			System.err.println("** Error: No se ha podido abrir el fichero **");
		} finally {
			// Cerramos el fichero
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e) {
				System.err.println("** Error: No se ha podido cerrar el fichero **");
			}
		}
		
	}

}
