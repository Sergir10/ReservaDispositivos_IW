package co.edu.udea.rd.dto;

import java.io.Serializable;

/**
 * Clase DTO para transportar los datos de un Dispositivo, esta mappea las
 * columnas a sus respectivos campos en las tablas de la BD.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@SuppressWarnings("serial")
public class Dispositivo implements Serializable {

	/**
	 * Codico unico que nos servira para identifiar un dispositivo.
	 */
	private String idDispositivo;

	/**
	 * Hace referencia al tipo de dispositivo que se tiene, ej: portatil,
	 * smartphone, video ben. Es llave foranea de la entidad "TipoDispositivo"
	 */
	private TipoDispositivo tipoDispositivo;

	/**
	 * Referencia a la cantidad de dispositivos del mismo tipo que se tiene
	 * almacenado. Ej: Dipositivo iphone con un stock de 5... es decir se tienen
	 * 5 unidades de estos smartphone.
	 */
	private int stock;

	/**
	 * Atributo para llevar el control de los dispositivos, funciona como un
	 * contador para saber el numero de dipositivos que se tienen disponible en
	 * un momento dado.
	 */
	private int disponibles;

	/**
	 * Contructor vacio de Dispositivo
	 */
	public Dispositivo() {

	}

	/**
	 * Metodos accesores de los atributos creados previamente.
	 */

	public String getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
}
