package co.edu.udea.rd.bl;

import java.util.List;

import co.edu.udea.rd.dto.Usuario;
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
	 * @param username -> Nombre de usuario con el cual se identificara en el sistema.
	 * @param password -> Contraseña con la cual podra ingresar al sistema.
	 * @param passwordConfirmacion -> Confirmación de la contraseña.
	 * @param nombre -> Nombre del usuario.
	 * @param apellido -> Apellido del usuario.
	 * @param tipoDocumento -> Tipo de documendo que posee el usuario, ej: Cedula, tarjeta identidad...
	 * @param nroDocumento -> Número de identidad del usuario.
	 * @param correo -> Correo electronico del usuario.
	 * @param idRol -> Rol que tendrá el usuario en el sistema: Usuario o Administrador.
	 * @param telefono -> Número del telefono del usuario.
	 * @param celular -> Número del telefono celular del usuario.
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
	 * @param username -> Nombre de usuario con el cual se identifica en el sistema.
	 * @param password -> Nueva contraseña con la cual podrá ingresar al sistema.
	 * @param passwordConfirmacion -> Nueva confirmación del password anterior.
	 * @param nombre -> Nuevo nombre del usuario.
	 * @param apellido -> Nuevo apellido del usuario.
	 * @param correo -> Nuevo correo electronico del usuario.
	 * @param telefono -> Nuevo telefono del usuario
	 * @param celular -> Nuevo telefono celular del usuario
	 * @throws MyException
	 */
	public void actualizarInformacionPersonalUsuario(String username, String password, String passwordConfirmacion,
			String nombre, String apellido, String correo, String telefono, String celular) throws MyException;

	/**
	 * Método encargado de validar las credenciales del usuario dentro del sistema, por medio 
	 * del nombre de usuario y la contraseña.
	 *
	 * @param username -> Nombre de usuario registrado previamente en el sistema.
	 * @param password -> Contraseña del usuario que ha sido registrada previamente.
	 * @return -> Retorna true si el usuario está registrado en el sistema o false de lo contrario.
	 * @throws MyException
	 */
	public boolean loginUsuario(String username, String password) throws MyException;

	public List<Usuario> listarUsuarios() throws MyException;
}


