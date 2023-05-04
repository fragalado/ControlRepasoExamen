package aplicacion.entidades;

import java.time.LocalDate;

public class Persona {
	// Atributos
	
	private String nombre = "aaaaaaaaaaaaaaa";
	private String apellidos = "aaaaaaaaaaaaaaa";
	private String dni = "aaaaaaaaaaaaaaa";
	private LocalDate fechaNac = LocalDate.of(1111, 1, 1); // Fecha de nacimiento
	
	// Constructores -> Constructor vacío
	
	// Getter y Setter
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "[nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechaNac=" + fechaNac
				+ "]";
	}	
}
