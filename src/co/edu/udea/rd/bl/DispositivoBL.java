package co.edu.udea.rd.bl;

import java.util.List;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la lógica de negocio de Dispositivo, aquí se definen los metodos
 * a usar en la lógica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */
public interface DispositivoBL {

	/**
	 * 
	 * Método encargado de validar los datos ingresados para luego realizar
	 * creación de un dispositivo.
	 * 
	 * @param idDispositivo
	 * @param idTipoDispositivo
	 * @param stock
	 * @param disponibles
	 * @throws MyException
	 */
	public void registrarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException;
	
	/**
	 * 
	 * Método encargado de validar los datos ingresados para luego realizar
	 * modificación de un dispositivo.
	 * 
	 * @param idDispositivo
	 * @param idTipoDispositivo
	 * @param stock
	 * @param disponibles
	 * @throws MyException
	 */
	public void modificarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException;
	
	
	/**
	 * 
	 * Método encargado de listar todos los dispositivos 
	 * que están disponibles.
	 * 
	 * @throws MyException
	 */
	public List<Dispositivo> listarDispositivos() throws MyException;
	
	/**
	 * 
	 * Método encargado de eliminar un dispositivo
	 *
	 * @param idDispositivo
	 * @throws MyException
	 * 
	 */
	public void eliminarDispositivo(String idDispositivo) throws MyException;
}
