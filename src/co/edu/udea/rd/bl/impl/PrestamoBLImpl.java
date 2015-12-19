package co.edu.udea.rd.bl.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import co.edu.udea.rd.bl.PrestamoBL;
import co.edu.udea.rd.dao.impl.DispositivoDAOImpl;
import co.edu.udea.rd.dao.impl.PrestamoDAOImpl;
import co.edu.udea.rd.dao.impl.UsuarioDAOImpl;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Prestamo;
import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

public class PrestamoBLImpl implements PrestamoBL {

	private PrestamoDAOImpl daoPrestamo;
	private UsuarioDAOImpl daoUsuario;
	private DispositivoDAOImpl daoDispositivo;

	@Override
	public void actualizarEstadoPrestamo(String username, String idDispositivo, String estado) throws MyException {
		Prestamo prestamo = null;
		Usuario usuario = null;
		Dispositivo dispositivo = null;
		PrestamoId prestamoId = null;

		// Se validan que los campos obligatorios no sean vacios o nulos.

		if ((username == null) || "".equals(username)) {
			throw new MyException("Nombre de usuario invàlido", null);
		}
		if ((idDispositivo == null) || "".equals(idDispositivo)) {
			throw new MyException("Id del dispositivo invàlida.", null);
		}
		if ((estado == null) || "".equals(estado)) {
			throw new MyException("Estado del dispositivo invàlido", null);
		}

		// Se valida que el usuario y el dispositivo existan.
		dispositivo = daoDispositivo.obtenerDispositivo(idDispositivo);
		if (dispositivo == null) {
			throw new MyException("Dispositivo no existe", null);
		}
		usuario = daoUsuario.obtenerUsuario(username);
		if (usuario == null) {
			throw new MyException("Usuario no existe", null);
		}

		// Creando el idDispositivo para el prèstamo.
		prestamoId = new PrestamoId();
		prestamoId.setDispositivo(dispositivo);
		prestamoId.setUsuario(usuario);

		prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
		if (prestamo == null) {
			throw new MyException("El prestamo no existe", null);
		}

		prestamo.setEstado(estado);
		daoPrestamo.modificarPrestamo(prestamo);
	}

	@Override
	public void solicitarPrestamo(String idDispositivo, String username, Date fechaInicialPrestamo,
			Date fechaFinalPrestamo) throws MyException {

		Dispositivo disp = null;
		Usuario user = null;
		PrestamoId prestamoId = null;
		Date fechaSolicitud = null;

		Prestamo prestamo = new Prestamo();

		// Validando los datos ingresados al sistema.

		if ((idDispositivo == null) || "".equals(idDispositivo)) {
			throw new MyException("Nombre de dipositivo invalido", null);
		}
		if ((username == null) || "".equals(username)) {
			throw new MyException("Nombre de usuario invalido", null);
		}

		if ((fechaInicialPrestamo == null)) {
			throw new MyException("Fecha Inicial Prestamo invalido", null);
		}
		if ((fechaFinalPrestamo == null)) {
			throw new MyException("Fecha Final Prestamo invalido", null);
		}

		// Validaciones de fechas, la fecha inicial del prestamo no puede ser
		// antes que la fecha de solicitud de prestamo y la fecha final del
		// prestamo no puede ser antes de la fecha inicial del prestamo

		fechaSolicitud = new Date();
		if (fechaInicialPrestamo.compareTo(fechaSolicitud) < 0) {
			throw new MyException("Fecha Inicial Prestamo invalido", null);
		}
		if (fechaFinalPrestamo.compareTo(fechaInicialPrestamo) < 0) {
			throw new MyException("Fecha Final Prestamo invalido", null);
		}

		// Se valida que el usuario y el dispositivo existan.
		disp = daoDispositivo.obtenerDispositivo(idDispositivo);
		if (disp == null) {
			throw new MyException("Dispositivo no existe", null);
		}
		user = daoUsuario.obtenerUsuario(username);
		if (user == null) {
			throw new MyException("Usuario no existe", null);
		}

		// Se válida que el tiempo de uso sea menor o igual a 8 horas.
		float diferencia = fechaFinalPrestamo.getTime() - fechaInicialPrestamo.getTime();

		if (diferencia > 8) {
			throw new MyException("No se permiten prestamo por más de 8 horas, verifique los datos", null);
		}

		// Creando el idDispositivo para el prèstamo.
		prestamoId = new PrestamoId();
		prestamoId.setDispositivo(disp);
		prestamoId.setUsuario(user);

		// Se asignan todos los datos del DTO prestamo.
		prestamo.setPrestamoId(prestamoId);
		prestamo.setEstado("Pendiente");
		fechaSolicitud = new Date();
		prestamo.setFechaSolicitud(fechaSolicitud);
		prestamo.setFechaInicialPrestamo(fechaInicialPrestamo);
		prestamo.setFechaFinalPrestamo(fechaFinalPrestamo);

		// Se valida que el dispositivo esté disponible para la fecha indicada.
		boolean estaDisponible = daoPrestamo.validarDisponibilidadPrestamo(prestamo);
		if (estaDisponible == false) {
			throw new MyException("El dispositivo no está diponible.", null);
		}

		// Se hace uso del método crearPrestamo de la clase PrestamoDAOImpl,
		// para guardar la información del DTO en la base de datos.

		daoPrestamo.crearPrestamo(prestamo);
	}

	// Mètodos accesores de los DAO inyectados.

	public PrestamoDAOImpl getDaoPrestamo() {
		return daoPrestamo;
	}

	public void setDaoPrestamo(PrestamoDAOImpl daoPrestamo) {
		this.daoPrestamo = daoPrestamo;
	}

	public UsuarioDAOImpl getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(UsuarioDAOImpl daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public DispositivoDAOImpl getDaoDispositivo() {
		return daoDispositivo;
	}

	public void setDaoDispositivo(DispositivoDAOImpl daoDispositivo) {
		this.daoDispositivo = daoDispositivo;
	}
}
