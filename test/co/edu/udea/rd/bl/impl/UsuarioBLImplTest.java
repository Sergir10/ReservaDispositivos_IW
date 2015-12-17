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
public class UsuarioBLImplTest {

	@Autowired
	UsuarioBLImpl blUsuario;

	@Test
	public void test1RegistrarUsuario() {
		try {
			blUsuario.registrarUsuario("andres", "123456", "123456", "Andres", "Munera", "CC", "123456789",
					"andres@gmail.com", 2, "55684645", "6548569541");
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test2actualizarInformacionPersonalUsuario() {
		try {
			blUsuario.actualizarInformacionPersonalUsuario("andres", "123456", "123456", "Andres Felipe", "Munera",
					"andres2@gmail.com", "55684645", "6548569541");
			assertTrue(true);
		} catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
