package co.edu.udea.rd.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.rd.dto.Prestamo;
import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface que contendrá la definición de los métodos para el manejo de las
 * operaciones sobre los prestamos
 * 
 * @author sergir10
 *
 */
public interface PrestamoDAO {

	/**
	 * Firma del método para listar todos los dispositivos.
	 * 
	 * @return Lista con todos los dispositos prestados.
	 * @throws MyException
	 */
	public List<Prestamo> listarPrestamos() throws MyException;

	/**
	 * Firma del método para obtener un único prestamo.
	 * 
	 * @param prestamoId
	 *            que nos permite buscar el prestamo deseado.
	 * @return prestamo buscado.
	 * @throws MyException
	 */
	public Prestamo obtenerPrestamo(PrestamoId prestamoId) throws MyException;

	
	/**
	 * Firma del método que nos permite crear un prestamo.
	 * @param prestamo que se va a crear en el sistema.
	 * @throws MyException
	 */
	public void crearPrestamo(Prestamo prestamo) throws MyException;

	/**
	 * Firma para modificar un prestamo especifico.
	 * @param prestamo con las mofificaciones. 
	 * @throws MyException
	 */
	public void modificarPrestamo(Prestamo prestamo) throws MyException;

	/**
	 * Firma del metodo que nos permite eliminar un prestamo.
	 * @param prestamo que se desea eliminar.
	 * @throws MyException
	 */
	public void eliminarPrestamo(Prestamo prestamo) throws MyException;

	/**
	 * Firma del metodo que nos permite validar la disponibilidad de un prestamo.
	 * @param prestamo que se va a validar. 
	 * @return true si está disponible or false de lo contrario.
	 * @throws MyException
	 */
	public Boolean validarDisponibilidadPrestamo(Prestamo prestamo) throws MyException;
}
