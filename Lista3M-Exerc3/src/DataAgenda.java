import java.time.LocalDate;
import java.util.ArrayList;

public class DataAgenda {
	private LocalDate data;
	private String efemeride;
	private ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEfemeride() {
		return efemeride;
	}

	public void setEfemeride(String efemeride) {
		this.efemeride = efemeride;
	}

	public boolean addCompromisso(Compromisso compromisso) {
		for (Compromisso c : compromissos) {
			if (c.getHora().equals(compromisso.getHora())) {
				return false; // para interrromper e retornar sem adicionar o novo compromisso
			}
		}
		compromissos.add(compromisso);
		return true;
	}

	public int getTempoMedio() {
		int tempoTotal = 0;
		for (Compromisso c : compromissos) {
			tempoTotal += c.getTempo();
		}
		return tempoTotal / compromissos.size();
	}

	public ArrayList<Compromisso> getCompromissosPrioridade(char prioridade) {
		ArrayList<Compromisso> retornar = new ArrayList<Compromisso>();
		for (Compromisso c : compromissos) {
			if (c.getPrioridade() == prioridade) {
				retornar.add(c);
			}
		}
		return retornar;
	}

	public int getQtdCompromissosPrioridade(char prioridade) {
		int contador = 0;
		for (Compromisso c : compromissos) {
			if (c.getPrioridade() == prioridade) {
				contador++;
			}
		}
		return contador;
	}

	public Compromisso getMenorCompromisso() {
		Compromisso menor = null;

		for (Compromisso c : compromissos) {
			if (menor == null || c.getTempo() < menor.getTempo()) {
				menor = c;
			}
		}

		return menor;
	}
}
