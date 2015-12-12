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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class DispositivoDAOImplTest {

	@Autowired
	DispositivoDAOImpl daoDispositivo;

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
			daoDispositivo.crearDispositivo(dispositivo);
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void test3ObtenerDispositivo() {
		Dispositivo dispositivo = null;
		try {
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			assertTrue(dispositivo != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test4ModificarDispositivo() {
		Dispositivo dispositivo = null;
		try {
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			dispositivo.setDisponibles(6);
			dispositivo.setStock(10);
			daoDispositivo.modificarDispositivo(dispositivo);
			assertTrue(daoDispositivo.obtenerDispositivo("asus_zencelular").getStock() == 10);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5EliminarDispositivo() {
		Dispositivo dispositivo = null;
		try {
			dispositivo = daoDispositivo.obtenerDispositivo("asus_zencelular");
			daoDispositivo.eliminarDispositivo(dispositivo);
			assertTrue(daoDispositivo.obtenerDispositivo("asus_zencelular") == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
