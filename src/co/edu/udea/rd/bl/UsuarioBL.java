package co.edu.udea.rd.bl;

import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la l�gica de negocio del Usuario, aqu� se definen los metodos a
 * usar en la log�ca de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

public interface UsuarioBL {

	/**
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
