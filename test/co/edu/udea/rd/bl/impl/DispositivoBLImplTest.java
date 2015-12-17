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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class DispositivoBLImplTest {

	@Autowired
	DispositivoBLImpl blDispositivo;

	@Test
	public void test1RegistrarDispositivo() {
		try {
			blDispositivo.registrarDispositivo("nexus_5x", 1, 5, 3);
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
