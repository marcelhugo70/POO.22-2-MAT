

import java.time.LocalDate;

public abstract class Telefone {
	private String nome;
	private String endereco;
	protected LocalDate data;  // para exemplificar a diferença entre protected e private
	private String numero;


	public Telefone(String nome, String endereco, 
			LocalDate data, String numero) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setData(data);
		this.setNumero(numero);
	}

	public abstract double custoMensalTelefone();
	public abstract String getAddInfo();
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isBlank()) {
			this.endereco = endereco;
		} else {
			throw new IllegalArgumentException("Endereco vazio");
		}
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		if (data != null) {
			this.data = data;
		} else {
			throw new IllegalArgumentException("Data vazia");
		}
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		String num = "";
		for (char c : numero.toCharArray()) {
			if (Character.isDigit(c)) {
				num += c;
			}
		}

		if (num.length() == 10) {
			this.numero = num;
		} else {
			throw new IllegalArgumentException("Numero invalido");
		}
	}



}
