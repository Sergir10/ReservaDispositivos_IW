package co.edu.udea.rd.dto;

import java.io.Serializable;

/**
 * Clase DTO para transportar los datos de un Rol, esta sirve para mapear las
 * columnas a su respectiva tabla.
 * 
 * @author Sergio Giraldo - James Garzon - Juan Jose Martinez
 *
 */

@SuppressWarnings("serial")
public class Rol implements Serializable{
	
	/**
	 * Codigo con que se identificara un rol en especifico.
	 */
	private int idRol;
	
	/**
	 * Descripcion del tipo de rol del usuario registrado: Administrador u
	 * Investigador.
	 */
	private String tipoRol;
	
	/**
	 * Metodos accesores de los atributos que se definieron anteriormente.
	 */
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getTipoRol() {
		return tipoRol;
	}
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	
	

}
