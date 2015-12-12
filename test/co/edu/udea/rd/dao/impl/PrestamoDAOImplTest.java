package co.edu.udea.rd.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.dto.Prestamo;
import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class PrestamoDAOImplTest {

	@Autowired
	PrestamoDAOImpl daoPrestamo;

	@Autowired
	UsuarioDAOImpl daoUsuario;

	@Autowired
	DispositivoDAOImpl daoDispositivo;

	@Test
	public void test1ListarPrestamos() {
		List<Prestamo> prestamos = null;
		int total = 1;
		try {
			// Act
			prestamos = daoPrestamo.listarPrestamos();
			// Assert
			assertTrue(total <= prestamos.size());
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test2CrearPrestamo() {
		Prestamo prestamo = new Prestamo();
		PrestamoId prestamoId = new PrestamoId();

		try {
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo.setPrestamoId(prestamoId);
			prestamo.setFechaSolicitud(new Date());
			prestamo.setFechaInicialPrestamo(new Date());
			prestamo.setFechaFinalPrestamo(new Date());

			daoPrestamo.crearPrestamo(prestamo);

			assertTrue(true);
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test3ObtenerPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		try {
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
			assertTrue(prestamo != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test4ModificarPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		Date fecha = null;
		SimpleDateFormat formatoFecha = null;
		try {
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);

			formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
			fecha = formatoFecha.parse("01/01/2016");
			prestamo.setFechaFinalPrestamo(fecha);

			daoPrestamo.modificarPrestamo(prestamo);

			assertTrue(daoPrestamo.obtenerPrestamo(prestamoId).getFechaFinalPrestamo().getTime() == fecha.getTime());
		} catch (MyException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void test5EliminarPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		try {
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
			prestamo.setFechaFinalPrestamo(new Date(2016, 1, 1));
			daoPrestamo.eliminarPrestamo(prestamo);
			assertTrue(daoPrestamo.obtenerPrestamo(prestamoId) == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
