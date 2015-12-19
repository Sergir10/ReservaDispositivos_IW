package co.edu.udea.rd.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Clase DTO para transportar los datos de un Prestamo, esta mappea 
 * las columnas a sus respectivos campos en la tablas de la BD.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@SuppressWarnings("serial")
public class Prestamo implements Serializable{

	/**
	 * Atributo de tipo PrestamoId que contiene la informacion necesaria para
	 * identificar un prestamo. Nos sirve de clave primaria para la DB.
	 */
	private PrestamoId prestamoId;
	
	/**
	 * Estado de la solicitud del prestamo (Pendiente, Prestado, Rechazado o Terminado).
	 */
	private String estado;
	
	/**
	 * Fecha en que se realiza la solicitud del prestamo.
	 */
	private Date fechaSolicitud;
	
	/**
	 * Fecha y hora en la que se realizara el prestamo.
	 */
	private Date fechaInicialPrestamo;
	
	/**
	 * Fecha y hora en la que se termina el prestamo.
	 */
	private Date fechaFinalPrestamo;
	
	
	/**
	 * Metodos accesores para los atributos definidos previamente.
	 */
	
	public PrestamoId getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(PrestamoId prestamoId) {
		this.prestamoId = prestamoId;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaInicialPrestamo() {
		return fechaInicialPrestamo;
	}
	public void setFechaInicialPrestamo(Date fechaPrestamo) {
		this.fechaInicialPrestamo = fechaPrestamo;
	}
	public Date getFechaFinalPrestamo() {
		return fechaFinalPrestamo;
	}
	public void setFechaFinalPrestamo(Date fechaFinalPrestamo) {
		this.fechaFinalPrestamo = fechaFinalPrestamo;
	}
	
	
	
	
}
