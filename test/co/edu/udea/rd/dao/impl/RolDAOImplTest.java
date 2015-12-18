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

import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los métodos implementados en RolDAOImpl.
 * 
 * @author Sergio Giraldo - James GarzÃ³n - Juan JosÃ© Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class RolDAOImplTest {

	/**
	 * 
	 * Se inyecta un objeto RolDAOImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	RolDAOImpl daoRol;

	/**
	 * 
	 * Método para probar el método listarRoles de la clase RolDAOImpl, esta
	 * prueba se acierta si se obtiene 1 o mas roles.
	 * 
	 */
	@Test
	public void test1ListarRoles() {
		List<Rol> roles = null;
		int total = 1;
		try {
			// Act
			roles = daoRol.listarRoles();
			// Assert
			assertTrue(total <= roles.size());
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * 
	 * Método para probar el método obtenerRol de la clase RolDAOImpl, esta
	 * prueba se acierta si el rol obtenido es diferente de null.
	 * 
	 */
	@Test
	public void test2ObtenerRol() {
		Rol rol = null;
		try {
			// Act
			rol = daoRol.obtenerRol(1);
			// Assert
			assertTrue(rol != null);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
