package co.edu.udea.rd.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los metodos implementados en
 * DispositivoDAOImpl.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class DispositivoDAOImplTest {

	/**
	 * 
	 * Se inyecta un objeto DispositivoDAOImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	DispositivoDAOImpl daoDispositivo;

	/**
	 * 
	 * Metodo para probar el metodo listarDispositivos de la clase
	 * DispositivoDAOImpl, esta prueba se acierta si se obtiene 1 o mas
	 * dispositivos.
	 * 
	 */
	@Test
	public void test1ListarDispositivos() {
		List<Dispositivo> dispositivos = null;
		int total = 1;
		try {
			// Act
			dispositivos = daoDispositivo.listarDispositivos();
			// Assert
			assertTrue(total <= dispositivos.size());
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo crearDispositivo de la clase
	 * DispositivoDAOImpl, esta prueba se acierta si no se lanza ninguna
	 * excepcion en el proceso de insercion.
	 * 
	 */
	@Test
	public void test2CrearDispositivo() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setIdDispositivo("asus_zencelular");

		TipoDispositivo tipoDispositivo = new TipoDispositivo();
		tipoDispositivo.setIdTipoDispositivo(1);

		dispositivo.setTipoDispositivo(tipoDispositivo);
		dispositivo.setStock(7);
		dispositivo.setDisponibles(3);

		try {
			// Act
			daoDispositivo.crearDispositivo(dispositivo);
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}

	}

	/**
	 * 
	 * Metodo para probar el metodo obtenerDispositivo de la clase
	 * DispositivoDAOImpl, esta prueba se acierta si el dispositivo obtenido es
	 * diferente de null.
	 * 
	 */
	@Test
	public void test3ObtenerDispositivo() {
		Dispositivo dispositivo = null;
		try {
			// Act
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			// Assert
			assertTrue(dispositivo != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo modificarDispositivo de la clase
	 * DispositivoDAOImpl, esta prueba se acierta si al obtener el dispositivo
	 * modificado el campo modificado es igual al esperado.
	 * 
	 */
	@Test
	public void test4ModificarDispositivo() {
		Dispositivo dispositivo = null;
		try {
			// Act
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			dispositivo.setDisponibles(6);
			dispositivo.setStock(10);
			daoDispositivo.modificarDispositivo(dispositivo);
			// Assert
			assertTrue(daoDispositivo.obtenerDispositivo("asus_zencelular").getStock() == 10);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo eliminarDispositivo de la clase
	 * DispositivoDAOImpl, esta prueba se acierta si al obtener el dispositivo
	 * eliminado se tiene un null.
	 * 
	 */
	@Test
	public void test5EliminarDispositivo() {
		Dispositivo dispositivo = null;
		try {
			// Act
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			daoDispositivo.eliminarDispositivo(dispositivo);
			// Assert
			assertTrue(daoDispositivo.obtenerDispositivo("asus_zencelular") == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
