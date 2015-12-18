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

import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los métodos implementados en
 * TipoDispositivoDAOImpl.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class TipoDispositivoDAOImplTest {

	/**
	 * 
	 * Se inyecta un objeto TipoDispositivoDAOImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	TipoDispositivoDAOImpl daoTipoDispositivo;

	/**
	 * 
	 * Método para probar el método listarTiposDeDispositivos de la clase
	 * TipoDispositivoDAOImpl, esta prueba se acierta si se obtiene 1 o mas
	 * tipos de dispositivos.
	 * 
	 */
	@Test
	public void test1ListarTiposDeDispositivos() {
		List<TipoDispositivo> tiposDeDispositivos = null;
		int total = 1;
		try {
			// Act
			tiposDeDispositivos = daoTipoDispositivo.listarTiposDeDispositivos();
			// Assert
			assertTrue(total <= tiposDeDispositivos.size());
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * 
	 * Método para probar el método obtenerTipoDeDispositivo de la clase
	 * TipoDispositivoDAOImpl, esta prueba se acierta si el tipo de dispositivo
	 * obtenido es diferente de null.
	 * 
	 */
	@Test
	public void test2ObtenerTipoDeDispositivo() {
		TipoDispositivo tipoDispositivo = null;
		try {
			// Act
			tipoDispositivo = daoTipoDispositivo.obtenerTipoDeDispositivo(1);
			// Assert
			assertTrue(tipoDispositivo != null);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
