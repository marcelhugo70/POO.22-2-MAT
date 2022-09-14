import java.time.LocalTime;

public class Compromisso { 
	private LocalTime hora;
	private String descricao;
	private int tempo;
	private char prioridade;
	
	public Compromisso(LocalTime hora, String descricao, int tempo, char prioridade) {
		super();
		this.setHora(hora);
		this.setDescricao(descricao);
		this.setTempo(tempo);
		this.setPrioridade(prioridade);
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		if (tempo >= 0) {
			this.tempo = tempo;
		}
	}

	public char getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(char prioridade) {
		prioridade = Character.toUpperCase(prioridade);
		if (prioridade == 'A' || prioridade == 'N' || prioridade == 'B') {
			this.prioridade = prioridade;
		}
	}

}
