package co.edu.udea.rd.bl;

import java.util.List;

import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface de la l�gica de negocio del Usuario, aqu� se definen los metodos a
 * usar en la l�gica de negocio de los usuarios.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */
public interface UsuarioBL {

	/**
	 * 
	 * M�todo encargado de validar los datos ingresados para luego realizar
	 * creaci�n de un usuario.
	 * 
	 * 
	 * @param username -> Nombre de usuario con el cual se identificara en el sistema.
	 * @param password -> Contrase�a con la cual podra ingresar al sistema.
	 * @param passwordConfirmacion -> Confirmaci�n de la contrase�a.
	 * @param nombre -> Nombre del usuario.
	 * @param apellido -> Apellido del usuario.
	 * @param tipoDocumento -> Tipo de documendo que posee el usuario, ej: Cedula, tarjeta identidad...
	 * @param nroDocumento -> N�mero de identidad del usuario.
	 * @param correo -> Correo electronico del usuario.
	 * @param idRol -> Rol que tendr� el usuario en el sistema: Usuario o Administrador.
	 * @param telefono -> N�mero del telefono del usuario.
	 * @param celular -> N�mero del telefono celular del usuario.
	 * @throws MyException
	 */
	public void registrarUsuario(String username, String password, String passwordConfirmacion, String nombre,
			String apellido, String tipoDocumento, String nroDocumento, String correo, int idRol, String telefono,
			String celular) throws MyException;

	/**
	 * 
	 * M�todo encargado de validar los datos ingresados para luego realizar la
	 * modificaci�n de la informaci�n personal de un usuario.
	 * 
	 * @param username -> Nombre de usuario con el cual se identifica en el sistema.
	 * @param password -> Nueva contrase�a con la cual podr� ingresar al sistema.
	 * @param passwordConfirmacion -> Nueva confirmaci�n del password anterior.
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
	 * M�todo encargado de validar las credenciales del usuario dentro del sistema, por medio 
	 * del nombre de usuario y la contrase�a.
	 *
	 * @param username -> Nombre de usuario registrado previamente en el sistema.
	 * @param password -> Contrase�a del usuario que ha sido registrada previamente.
	 * @return -> Retorna true si el usuario est� registrado en el sistema o false de lo contrario.
	 * @throws MyException
	 */
	public boolean loginUsuario(String username, String password) throws MyException;

	public List<Usuario> listarUsuarios() throws MyException;
}


