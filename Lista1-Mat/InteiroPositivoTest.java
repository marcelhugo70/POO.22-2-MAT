

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste InteiroPositivoTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class InteiroPositivoTest
{
    @Test
    void testCaso01_fatorial_10(){
        InteiroPositivo ip = new InteiroPositivo();
        ip.setValor(10);
        assertEquals(3628800, ip.fatorial());
    }


    @Test
    public void testCaso02_fatorial_20()
    {
        InteiroPositivo inteiroP1 = new InteiroPositivo();
        inteiroP1.setValor(20);
        assertEquals(2432902008176640000L, inteiroP1.fatorial());
    }
    
    @Test
    public void testCaso03_Divisores_14()
    {
        InteiroPositivo inteiroP1 = new InteiroPositivo();
        inteiroP1.setValor(14);
        assertEquals("Os divisores inteiros são 1, 2, 7, 14 e a quantidade de divisores é 4", 
                        inteiroP1.identificarDivisores());
    }
    
       @Test
    public void testCaso04_Divisores_18()
    {
        InteiroPositivo inteiroP1 = new InteiroPositivo();
        inteiroP1.setValor(18);
        assertEquals("Os divisores inteiros são 1, 2, 3, 6, 9, 18 e a quantidade de divisores é 6", 
                        inteiroP1.identificarDivisores());
    }
    
    @Test
    void testCaso05_Fibonacci_valor9() {
        InteiroPositivo i = new InteiroPositivo();
        i.setValor(9);
        int[] vetor = {1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(vetor, i.fibonacci());
    }
    
    @Test
    void testCaso06_Fibonacci_valor15() {
        InteiroPositivo i = new InteiroPositivo();
        i.setValor(15);
        int[] vetor = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        assertArrayEquals(vetor, i.fibonacci());
    }
}

