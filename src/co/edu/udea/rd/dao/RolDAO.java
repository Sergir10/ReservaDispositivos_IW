package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.exception.MyException;

public interface RolDAO {
	public List<Rol> listarRoles() throws MyException;
}
