package co.edu.udea.rd.dao;


import java.util.List;

import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

public interface TipoDispositivoDAO {
	public List<TipoDispositivo> listarTiposDeDispositivos() throws MyException;
	public TipoDispositivo obtenerTipoDeDispositivo(int idTipoDispositivo) throws MyException;
}
