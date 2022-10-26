public class BoteSalvaVidas extends Embarcacao {
	private boolean inflavel;
	private int qtdeRemos;
	private int qtdeColetes;
	
	public BoteSalvaVidas(String registroCapitania, int qtdePessoas, 
			boolean inflavel, int qtdeRemos, int qtdeColetes) {
		super(registroCapitania, qtdePessoas);
		this.setInflavel(inflavel);
		this.setQtdeRemos(qtdeRemos);
		this.setQtdeColetes(qtdeColetes);
	}
	
	public boolean isInflavel() {
		return inflavel;
	}
	
	public void setInflavel(boolean inflavel) {
		this.inflavel = inflavel;
	}
	
	public int getQtdeRemos() {
		return qtdeRemos;
	}
	
	public void setQtdeRemos(int qtdeRemos) {
		if (qtdeRemos < 0) {
			throw new IllegalArgumentException("qtde de remos invalida");
		}
		this.qtdeRemos = qtdeRemos;
	}
	
	public int getQtdeColetes() {
		return qtdeColetes;
	}
	
	public void setQtdeColetes(int qtdeColetes) {
		if (qtdeColetes < 0) {
			throw new IllegalArgumentException("qtde de coletes invalida");
		}
		this.qtdeColetes = qtdeColetes;
	}
	
	public String verificaSeguranca() {
		if (this.qtdeColetes >= this.getQtdePessoas()) {
			return "Bote OK!";
		}
		int coletesFaltantes = this.getQtdePessoas() - this.qtdeColetes;
		return "Insuficiência de "+coletesFaltantes+" coletes salva-vidas";
	}
	
}
