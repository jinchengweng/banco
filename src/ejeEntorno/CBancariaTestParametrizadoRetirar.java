package ejeEntorno;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CBancariaTestParametrizadoRetirar {

	private String passwordInicial, passwordSolicitada;
	private int saldoInicial, cantidadRetirar, resultadoEsperado;
	
	public CBancariaTestParametrizadoRetirar(String passwordIncial, int saldoInicial,int cantidadRetirar,String passwordSolicitada, int resultadoEsperado) {
		this.passwordInicial=passwordIncial;
		this.saldoInicial=saldoInicial;
		this.cantidadRetirar=cantidadRetirar;
		this.passwordSolicitada=passwordSolicitada;
		this.resultadoEsperado=resultadoEsperado;
		
	}
	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {
			{"pass123", 1000, 200, "pass123", 800},
			{"pass123", 1000, 2000, "pass123", -1},
			{"pass123", 1000,200,"pass345",-2}
		});
	}
	
	@Test
	public void testRetirar() {
		CBancaria cc = new  CBancaria(saldoInicial, passwordInicial);
		int resultadoReal = cc.retirar(cantidadRetirar, passwordSolicitada);
		assertEquals(resultadoEsperado, resultadoReal);
	}

}
