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

	private UsuarioDAO daoUsuario;
	private RolDAO daoRol;

	@Override
	public void registrarUsuario(String username, String password, String passwordConfirmacion, String nombre,
			String apellido, String tipoDocumento, String nroDocumento, String correo, int idRol, String telefono,
			String celular) throws MyException {

		Usuario usuario = new Usuario();
		Rol rol = null;

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

		if (daoUsuario.obtenerUsuario(username) != null) {
			throw new MyException("Nombre de usuario ya existe", null);
		}
		if (password.length() < 5) {
			throw new MyException("Contraseña invalida, mínimo 5 caracteres", null);
		}
		if (!password.equals(passwordConfirmacion)) {
			throw new MyException("Contraseñas no coinciden", null);
		}
		if (!Validaciones.isEmail(correo)) {
			throw new MyException("Correo invalido", null);
		}
		rol = daoRol.obtenerRol(idRol);
		if (rol == null) {
			throw new MyException("Rol invalido", null);
		}

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

		daoUsuario.crearUsuario(usuario);

	}

	@Override
	public void actualizarInformacionPersonalUsuario(String username, String password, String passwordConfirmacion,
			String nombre, String apellido, String correo, String telefono, String celular) throws MyException {
		Usuario usuario = null;

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
		usuario = daoUsuario.obtenerUsuario(username);
		if (usuario == null) {
			throw new MyException("Error interno.", null);
		}
		if (password.length() < 5) {
			throw new MyException("Contraseña invalida, mínimo 5 caracteres", null);
		}
		if (!password.equals(passwordConfirmacion)) {
			throw new MyException("Contraseñas no coinciden", null);
		}
		if (!Validaciones.isEmail(correo)) {
			throw new MyException("Correo invalido", null);
		}

		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setCorreo(correo);
		usuario.setTelefono(telefono);
		usuario.setCelular(celular);

		daoUsuario.modificarUsuario(usuario);
	}

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
