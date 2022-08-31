import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContribuinteTest {

	@Test
	void testCaso01_CalcularImposto_Renda3000_ValorZero() {
		// Arrange
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(3000);
		
		//Act
		double impostoCalculado = c.calcularImposto();
		
		// Assert
		assertEquals(0.0, impostoCalculado,0);
	}

	@Test
	void testCaso02_CalcularImposto_Renda9000_Valor522() {
		// Arrange
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(9000);
		
		//Act
		double impostoCalculado = c.calcularImposto();
		
		// Assert
		assertEquals(522.0, impostoCalculado,0);
	}
	
	@Test
	void testCaso03_CalcularImposto_Renda10000_Valor1500() {
		// Arrange
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(10000);
		
		//Act & Assert
		assertEquals(1500.0, c.calcularImposto(),0);
	}
	
	@Test
	void testCaso04_CalcularImposto_Renda34911_Valor9600() {
		// Arrange
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(34911.73);
		
		//Act & Assert
		assertEquals(9600.72, c.calcularImposto(),0.009);
	}
	
	@Test
	void testCaso05_SetRendaAnualNegativa() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(10000);
		c.setRendaAnual(-818.5);
		assertEquals(10000,c.getRendaAnual());
	}

	@Test
	void testCaso06_SetUf_SC() {
		Contribuinte c = new Contribuinte();
		c.setUf("SC");
		assertEquals("SC",c.getUf());
	}
	@Test
	void testCaso07_SetUf_PR() {
		Contribuinte c = new Contribuinte();
		c.setUf("PR");
		assertEquals("PR",c.getUf());
	}
	@Test
	void testCaso08_SetUf_RS() {
		Contribuinte c = new Contribuinte();
		c.setUf("RS");
		assertEquals("RS",c.getUf());
	}
	@Test
	void testCaso09_SetUf_SP_invalido() {
		Contribuinte c = new Contribuinte();
		c.setUf("SC");
		c.setUf("SP");
		assertEquals("SC",c.getUf());
	}
	@Test
	void testCaso10_SetUf_RJ_invalido() {
		Contribuinte c = new Contribuinte();
		c.setUf("RJ");
		assertNull(c.getUf());
	}
}
