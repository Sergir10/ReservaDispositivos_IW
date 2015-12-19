package co.edu.udea.rd.bl;

import java.util.Date;

import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.exception.MyException;

public interface PrestamoBL {
	
	/**
	 * Método que nos sirve para aprobar o rechazar una solicitud de préstamo, 
	 * mediante la moficación del estado de este; es decir, si el préstamo se 
	 * aprobó el estado será prestado, sino rechazado.
	 * @param estado Nuevo estado del prestamo.
	 * @throws MyException
	 */
	public void actualizarEstadoPrestamo(String username, String idDispositivo, String estado) throws MyException;
	
	/**
	 * Mètodo que nos sirve para crear la solicitud de prestamo de dispositivos por parte de un usuario.
	 * @param dipositivo -> Nombre dispositivo a solicitar el prestmao.
	 * @param usuario -> Nombre del usuario que solocita el prestamo.
	 * @param fechaSolicitud -> Fecha en que se realiza la solicitud.
	 * @param fechaInicialPrestamo -> Fecha para la cual se pide la solicitud de prestamo.
	 * @param fechaFinalPrestamo -> Fecha en la cual terminaria la solicitud del prestamo.
	 * @throws MyException
	 */
	public void solicitarPrestamo(String idDipositivo, String username, Date fechaInicialPrestamo, Date fechaFinalPrestamo) throws MyException;
}
