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
	public void testCrearUsuario() {
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
		rol.setTipoRol("Administrador");

		usuario.setRol(rol);
		try {
			daoUsuario.crearUsuario(usuario);
			assertTrue(true);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testModificarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerUsuario() {
		fail("Not yet implemented");
	}

}
