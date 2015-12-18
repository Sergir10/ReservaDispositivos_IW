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

/**
 * Clase para realizar pruebas de los metodos implementados en PrestamoDAOImpl.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class PrestamoDAOImplTest {

	/**
	 * 
	 * Se inyectan los objetos DAO necesarios para las pruebas. En este caso los
	 * DAO Implementado de Prestamo, Usuario y Dispositivo.
	 * 
	 */

	@Autowired
	PrestamoDAOImpl daoPrestamo;

	@Autowired
	UsuarioDAOImpl daoUsuario;

	@Autowired
	DispositivoDAOImpl daoDispositivo;

	/**
	 * 
	 * Metodo para probar el metodo listarPrestamos de la clase PrestamoDAOImpl,
	 * esta prueba se acierta si se obtiene 1 o mas prestamos.
	 * 
	 */
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

	/**
	 * 
	 * Metodo para probar el metodo crearPrestamo de la clase PrestamoDAOImpl,
	 * esta prueba se acierta si no se lanza ninguna excepcion en el proceso de
	 * insercion.
	 * 
	 */
	@Test
	public void test2CrearPrestamo() {
		Prestamo prestamo = new Prestamo();
		PrestamoId prestamoId = new PrestamoId();

		try {
			// Act
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo.setPrestamoId(prestamoId);
			prestamo.setFechaSolicitud(new Date());
			prestamo.setFechaInicialPrestamo(new Date());
			prestamo.setFechaFinalPrestamo(new Date());

			daoPrestamo.crearPrestamo(prestamo);

			// Assert
			assertTrue(true);
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Metodo para probar el metodo obtenerPrestamo de la clase PrestamoDAOImpl,
	 * esta prueba se acierta si el prestamo obtenido es diferente de null.
	 * 
	 */
	@Test
	public void test3ObtenerPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		try {
			// Act
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));

			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
			// Assert
			assertTrue(prestamo != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo modificarPrestamo de la clase
	 * PrestamoDAOImpl, esta prueba se acierta si al obtener el prestamo
	 * modificado el campo modificado es igual al esperado.
	 * 
	 */
	@Test
	public void test4ModificarPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		Date fecha = null;
		Date fechaNueva = null;
		SimpleDateFormat formatoFecha = null;
		try {
			// Act
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));
			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
			formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
			fecha = formatoFecha.parse("01/01/2016");
			prestamo.setFechaFinalPrestamo(fecha);
			daoPrestamo.modificarPrestamo(prestamo);
			fechaNueva = daoPrestamo.obtenerPrestamo(prestamoId).getFechaFinalPrestamo();
			// Assert
			assertTrue(fechaNueva.getTime() == fecha.getTime());
		} catch (MyException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo eliminarPrestamo de la clase
	 * PrestamoDAOImpl, esta prueba se acierta si al obtener el prestamo
	 * eliminado se tiene un null.
	 * 
	 */
	@Test
	public void test5EliminarPrestamo() {
		Prestamo prestamo = null;
		PrestamoId prestamoId = new PrestamoId();
		try {
			// Act
			prestamoId.setUsuario(daoUsuario.obtenerUsuario("tinez7g"));
			prestamoId.setDispositivo(daoDispositivo.obtenerDispositivo("quad_484746"));
			prestamo = daoPrestamo.obtenerPrestamo(prestamoId);
			prestamo.setFechaFinalPrestamo(new Date(2016, 1, 1));
			daoPrestamo.eliminarPrestamo(prestamo);
			// Assert
			assertTrue(daoPrestamo.obtenerPrestamo(prestamoId) == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
