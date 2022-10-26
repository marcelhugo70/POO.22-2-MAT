public abstract class Embarcacao implements AtivoEmRisco {
	private String registroCapitania;
	private int qtdePessoas;
	
	public Embarcacao(String registroCapitania, int qtdePessoas) {
		super();
		this.setRegistroCapitania(registroCapitania);
		this.setQtdePessoas(qtdePessoas);
	}
	
	public String getRegistroCapitania() {
		return registroCapitania;
	}
	
	public void setRegistroCapitania(String registroCapitania) throws IllegalArgumentException {
		if (registroCapitania != null && !registroCapitania.isBlank()) {
			this.registroCapitania = registroCapitania;			
		} else {
			throw new IllegalArgumentException("Capitania vazio");
		}
	}
	
	public int getQtdePessoas() {
		return qtdePessoas;
	}
	
	public void setQtdePessoas(int qtdePessoas) throws IllegalArgumentException {
		if (qtdePessoas >= 0) {
			this.qtdePessoas = qtdePessoas;			
		} else {
			throw new IllegalArgumentException("Qtde de pessoas invalida");
		}
	}
	
	
}
