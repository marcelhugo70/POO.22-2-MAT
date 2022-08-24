
public class VetorDeReais {
	private double[] vetor;

	public VetorDeReais(int tamanho) {
		this.vetor = new double[tamanho];
	}

	// item a
	public void setValor(double valor, int posicao) {
		this.vetor[posicao] = valor;
	}

	// item b
	public int quantosPares() {
		int qtd = 0;
		for (int i = 0; i < vetor.length; i++) {
			if ((int) vetor[i] % 2 == 0) { // a parte inteira é par?
				qtd++;
			}
		}
		return qtd;
	}
	
	// item c
	public VetorDeReais divisao(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return null;
		}
		VetorDeReais novo = new VetorDeReais(vetor.length);
		double novoValor;
		
		for (int i=0; i < vetor.length; i++) {
			novoValor = vetor[i] / outro.getValor(i);
			novo.setValor(novoValor, i);
		}
		
		return novo;
	}
	
	public int getTamanho() {
		return  this.vetor.length;
	}
	
	public double getValor(int posicao) {
		return this.vetor[posicao];
	}
	
	// item d
	public double multiplicacao(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return Double.NaN; // constante indicando Not a Number
		}
		double m=0;
		for (int i=0, j=vetor.length-1; i < vetor.length; i++, j--) {
			m = m + this.getValor(i) * outro.getValor(j);
		}
		
		return m;
	}
	
	//item e
	public void inverter(){
		double aux;
		for (int i=0; i < this.getTamanho()/2; i++) {
			aux = this.vetor[i];
			this.vetor[i] = this.vetor[vetor.length-1-i];
			this.vetor[vetor.length-1-i] = aux;
		}
	}
	
	public double maiorDiferenca() {
		double maiorDiferenca = 0;
		double diferenca;

		for (int i = 1; i < this.vetor.length; i++) {
			diferenca = Math.abs(this.vetor[i] - this.vetor[i - 1]);
			if (maiorDiferenca < diferenca) {
				maiorDiferenca = diferenca;
			}
		}

		return maiorDiferenca;
	}

	public String exibir() {
		String str = "[";
		for (int i = 0; i < this.getTamanho(); i++) {
			str += this.vetor[i]+", ";
		}
		return str+"]";
	}
	
}

// sugestão de bibliografia
//LOPES, Anita; GARCIA, Guto. Introdução à programação: 500 algoritmos resolvidos. 
// Rio de Janeiro : Elsevier : Campus, 2002. 469 p, il. +, 1 CD-ROM.
