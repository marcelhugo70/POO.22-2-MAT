

import java.time.LocalDate;

public class TelefoneEspecializado extends Telefone{
	private int qtdeOcorrencia;

	public TelefoneEspecializado(String nome, String endereco, 
			LocalDate data, String numero, int qtdOcorr) {
		super(nome, endereco, data, numero);
		this.setQtdeOcorrencia(qtdOcorr);
	}

	public int getQtdeOcorrencia() {
		return qtdeOcorrencia;
	}

	public void setQtdeOcorrencia(int qtdeOcorrencia) {
		if (qtdeOcorrencia > 0) {
			this.qtdeOcorrencia = qtdeOcorrencia;
		} else {
			throw new IllegalArgumentException("Numero deve ser maior que 0");
		}
	}

	public double custoMensalTelefone() {
		if (qtdeOcorrencia > 50000) {
			return 187.82;
		} else if (qtdeOcorrencia > 10000) {
			return 123.90;
		} else if (qtdeOcorrencia > 5000) {
			return 98.50;
		} else if (qtdeOcorrencia > 1000) {
			return 67.80;
		} else if (qtdeOcorrencia > 0) {
			return 50;
		}
		return 0;
	}

	public String getAddInfo() {
			return "Qtde Ocorrencias: " + Integer.toString(qtdeOcorrencia);
	}

}
