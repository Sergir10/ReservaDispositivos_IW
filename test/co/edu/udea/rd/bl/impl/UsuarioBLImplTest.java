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
 * Clase para realizar pruebas de los métodos implementados en UsuarioBLImpl.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class UsuarioBLImplTest {

	/**
	 * 
	 * Se inyecta un objeto UsuarioBLImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	UsuarioBLImpl blUsuario;

	/**
	 * 
	 * Método para probar el método registrarUsuario de la clase UsuarioBLImpl,
	 * esta prueba se acierta si no se lanza ninguna excepción en el proceso de
	 * registro, tambien se puede verificar en la base de datos que el usuario
	 * fue registrado.
	 * 
	 */
	@Test
	public void test1RegistrarUsuario() {
		try {
			// Act
			blUsuario.registrarUsuario("andres", "123456", "123456", "Andres", "Munera", "CC", "123456789",
					"andres@gmail.com", 2, "55684645", "6548569541");
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * 
	 * Método para probar el método actualizarInformacionPersonalUsuario de la
	 * clase UsuarioBLImpl, esta prueba se acierta si no se lanza ninguna
	 * excepción en el proceso de actualización, tambien se puede verificar en
	 * la base de datos que el usuario fue modificado.
	 * 
	 */
	@Test
	public void test2actualizarInformacionPersonalUsuario() {
		try {
			// Act
			blUsuario.actualizarInformacionPersonalUsuario("andres", "123456", "123456", "Andres Felipe", "Munera",
					"andres2@gmail.com", "55684645", "6548569541");
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
