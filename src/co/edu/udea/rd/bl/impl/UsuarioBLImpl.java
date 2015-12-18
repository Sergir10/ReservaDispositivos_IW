package co.edu.udea.rd.bl.impl;

import co.edu.udea.rd.bl.UsuarioBL;
import co.edu.udea.rd.dao.RolDAO;
import co.edu.udea.rd.dao.UsuarioDAO;
import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;
import co.edu.udea.rd.util.validations.Validaciones;

/**
 * 
 * Clase que implementa la interface de UsuarioBL, aquí se desarrollan los
 * metodos definidos para la lógica de negocio del Usuario
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */
public class UsuarioBLImpl implements UsuarioBL {

	/**
	 * 
	 * Se inyectan los objetos DAO necesarios la clase. En este caso los DAO
	 * Implementado de Usuario y Rol.
	 * 
	 */
	private UsuarioDAO daoUsuario;
	private RolDAO daoRol;

	@Override
	public void registrarUsuario(String username, String password, String passwordConfirmacion, String nombre,
			String apellido, String tipoDocumento, String nroDocumento, String correo, int idRol, String telefono,
			String celular) throws MyException {

		Usuario usuario = new Usuario();
		Rol rol = null;

		// Se validan que los campos obligatorios no sean vacios o nulos.

		if ((username == null) || "".equals(username)) {
			throw new MyException("Nombre de usuario invalido", null);
		}
		if ((password == null) || "".equals(password)) {
			throw new MyException("Contraseña invalida", null);
		}
		if ((passwordConfirmacion == null) || "".equals(passwordConfirmacion)) {
			throw new MyException("Contraseña invalida", null);
		}
		if ((nombre == null) || "".equals(nombre)) {
			throw new MyException("Nombre invalido", null);
		}
		if ((apellido == null) || "".equals(apellido)) {
			throw new MyException("Apellido invalido", null);
		}
		if ((tipoDocumento == null) || "".equals(tipoDocumento)) {
			throw new MyException("Tipo de documento invalido", null);
		}
		if ((nroDocumento == null) || "".equals(nroDocumento)) {
			throw new MyException("Número de documento invalido", null);
		}
		if ((correo == null) || "".equals(correo)) {
			throw new MyException("Correo invalido", null);
		}
		if ("".equals(idRol)) {
			throw new MyException("Rol invalido", null);
		}

		// Se valida que el nombre de usuario no exista todavia.

		if (daoUsuario.obtenerUsuario(username) != null) {
			throw new MyException("Nombre de usuario ya existe", null);
		}

		// Se valida el tamaño minimo de la contraseña.

		if (password.length() < 5) {
			throw new MyException("Contraseña invalida, mínimo 5 caracteres", null);
		}

		// Se valida que la contraseña y confirmación de la contraseña sean
		// iguales.

		if (!password.equals(passwordConfirmacion)) {
			throw new MyException("Contraseñas no coinciden", null);
		}

		// Se valida el formato del correo usando el método isEmail de la clase
		// Validaciones.

		if (!Validaciones.isEmail(correo)) {
			throw new MyException("Correo invalido", null);
		}

		// Se obtiene el rol y se valida que no sea nulo.

		rol = daoRol.obtenerRol(idRol);
		if (rol == null) {
			throw new MyException("Rol invalido", null);
		}

		// Se asignan todos los datos al objeto DTO de Usuario.

		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTipoDocumento(tipoDocumento);
		usuario.setNroDocumento(nroDocumento);
		usuario.setCorreo(correo);
		usuario.setRol(rol);
		usuario.setTelefono(telefono);
		usuario.setCelular(celular);

		// Se hace uso del método crearUsuario de la clase UsuarioDAOImpl, para
		// guardar la información del DTO en la base de datos.

		daoUsuario.crearUsuario(usuario);

	}

	@Override
	public void actualizarInformacionPersonalUsuario(String username, String password, String passwordConfirmacion,
			String nombre, String apellido, String correo, String telefono, String celular) throws MyException {
		Usuario usuario = null;

		// Se validan que los campos obligatorios no sean vacios o nulos.

		if ((username == null) || "".equals(username)) {
			throw new MyException("Nombre de usuario invalido", null);
		}
		if ((password == null) || "".equals(password)) {
			throw new MyException("Contraseña invalida", null);
		}
		if ((passwordConfirmacion == null) || "".equals(passwordConfirmacion)) {
			throw new MyException("Contraseña invalida", null);
		}
		if ((nombre == null) || "".equals(nombre)) {
			throw new MyException("Nombre invalido", null);
		}
		if ((apellido == null) || "".equals(apellido)) {
			throw new MyException("Apellido invalido", null);
		}
		if ((correo == null) || "".equals(correo)) {
			throw new MyException("Correo invalido", null);
		}

		// Se valida que el usuario a modificar si exita.

		usuario = daoUsuario.obtenerUsuario(username);
		if (usuario == null) {
			throw new MyException("Error interno.", null);
		}

		// Se valida el tamaño minimo de la contraseña.

		if (password.length() < 5) {
			throw new MyException("Contraseña invalida, mínimo 5 caracteres", null);
		}

		// Se valida que la contraseña y confirmación de la contraseña sean
		// iguales.

		if (!password.equals(passwordConfirmacion)) {
			throw new MyException("Contraseñas no coinciden", null);
		}

		// Se valida el formato del correo usando el método isEmail de la clase
		// Validaciones.

		if (!Validaciones.isEmail(correo)) {
			throw new MyException("Correo invalido", null);
		}

		// Se asignan los datos que se pueden modificar en el DTO de Usuario

		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setCorreo(correo);
		usuario.setTelefono(telefono);
		usuario.setCelular(celular);

		// Se hace uso del método modificarUsuario de la clase UsuarioDAOImpl,
		// para modificar la información del DTO en la base de datos.

		daoUsuario.modificarUsuario(usuario);
	}

	/*
	 * 
	 * Método accesores para los objetos que se inyectan en esta clase
	 * daoUsuario y daoRol.
	 * 
	 */
	public UsuarioDAO getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(UsuarioDAO daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public RolDAO getDaoRol() {
		return daoRol;
	}

	public void setDaoRol(RolDAO daoRol) {
		this.daoRol = daoRol;
	}

}
