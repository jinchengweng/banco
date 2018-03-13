package ejeEntorno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class CBancariaTest {

	CBancaria cc;
	@BeforeClass
	public static void inicioBateriaPruebas() {
		System.out.println("COMENZANDO PRUEBAS!!!!!");
	}
	@Before
	public void inicioPrueba() {
		System.out.println("Inicio Test");
		cc= new CBancaria(1000, "pass123");
	}
	@After
	public void finTest() {
		System.out.println("fin Test");
		cc= null;
	}
	@Test
	void testDepositar_Correcta() {
		cc= new CBancaria(1000, "pass123");
	int resultadoReal = cc.depositar(500);
	assertEquals(1500, resultadoReal);
	}
	

	@Test
	void testDepositar_Nocorrecta() {
		cc= new CBancaria(1000, "pass123");
		int resultadoReal = cc.depositar(-500);
		assertEquals(-1, resultadoReal);
	}

	@Test
	void testRetirar1() {
		cc= new CBancaria(1000, "pass123");
		int resultadoReal = cc.retirar(200, "pass123");
		assertEquals(800, resultadoReal);
	}
	
	@Test
	void testRetirar2() {
		cc= new CBancaria(1000, "pass123");
		int resultadoReal = cc.retirar(1500, "pass123");
		assertEquals(-1, resultadoReal);
	}
	
	@Test
	void testRetirar3() {
		cc= new CBancaria(1000, "pass123");
		int resultadoReal = cc.retirar(1500, "pass345");
		assertEquals(-2, resultadoReal);
	}

	@Test
	void testPasswordCorrecta1() {
		cc= new CBancaria(1000, "pass123");
		boolean resultadoReal = cc.passwordCorrecta("pass123");
		assertTrue(resultadoReal);
	}
	
	@Test
	void testPasswordCorrecta2() {
		cc= new CBancaria(1000, "pass123");
		boolean resultadoReal = cc.passwordCorrecta("pass345");
		assertFalse(resultadoReal);
	}

	@AfterClass
	public static void finBateriaPrueba() {
		System.out.println("FIN DE LAS PRUEBAS!!!");
	}
}
