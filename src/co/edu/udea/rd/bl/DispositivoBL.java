package co.edu.udea.rd.bl;

import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la lógica de negocio de Dispositivo, aquí se definen los metodos
 * a usar en la lógica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
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
}
