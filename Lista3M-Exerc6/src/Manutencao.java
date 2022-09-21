
public class Manutencao {
	private int numero;
	private String descricao;
	private float custo;
	private int tempoParado;

	public float getCustoMedioDiario() {
		return this.custo / this.tempoParado;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		if (custo >= 0) {
			this.custo = custo;
		}
	}

	public int getTempoParado() {
		return tempoParado;
	}

	public void setTempoParado(int tempoParado) {
		if (tempoParado >= 0) {
			this.tempoParado = tempoParado;
		}
	}

}
