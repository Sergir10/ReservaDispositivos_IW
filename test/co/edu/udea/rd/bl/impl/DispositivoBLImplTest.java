package co.edu.udea.rd.bl.impl;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los métodos implementados en
 * DispositivoBLImpl.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class DispositivoBLImplTest {

	/**
	 * 
	 * Se inyecta un objeto DispositivoBLImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	DispositivoBLImpl blDispositivo;

	/**
	 * 
	 * Método para probar el método registrarDispositivo de la clase
	 * DispositivoBLImpl, esta prueba se acierta si no se lanza ninguna
	 * excepción en el proceso de registro, tambien se puede verificar en la
	 * base de datos que el dispositivo fue registrado.
	 * 
	 */
	@Test
	public void test1RegistrarDispositivo() {
		try {
			// Act
			blDispositivo.registrarDispositivo("nexus_5x", 1, 5, 3);
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
