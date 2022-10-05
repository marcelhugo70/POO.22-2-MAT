

import java.time.LocalDate;

public class TelefoneComercial extends Telefone {
	private char ramoAtividade;

	public TelefoneComercial(String nome, String endereco, 
			LocalDate data, String numero, char ramo) {
		super(nome, endereco, data, numero);
		this.setRamoAtividade(ramo);
	}

	public char getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(char ramoAtividade) {
		ramoAtividade = Character.toUpperCase(ramoAtividade);
		if (ramoAtividade == 'S' || ramoAtividade == 'C') {
			this.ramoAtividade = ramoAtividade;
		} else {
			throw new IllegalArgumentException("Ramos de atividade validos: (S, C)");
		}
	}

	public double custoMensalTelefone() {
		LocalDate d = LocalDate.parse("2019-01-01");
		// é possível acessar diretamente o atributo data pois ele foi declarado protected
		if (this.data.isBefore(d)) {
			return 25d;
		}
		return 37.50d;
	}


	public String getAddInfo() {
			if (ramoAtividade == 'S') {
				return "Ramo de atividade: Servicos";
			}
			return "Ramo de atividade: Comercio";
	}

}
