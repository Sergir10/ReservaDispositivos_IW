package co.edu.udea.rd.bl.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.rd.exception.MyException;

/**
 * Clase para realizar pruebas de los m�todos implementados en PrestamoBLImpl.
 * 
 * @author Sergio Giraldo - James Garzón - Juan José Martinez.
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Las pruebas son ejecutadas en
												// orden alfabetico.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigurationFile.xml")
public class PrestamoBLImplTest {

	/**
	 * 
	 * Se inyecta un objeto UsuarioBLImpl para ser usado en la clase.
	 * 
	 */
	@Autowired
	PrestamoBLImpl blPrestamo;

	//@Test
	public void test1ActualizarEstadoPrestamo() {

		try {
			// Act
			blPrestamo.actualizarEstadoPrestamo("james10", "quad_484746", "Terminado");
			// Assert
			assertTrue(true);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2RestarFechas(){
		Date fechaInicial;
		Date fechaFinal;
		
		fechaInicial = new Date();
		SimpleDateFormat formatoFecha;
		formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US);
		try {
			fechaFinal  = formatoFecha.parse("18/12/2015 18:56" );
			System.out.println("Fecha Inicial ++++++++++++++++++ " + fechaInicial + " fecha Final: +++++++++++++++" + fechaFinal);
			float diferencia = fechaFinal.getTime() - fechaInicial.getTime();
			System.out.println("***************"+ diferencia/(1000*60*60));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
