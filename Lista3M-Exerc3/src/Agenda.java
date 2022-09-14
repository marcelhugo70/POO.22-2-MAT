import java.time.LocalDate;
import java.util.HashMap;

public class Agenda {
	private HashMap<LocalDate,DataAgenda> dias = new HashMap<>();
	
	public void addDataAgenda(DataAgenda dia) {
		if (!dias.containsKey(dia.getData())) {
			dias.put(dia.getData(), dia);
		}
	}
	
	public DataAgenda getDataAgenda(LocalDate data) {
		return dias.get(data);
	}
	
	public Compromisso getMenorCompromisso() {
		Compromisso menor = null;
		
		for (DataAgenda da: dias.values()) {
			Compromisso c = da.getMenorCompromisso();
			if (c != null) {
				if (menor == null || c.getTempo() < menor.getTempo()) {
					menor = c;
				}
			}
		}
		
		return menor;
	}
}
