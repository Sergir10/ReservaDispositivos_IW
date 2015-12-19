package co.edu.udea.rd.bl;

import java.util.List;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la l�gica de negocio de Dispositivo, aqu� se definen los metodos
 * a usar en la l�gica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James Garz�n - Juan Jos� Martinez.
 *
 */
public interface DispositivoBL {

	/**
	 * 
	 * M�todo encargado de validar los datos ingresados para luego realizar
	 * creaci�n de un dispositivo.
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
	 * M�todo encargado de validar los datos ingresados para luego realizar
	 * modificaci�n de un dispositivo.
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
	 * M�todo encargado de listar todos los dispositivos 
	 * que est�n disponibles.
	 * 
	 * @throws MyException
	 */
	public List<Dispositivo> listarDispositivos() throws MyException;
	
	/**
	 * 
	 * M�todo encargado de eliminar un dispositivo
	 *
	 * @param idDispositivo
	 * @throws MyException
	 * 
	 */
	public void eliminarDispositivo(String idDispositivo) throws MyException;
}
