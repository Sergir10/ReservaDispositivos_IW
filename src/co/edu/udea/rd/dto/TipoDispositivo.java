package co.edu.udea.rd.dto;

import java.io.Serializable;

/**
 * Clase DTO para transportar los datos de TipoDispositivo, esta permite mapear
 * las columnas a su respectiva tabla.
 * 
 * @author Sergio Giraldo - James Garzon - Juan Jose Martinez
 *
 */

@SuppressWarnings("serial")
public class TipoDispositivo implements Serializable {

	/**
	 * Codigo que identifica al tipo de dispositivo.
	 */
	private int idTipoDispositivo;

	/**
	 * Que tipo de dispositivo se va a prestar/almacenar, por ejemplo: celular,
	 * portatil, etc...
	 */
	private String tipoDispositivo;

	/**
	 * Descripcion del tipo de dispostivo, por ejemplo: Si es un celular, copiar
	 * las caracteristicas como ram, procesador, camara, lectores, etc...
	 */
	private String descripcion;

	/**
	 * Metodos accesores para los atributos definidos anteriormente.
	 */

	public TipoDispositivo() {
	}

	public int getIdTipoDispositivo() {
		return idTipoDispositivo;
	}

	public void setIdTipoDispositivo(int idTipoDispositivo) {
		this.idTipoDispositivo = idTipoDispositivo;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
