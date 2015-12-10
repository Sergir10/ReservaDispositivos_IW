package co.edu.udea.rd.dao;

import java.util.List;

import co.edu.udea.rd.dto.Prestamo;
import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.exception.MyException;

public interface PrestamoDAO {
	public List<Prestamo> listarPrestamos() throws MyException;
	public Prestamo obtenerPrestamo(PrestamoId prestamoId) throws MyException;
	public void crearPrestamo(Prestamo prestamo) throws MyException;
	public void modificarPrestamo(Prestamo prestamo) throws MyException;
	public void eliminarPrestasmo(Prestamo prestamo) throws MyException;	
}
