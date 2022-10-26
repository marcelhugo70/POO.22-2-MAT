import java.time.LocalDate;
import java.util.ArrayList;

public class Transatlantico extends Embarcacao {
	private String nome;
	private LocalDate dataInauguracao;
	private ArrayList<BoteSalvaVidas> botes = new ArrayList<>();

	public Transatlantico(String nome, LocalDate dataInauguracao, String registroCapitania, int qtdePessoas) {
		super(registroCapitania, qtdePessoas);
		this.setNome(nome);
		this.setDataInauguracao(dataInauguracao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("Nome vazio");
		}
	}

	public LocalDate getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(LocalDate dataInauguracao) {
		if (dataInauguracao != null) {
			this.dataInauguracao = dataInauguracao;
		} else {
			throw new IllegalArgumentException("Data vazia");
		}
	}

	public void addBoteSalvaVidas(BoteSalvaVidas bote) {
		if (bote != null) {
			botes.add(bote);
		} else {
			throw new IllegalArgumentException("Bote nulo");
		}
	}

	public void addBoteSalvaVidas(String registroCapitania, int qtdePessoas, 
			boolean inflavel, int qtdeRemos, int qtdeColetes) {
		BoteSalvaVidas b = new BoteSalvaVidas(registroCapitania, qtdePessoas, inflavel, qtdeRemos, qtdeColetes);
		botes.add(b);
	}

	public int getCapacidadeBotes() {
		int capacidadeTotalBotes = 0;
		for (BoteSalvaVidas b : botes) {
			capacidadeTotalBotes += b.getQtdePessoas();
		}
		return capacidadeTotalBotes;
	}
	
	public String verificaSeguranca() {
		if (this.getCapacidadeBotes() >= this.getQtdePessoas()) {
			return "Está em condições adequadas de segurança";
		} else if (this.dataInauguracao.isAfter(LocalDate.now())) {
			return "ALERTA: navio necessitando de mais botes!";
		}

		return "CUIDADO: navio em perigo";
	}

}
