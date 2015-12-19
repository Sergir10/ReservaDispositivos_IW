package co.edu.udea.rd.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los m�todos implementados en
 * DispositivoBLImpl.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
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
	 * M�todo para probar el m�todo registrarDispositivo de la clase
	 * DispositivoBLImpl, esta prueba se acierta si no se lanza ninguna
	 * excepci�n en el proceso de registro, tambien se puede verificar en la
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
	
	/**
	 * 
	 * M�todo para probar el m�todo listarDispositivo de la clase
	 * DispositivoBLImpl, esta prueba se acierta si la lista de dispositivos
	 * es mayor que cero.
	 * 
	 */
	@Test
	public void test2ListarDispositivos() {
		try {
			// Act
			List<Dispositivo> dispositivos = new ArrayList();
			dispositivos = blDispositivo.listarDispositivos();
			// Assert
			System.out.println("******************"+dispositivos.size());
			assertTrue(dispositivos.size()>0);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}
	

	/**
	 * 
	 * M�todo para probar el m�todo listarDispositivo de la clase
	 * DispositivoBLImpl,esta prueba se acierta si no se lanza ninguna
	 * excepci�n en el proceso de eliminaci�n, tambien se puede verificar en la
	 * base de datos que el dispositivo fue eliminado.
	 * 
	 */
	@Test
	public void test3ModificarDispositivo() {
		try {
			// Act
			blDispositivo.modificarDispositivo("nexus_5x", 1, 5, 4);
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}
	
//	@Test
	public void test4EliminarDispositivo() {
		try {
			// Act
			blDispositivo.eliminarDispositivo("nexus_5x");
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}


}
