import java.time.LocalDate;

public class Parecer {
	private String parecerista;
	private LocalDate data;
	private String conteudo;

	public String getParecerista() {
		return parecerista;
	}

	public void setParecerista(String parecerista) {
		if (parecerista != null && !parecerista.isBlank()) {
			this.parecerista = parecerista;
		}
		else {
			IllegalArgumentException exc = new IllegalArgumentException("Nome do parecerista está inválido");
			throw exc;
		}
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		if (conteudo == null || conteudo.isBlank()) {
			throw new IllegalArgumentException("Conteúdo não pode ser vazio/branco.");
		}
		this.conteudo = conteudo;
	}

}
