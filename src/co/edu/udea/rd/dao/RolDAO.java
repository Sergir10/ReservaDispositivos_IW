package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.exception.MyException;

/**
 * Interface que contendrá la definición de los métodos para el manejo de las
 * operaciones sobre los roles.
 * 
 * @author sergir10
 *
 */
public interface RolDAO {
	
	/**
	 * Firma del metodo para listar todos los roles.
	 * @return Lista con los roles.
	 * @throws MyException
	 */
	public List<Rol> listarRoles() throws MyException;

	/**
	 * Firma del metodo para buscar un único rol.
	 * @param idRol para buscar.
	 * @return Rol buscado.
	 * @throws MyException
	 */
	public Rol obtenerRol(int idRol) throws MyException;
}
