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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class UsuarioDAOImplTest {

	@Autowired
	UsuarioDAOImpl daoUsuario;

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
			daoUsuario.crearUsuario(usuario);
			assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test2ObtenerUsuario() {
		Usuario usuario = null;
		try {
			usuario = daoUsuario.obtenerUsuario("hackerman");
			assertTrue(usuario != null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3ModificarUsuario() {
		Usuario usuario = null;
		try {
			usuario = daoUsuario.obtenerUsuario("hackerman");
			usuario.setPassword("hackthis123");
			daoUsuario.modificarUsuario(usuario);
			assertTrue(daoUsuario.obtenerUsuario("hackerman").getPassword().equals("hackthis123"));
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test4Eliminar() {
		Usuario usuario = null;
		try {
			usuario = daoUsuario.obtenerUsuario("hackerman");
			daoUsuario.eliminar(usuario);
			assertTrue(daoUsuario.obtenerUsuario("hacerman") == null);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
