import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class DataAgendaTest {

	@Test
	void test01AddCompromissosValidos() {
		Compromisso c1 = new Compromisso(LocalTime.of(11, 00), "Teste", 10, 'A');
		Compromisso c2 = new Compromisso(LocalTime.of(11, 01), "Teste2", 10, 'B');
		
		DataAgenda da = new DataAgenda();
		assertTrue(da.addCompromisso(c1));
		assertTrue(da.addCompromisso(c2));
	}

	@Test
	void test02AddCompromissosNaMesmaHora() {
		Compromisso c1 = new Compromisso(LocalTime.of(11, 00), "Teste", 10, 'A');
		Compromisso c2 = new Compromisso(LocalTime.of(11, 00), "Teste2", 10, 'B');
		
		DataAgenda da = new DataAgenda();
		assertTrue(da.addCompromisso(c1));
		assertFalse(da.addCompromisso(c2));
	}
	@Test
	void test03TempoMedio() {
		Compromisso c1 = new Compromisso(LocalTime.of(11, 00), "Teste", 10, 'A');
		Compromisso c2 = new Compromisso(LocalTime.of(11, 10), "Teste2", 90, 'B');
		Compromisso c3 = new Compromisso(LocalTime.of(15, 00), "Teste3", 80, 'N');
		
		DataAgenda da = new DataAgenda();
		da.addCompromisso(c1);
		da.addCompromisso(c2);
		da.addCompromisso(c3);
		
		assertEquals(60, da.getTempoMedio());
	}

	@Test
	void test04GetQtdCompromissosPrioridadeAlta() {
		Compromisso c1 = new Compromisso(LocalTime.of(11, 00), "Teste", 10, 'A');
		Compromisso c2 = new Compromisso(LocalTime.of(11, 10), "Teste2", 90, 'B');
		Compromisso c3 = new Compromisso(LocalTime.of(15, 00), "Teste3", 80, 'A');
		
		DataAgenda da = new DataAgenda();
		da.addCompromisso(c1);
		da.addCompromisso(c2);
		da.addCompromisso(c3);
		assertEquals(2, da.getQtdCompromissosPrioridade('A'));
	}

	@Test
	void test05GetQtdCompromissosPrioridadeNormal() {
		Compromisso c1 = new Compromisso(LocalTime.of(11, 00), "Teste", 10, 'A');
		Compromisso c2 = new Compromisso(LocalTime.of(11, 10), "Teste2", 90, 'B');
		Compromisso c3 = new Compromisso(LocalTime.of(15, 00), "Teste3", 80, 'A');
		
		DataAgenda da = new DataAgenda();
		da.addCompromisso(c1);
		da.addCompromisso(c2);
		da.addCompromisso(c3);
		assertEquals(0, da.getQtdCompromissosPrioridade('N'));
	}
}
