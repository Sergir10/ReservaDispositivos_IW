package co.edu.udea.rd.bl;

import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la lógica de negocio del Usuario, aquí se definen los metodos a
 * usar en la lógica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */
public interface UsuarioBL {

	/**
	 * 
	 * Método encargado de validar los datos ingresados para luego realizar
	 * creación de un usuario.
	 * 
	 * 
	 * @param username
	 * @param password
	 * @param passwordConfirmacion
	 * @param nombre
	 * @param apellido
	 * @param tipoDocumento
	 * @param nroDocumento
	 * @param correo
	 * @param idRol
	 * @param telefono
	 * @param celular
	 * @throws MyException
	 */
	public void registrarUsuario(String username, String password, String passwordConfirmacion, String nombre,
			String apellido, String tipoDocumento, String nroDocumento, String correo, int idRol, String telefono,
			String celular) throws MyException;

	/**
	 * 
	 * Método encargado de validar los datos ingresados para luego realizar la
	 * modificación de la información personal de un usuario.
	 * 
	 * @param username
	 * @param password
	 * @param passwordConfirmacion
	 * @param nombre
	 * @param apellido
	 * @param correo
	 * @param telefono
	 * @param celular
	 * @throws MyException
	 */
	public void actualizarInformacionPersonalUsuario(String username, String password, String passwordConfirmacion,
			String nombre, String apellido, String correo, String telefono, String celular) throws MyException;
}
