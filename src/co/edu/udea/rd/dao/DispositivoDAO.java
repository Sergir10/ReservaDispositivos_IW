package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.exception.MyException;

public interface DispositivoDAO {
	
	public List<Dispositivo> listarDispositivos() throws MyException;
	public Dispositivo obtenerDispositivo(String idDispositivo) throws MyException;
	public void crearDispositivo(Dispositivo dispositivo) throws MyException;
	public void eliminarDispositivo(Dispositivo dispositivo) throws MyException;
	public void modificarDispositivo(Dispositivo dispositivo) throws MyException;
}