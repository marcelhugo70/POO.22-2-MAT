import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TransatlanticoTest {

	@Test
	void testVerificaSegurancaBoteSalvaVidasSeguro() {
		/// AAA
		// Arrange
		BoteSalvaVidas bsv = new BoteSalvaVidas("XPTO", 28, true, 5, 28);
		// Act
		String msg = bsv.verificaSeguranca();
		// Assert
		assertEquals("Bote OK!", msg);
	}
	@Test
	void testVerificaSegurancaBoteSalvaVidasInseguro() {
		/// AAA
		// Arrange
		BoteSalvaVidas bsv = new BoteSalvaVidas("XPTO", 30, true, 5, 28);
		// Act
		String msg = bsv.verificaSeguranca();
		// Assert
		assertEquals("Insuficiência de 2 coletes salva-vidas", msg);
	}
	
	@Test
	void testVerificaSegurancaTransatlanticoSeguro() {
		/// AAA
		// Arrange
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.now(),"REG001", 1000); 
		BoteSalvaVidas bsv = new BoteSalvaVidas("XPTO", 28, true, 5, 28);
		t.addBoteSalvaVidas(bsv);
		t.addBoteSalvaVidas("XPTO2", 400, false, 20, 400);
		t.addBoteSalvaVidas("XPTO3", 600, false, 40, 600);
		// Act
		String msg = t.verificaSeguranca();
		// Assert
		assertEquals("Está em condições adequadas de segurança", msg);
	}

	@Test
	void testVerificaSegurancaTransatlanticoInseguroComAlerta() {
		/// AAA
		// Arrange
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.now().plusDays(1),"REG001", 1000); 
		BoteSalvaVidas bsv = new BoteSalvaVidas("XPTO", 28, true, 5, 28);
		t.addBoteSalvaVidas(bsv);
		t.addBoteSalvaVidas("XPTO2", 40, false, 20, 40);
		t.addBoteSalvaVidas("XPTO3", 60, false, 40, 60);
		// Act
		String msg = t.verificaSeguranca();
		// Assert
		assertEquals("ALERTA: navio necessitando de mais botes!", msg);
	}
	
	@Test
	void testVerificaSegurancaTransatlanticoInseguroComCuidado() {
		/// AAA
		// Arrange
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.of(2020,10,10),"REG001", 1000); 
		BoteSalvaVidas bsv = new BoteSalvaVidas("XPTO", 28, true, 5, 28);
		t.addBoteSalvaVidas(bsv);
		t.addBoteSalvaVidas("XPTO2", 40, false, 20, 40);
		t.addBoteSalvaVidas("XPTO3", 60, false, 40, 60);
		// Act
		String msg = t.verificaSeguranca();
		// Assert
		assertEquals("CUIDADO: navio em perigo", msg);
	}
}
