package ejeEntorno;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CBancariaTestParametrizado {

	private String passwordInicial;
	private int saldoInicial, cantidadDepositar, resultadoEsperado;
	
	public CBancariaTestParametrizado(String passwordIncial, int saldoInicial,int cantidadDepositar, int resultadoEsperado) {
		this.passwordInicial=passwordIncial;
		this.saldoInicial=saldoInicial;
		this.cantidadDepositar=cantidadDepositar;
		this.resultadoEsperado=resultadoEsperado;
		
	}
	
	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {
			{"pass123", 1000, 500, 1500},
			{"pass123", 1000,-500,-1}
		});
	}
	@Test
	public void testDepositar() {
		CBancaria cc = new CBancaria(saldoInicial, passwordInicial);
		int resultadoReal = cc.depositar(cantidadDepositar);
		assertEquals(resultadoEsperado,resultadoReal);
	}

}
