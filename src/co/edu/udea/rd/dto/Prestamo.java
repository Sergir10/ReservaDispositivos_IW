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
	 * Fecha en que se realiza la solicitud del prestamo.
	 */
	private Date fechaSolicitud;
	
	/**
	 * Fecha en la que se realizara el prestamo.
	 */
	private Date fechaPrestamo;
	
	/**
	 * Hora inicial en que se realizara el prestamo.
	 */
	private Time horaInicialPrestamo;
	
	/**
	 * Hora limite para devolver el prestamo.
	 */
	private Time horaFinalPrestamo;
	
	/**
	 * Metodos accesores para los atributos definidos previamente.
	 */
	
	public PrestamoId getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(PrestamoId prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Time getHoraInicialPrestamo() {
		return horaInicialPrestamo;
	}
	public void setHoraInicialPrestamo(Time horaInicialPrestamo) {
		this.horaInicialPrestamo = horaInicialPrestamo;
	}
	public Time getHoraFinalPrestamo() {
		return horaFinalPrestamo;
	}
	public void setHoraFinalPrestamo(Time horaFinalPrestamo) {
		this.horaFinalPrestamo = horaFinalPrestamo;
	}
	
	
	
	
}
