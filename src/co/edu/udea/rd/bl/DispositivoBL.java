package co.edu.udea.rd.bl;

import co.edu.udea.rd.exception.MyException;

public interface DispositivoBL {
	public void registrarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException;
}
