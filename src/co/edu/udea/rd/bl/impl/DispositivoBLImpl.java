package co.edu.udea.rd.bl.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udea.rd.bl.DispositivoBL;
import co.edu.udea.rd.dao.DispositivoDAO;
import co.edu.udea.rd.dao.impl.DispositivoDAOImpl;
import co.edu.udea.rd.dao.impl.TipoDispositivoDAOImpl;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * 
 * Clase que implementa la interface de DispositivoBL, aquí se desarrollan los
 * metodos definidos para la lógica de negocio del Dispositivo.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */
public class DispositivoBLImpl implements DispositivoBL {

	/**
	 * 
	 * Se inyectan los objetos DAO necesarios la clase. En este caso los DAO
	 * Implementado de Dispositio y TipoDispositivo.
	 * 
	 */
	private DispositivoDAOImpl daoDispositivo;
	private TipoDispositivoDAOImpl daoTipoDispositivo;

	@Override
	public void registrarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException {

		Dispositivo dispositivo = new Dispositivo();
		TipoDispositivo tipoDispositivo = null;

		// Se validan que los campos obligatorios no sean vacios o nulos.

		if ((idDispositivo == null) || "".equals(idDispositivo)) {
			throw new MyException("Id del dispositivo invalido", null);
		}
		if ("".equals(idTipoDispositivo)) {
			throw new MyException("Id del tipo de dispositivo invalido", null);
		}
		if ("".equals(stock)) {
			throw new MyException("Stock invalido", null);
		}
		if ("".equals(disponibles)) {
			throw new MyException("Cantidad disponible invalida", null);
		}

		// Se valida que el idDispositvo no este asociado a otro dispositivo.

		if (daoDispositivo.obtenerDispositivo(idDispositivo) != null) {
			throw new MyException("Dispositivo ya existe", null);
		}

		// Se obtiene el tipo de dispositivo y se valida que no sea nulo.

		tipoDispositivo = daoTipoDispositivo.obtenerTipoDeDispositivo(idTipoDispositivo);
		if (tipoDispositivo == null) {
			throw new MyException("Tipo de dispositivo invalido", null);
		}

		// Se valida que el stock no sea menor que la cantidad disponible de un
		// dispositivo.

		if (disponibles > stock) {
			throw new MyException("No puede haber más disponibilidad que stock", null);
		}

		// Se asignan los datos al objeto DTO de Dispositivo.

		dispositivo.setIdDispositivo(idDispositivo);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		dispositivo.setStock(stock);
		dispositivo.setDisponibles(disponibles);

		// Se hace uso del método crearDispositivo de la clase
		// DispositivoDAOImpl, para guardar la información del DTO en la base de
		// datos.

		daoDispositivo.crearDispositivo(dispositivo);
	}
	
	@Override
	public List<Dispositivo> listarDispositivos() throws MyException {
		
		List<Dispositivo> dispositivos = new ArrayList();
		List<Dispositivo> dispositivosDisponibles = new ArrayList();
		dispositivos = daoDispositivo.listarDispositivos();
		
		for (Iterator iterator = dispositivos.iterator(); iterator.hasNext();) {
			Dispositivo dispositivo = (Dispositivo) iterator.next();
			
			//se seleccionan los dispositivos que una disponibilidad mayor a cero
			if (dispositivo.getDisponibles()>0) {
				dispositivosDisponibles.add(dispositivo);
			}
		}
		
		return dispositivosDisponibles;

	}
	
	@Override
	public void modificarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException {

		Dispositivo dispositivo = new Dispositivo();
		TipoDispositivo tipoDispositivo = null;

		// Se validan que los campos obligatorios no sean vacios o nulos.

		if ((idDispositivo == null) || "".equals(idDispositivo)) {
			throw new MyException("Id del dispositivo invalido", null);
		}
		if ("".equals(idTipoDispositivo)) {
			throw new MyException("Id del tipo de dispositivo invalido", null);
		}
		if ("".equals(stock)) {
			throw new MyException("Stock invalido", null);
		}
		if ("".equals(disponibles)) {
			throw new MyException("Cantidad disponible invalida", null);
		}

		// Se valida que el idDispositvo no este asociado a otro dispositivo.

		if (daoDispositivo.obtenerDispositivo(idDispositivo) == null) {
			throw new MyException("Dispositivo no existe", null);
		}

		// Se obtiene el tipo de dispositivo y se valida que no sea nulo.

		tipoDispositivo = daoTipoDispositivo.obtenerTipoDeDispositivo(idTipoDispositivo);
		if (tipoDispositivo == null) {
			throw new MyException("Tipo de dispositivo invalido", null);
		}

		// Se valida que el stock no sea menor que la cantidad disponible de un
		// dispositivo.

		if (disponibles > stock) {
			throw new MyException("No puede haber más disponibilidad que stock", null);
		}

		// Se asignan los datos al objeto DTO de Dispositivo.

		dispositivo.setIdDispositivo(idDispositivo);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		dispositivo.setStock(stock);
		dispositivo.setDisponibles(disponibles);

		// Se hace uso del método crearDispositivo de la clase
		// DispositivoDAOImpl, para guardar la información del DTO en la base de
		// datos.

		daoDispositivo.modificarDispositivo(dispositivo);
		
	}
	
	@Override
	public void eliminarDispositivo(String idDispositivo) throws MyException {
		Dispositivo dispositivo = null;
		
		if (idDispositivo.equals("") || idDispositivo== null) {
			throw new MyException("Id del dispositivo invalido", null);
		}
		dispositivo = daoDispositivo.obtenerDispositivo(idDispositivo);
		daoDispositivo.eliminarDispositivo(dispositivo);
		
	}



	/*
	 * 
	 * Método accesores para los objetos que se inyectan en esta clase
	 * daoDispositivo y daoTipoDispositivo.
	 * 
	 */

	public DispositivoDAOImpl getDaoDispositivo() {
		return daoDispositivo;
	}

	public void setDaoDispositivo(DispositivoDAOImpl daoDispositivo) {
		this.daoDispositivo = daoDispositivo;
	}

	public TipoDispositivoDAOImpl getDaoTipoDispositivo() {
		return daoTipoDispositivo;
	}

	public void setDaoTipoDispositivo(TipoDispositivoDAOImpl daoTipoDispositivo) {
		this.daoTipoDispositivo = daoTipoDispositivo;
	}





}
