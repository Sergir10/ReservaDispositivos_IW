package co.edu.udea.rd.dao;

import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

public interface UsuarioDAO {
	public void crearUsuario(Usuario usuario) throws MyException;
	public void modificarUsuario(Usuario usuario) throws MyException;
	public void eliminar(Usuario usuario) throws MyException;
	public Usuario obtenerUsuario(String username) throws MyException;
}
