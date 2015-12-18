package co.edu.udea.rd.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los metodos implementados en UsuarioDAOImpl.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class UsuarioDAOImplTest {

	/**
	 * 
	 * Se inyecta un objeto UsuarioDAOImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	UsuarioDAOImpl daoUsuario;

	/**
	 * 
	 * Metodo para probar el metodo crearUsuario de la clase UsuarioDAOImpl,
	 * esta prueba se acierta si no se lanza ninguna excepcion en el proceso de
	 * insercion.
	 * 
	 */
	@Test
	public void test1CrearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsername("hackerman");
		usuario.setPassword("123");
		usuario.setNombre("Hack");
		usuario.setApellido("German");
		usuario.setTipoDocumento("CC");
		usuario.setNroDocumento("666");
		usuario.setCorreo("hackthis@hacker.man");

		Rol rol = new Rol();
		rol.setIdRol(1);

		usuario.setRol(rol);
		try {
			// Act
			daoUsuario.crearUsuario(usuario);
			// Assert
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Metodo para probar el metodo obtenerUsuario de la clase UsuarioDAOImpl,
	 * esta prueba se acierta si el usuario obtenido es diferente de null.
	 * 
	 */
	@Test
	public void test2ObtenerUsuario() {
		Usuario usuario = null;
		try {
			// Act
			usuario = daoUsuario.obtenerUsuario("hackerman");
			// Assert
			assertTrue(usuario != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo para probar el metodo modificarUsuario de la clase UsuarioDAOImpl,
	 * esta prueba se acierta si al obtener el usuario modificado el campo
	 * modificado es igual al esperado.
	 * 
	 */
	@Test
	public void test3ModificarUsuario() {
		Usuario usuario = null;
		try {
			// Act
			usuario = daoUsuario.obtenerUsuario("hackerman");
			usuario.setPassword("hackthis123");
			daoUsuario.modificarUsuario(usuario);
			// Assert
			assertTrue(daoUsuario.obtenerUsuario("hackerman").getPassword().equals("hackthis123"));
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Metodo para probar el metodo eliminarUsuario de la clase UsuarioDAOImpl,
	 * esta prueba se acierta si al obtener el usuario eliminado se tiene un
	 * null.
	 * 
	 */
	@Test
	public void test4Eliminar() {
		Usuario usuario = null;
		try {
			// Act
			usuario = daoUsuario.obtenerUsuario("hackerman");
			daoUsuario.eliminar(usuario);
			// Assert
			assertTrue(daoUsuario.obtenerUsuario("hacerman") == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
