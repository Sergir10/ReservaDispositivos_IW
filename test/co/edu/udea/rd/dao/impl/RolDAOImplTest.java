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
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class RolDAOImplTest {

	@Autowired
	RolDAOImpl daoRol;

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

}
