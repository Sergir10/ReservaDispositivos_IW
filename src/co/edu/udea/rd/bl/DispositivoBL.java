package co.edu.udea.rd.bl;

import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la l�gica de negocio de Dispositivo, aqu� se definen los metodos
 * a usar en la l�gica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
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
}
