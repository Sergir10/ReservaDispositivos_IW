package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * interface que contendra la definicion de los metodos para el manejo de las
 * operaciones sobre los tipos de dipositivos.
 * 
 * @author sergir10
 *
 */
public interface TipoDispositivoDAO {

	/**
	 * Firma del metodo que nos permite listar todos los tipos de dispositivos
	 * 
	 * @return Lista con los tipos de dispositivos.
	 * @throws MyException
	 */
	public List<TipoDispositivo> listarTiposDeDispositivos() throws MyException;

	/**
	 * Firma del metodo que me permite obtener un tipo de dipositivo especifico.
	 * @param idTipoDispositivo que se va a buscar.
	 * @return  el tipo de dispositivo buscado.
	 * @throws MyException
	 */
	public TipoDispositivo obtenerTipoDeDispositivo(int idTipoDispositivo) throws MyException;
}
