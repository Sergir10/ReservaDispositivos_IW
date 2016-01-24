package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface que contendrá la definición de los métodos para el manejo de las
 * operaciones sobre los dispositivos.
 * 
 * @author sergir10
 *
 */
public interface DispositivoDAO {

	/**
	 * Firma del método que nos permite obtener todos los dispositivos.
	 * 
	 * @return Lista con los dispositivos.
	 * @throws MyException
	 */
	public List<Dispositivo> listarDispositivos() throws MyException;

	/**
	 * Firma del método que nos permite obtener un único dispositivo.
	 * 
	 * @param idDispositivo
	 *            con el cual se realizará la búsqueda.
	 * @return Retorna el dispositivo buscado.
	 * @throws MyException
	 */
	public Dispositivo obtenerDispositivo(String idDispositivo) throws MyException;

	/**
	 * Firma del método que nos permite crear un nuevo dispositivo.
	 * 
	 * @param dispositivo
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearDispositivo(Dispositivo dispositivo) throws MyException;

	/**
	 * Firma del método que nos permite eliminar un dispositivo de la base de datos. 
	 * @param dispositivo que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarDispositivo(Dispositivo dispositivo) throws MyException;

	/**
	 * FIrma del metodo para modificar un dispositivo existente.
	 * @param dispositivo que se desea modificar.
	 * @throws MyException
	 */
	public void modificarDispositivo(Dispositivo dispositivo) throws MyException;
}