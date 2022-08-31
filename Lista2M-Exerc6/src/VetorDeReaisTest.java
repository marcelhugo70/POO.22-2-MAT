import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VetorDeReaisTest {

	@Test
	void testCaso01_DivisaoNull() {
	      VetorDeReais vetorDeReais = new VetorDeReais(3);
	        VetorDeReais vetorDeReais2 = new VetorDeReais(1);
	        
	        vetorDeReais.setValor(2,0);
	        vetorDeReais.setValor(-1,1);
	        vetorDeReais.setValor(3.5,2);
	        
	        vetorDeReais2.setValor(3,0);
	        
	        assertEquals(null, vetorDeReais.divisao(vetorDeReais2));
	    }

	@Test
	void testCaso02_DivisaoSucesso() {
		// Arrange
		VetorDeReais vetorDeReais = new VetorDeReais(3);
        VetorDeReais vetorDeReais2 = new VetorDeReais(3);
        double[] vet = {0.666666, -0.5 , 3.5 };
        
        vetorDeReais.setValor(2,0);
        vetorDeReais.setValor(-1,1);
        vetorDeReais.setValor(3.5,2);
        
        vetorDeReais2.setValor(3,0);
        vetorDeReais2.setValor(2,1);
        vetorDeReais2.setValor(1,2);
        
        // Act
        VetorDeReais divsaoDeReais = vetorDeReais.divisao(vetorDeReais2);
        //Assert
        for (int i=0; i < vet.length; i++) {
        	assertEquals(vet[i], divsaoDeReais.getValor(i), 0.000001);
        }
    }
}
