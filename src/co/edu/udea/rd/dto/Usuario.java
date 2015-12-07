package co.edu.udea.rd.dto;

import java.io.Serializable;

/**
 * Clase DTO para transportar los datos de Usuario, esta sirve adem�s para
 * mapear las columnas a su respectiva tabla
 * 
 * @author Sergio Giraldo - James Garzon - Juan Jose Martinez
 *
 */

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	
	/**
	 * Nombre de usuario con el que se identificara en el sistema.
	 */
	private String username;
	
	/**
	 * Password o contraseña requerida para identificarse en el sistema.
	 */
	private String password;
	
	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Apellido del usuario.
	 */
	private String apellido;
	
	/**
	 * Tipo de documento del usuario, es decir: cedula ciudadania local o extranjera, 
	 * documento de identidad... etc.
	 */
	private String tipoDocumento;
	
	/**
	 * Numero del documento de identidad.
	 */
	private String nroDocumento;
	
	/**
	 * Correo electronico del usuario.
	 */
	private String correo;
	
	/**
	 * Clave foranea a la tabla Rol para identificar si es un administrador o un
	 * investigador
	 */
	private Rol rol;
	
	/**
	 * Numero de telefono fijo del lugar de residencia o trabajo del usuario.
	 */
	private String telefono;
	
	/**
	 * Numero de celular del usuario.
	 */
	private String celular;
	
	
	/**
	 * Metodos accesores para los atributos definidos anteriormente.
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
