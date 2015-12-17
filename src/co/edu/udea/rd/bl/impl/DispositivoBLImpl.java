package co.edu.udea.rd.bl.impl;

import co.edu.udea.rd.bl.DispositivoBL;
import co.edu.udea.rd.dao.impl.DispositivoDAOImpl;
import co.edu.udea.rd.dao.impl.TipoDispositivoDAOImpl;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

public class DispositivoBLImpl implements DispositivoBL {

	private DispositivoDAOImpl daoDispositivo;
	private TipoDispositivoDAOImpl daoTipoDispositivo;

	@Override
	public void registrarDispositivo(String idDispositivo, int idTipoDispositivo, int stock, int disponibles)
			throws MyException {
		Dispositivo dispositivo = new Dispositivo();
		TipoDispositivo tipoDispositivo = null;

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

		if (daoDispositivo.obtenerDispositivo(idDispositivo) != null) {
			throw new MyException("Dispositivo ya existe", null);
		}
		tipoDispositivo = daoTipoDispositivo.obtenerTipoDeDispositivo(idTipoDispositivo);
		if (tipoDispositivo == null) {
			throw new MyException("Tipo de dispositivo invalido", null);
		}
		if (disponibles > stock) {
			throw new MyException("No puede haber más disponibilidad que stock", null);
		}
		
		dispositivo.setIdDispositivo(idDispositivo);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		dispositivo.setStock(stock);
		dispositivo.setDisponibles(disponibles);
		
		daoDispositivo.crearDispositivo(dispositivo);
	}

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
