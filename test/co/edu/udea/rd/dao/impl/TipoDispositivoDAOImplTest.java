package co.edu.udea.rd.dao.impl;

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

import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class TipoDispositivoDAOImplTest {

	@Autowired
	TipoDispositivoDAOImpl daoTipoDispositivo;

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

}
