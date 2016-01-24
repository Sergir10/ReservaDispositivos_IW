package co.edu.udea.rd.dao;

import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface que contendra la definicion de los metodos para el manejo de las 
 * operaciones sobre los usuarios.
 * @author sergir10
 *
 */
public interface UsuarioDAO {
	
	/**
	 * Firma del metodo que nos permite crear un usuario,.
	 * @param usuario que se va a crear.
	 * @throws MyException
	 */
	public void crearUsuario(Usuario usuario) throws MyException;
	
	/**
	 * Firma del metodo que nos permite modificar un usuario.
	 * @param usuario que se va a modificar.
	 * @throws MyException
	 */
	public void modificarUsuario(Usuario usuario) throws MyException;
	
	/**
	 * Firma del metodo que nos permite eliminar un usuario.
	 * @param usuario que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminar(Usuario usuario) throws MyException;
	
	/**
	 * Firma del metodo que nos permite obtener un usuario especifico.
	 * @param username para buscar el usuario.
	 * @return el usuario buscado.
	 * @throws MyException
	 */
	public Usuario obtenerUsuario(String username) throws MyException;
}
