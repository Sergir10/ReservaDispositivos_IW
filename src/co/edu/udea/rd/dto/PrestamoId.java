package co.edu.udea.rd.dto;

import java.io.Serializable;

/**
 * Clase DTO para representar la clave primaria de la tabla Prestamo, nos
 * facilita la tarea a la hora de mapear un Prestamo.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@SuppressWarnings("serial")
public class PrestamoId implements Serializable{

	/**
	 * Atributo que nos sirve para referenciar la clave foranea a la clase Dispositivo.
	 */
	private Dispositivo dispositivo;
	
	/**
	 * Atributo que nos sirve para referenciar la clave foranea a la clase .
	 */
	private Usuario usuario;
	
	/**
	 * Metodos accesores de los atributos anteriormente definidos.
	 */

	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
