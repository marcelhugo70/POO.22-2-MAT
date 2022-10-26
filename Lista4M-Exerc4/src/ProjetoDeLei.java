

import java.time.LocalDate;

public class ProjetoDeLei {

	private String titulo;
	private LocalDate dataApresentacao;
	private LocalDate dataAprovacao;
	private int numeroProjeto;
	private Vereador vereador;

	public ProjetoDeLei(String titulo, LocalDate dataApresentacao, LocalDate dataAprovacao, int numeroProjeto,
			Vereador vereador) {
		setTitulo(titulo);
		setDataApresentacao(dataApresentacao);
		setDataAprovacao(dataAprovacao);
		setNumeroProjeto(numeroProjeto);
		setVereador(vereador);
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (!titulo.equals(null) && !titulo.isBlank()) {
			this.titulo = titulo;
		} else {
			throw new IllegalArgumentException("Digite um tÃ­tulo ao projeto.");
		}
	}

	public LocalDate getDataApresentacao() {
		return dataApresentacao;
	}

	public void setDataApresentacao(LocalDate dataApresentacao) {
		if (dataApresentacao != null) {
			this.dataApresentacao = dataApresentacao;
		} else {
			throw new IllegalArgumentException("Digite uma data.");
		}
	}

	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(LocalDate dataAprovacao) {
			this.dataAprovacao = dataAprovacao;
	}

	public int getNumeroProjeto() {
		return numeroProjeto;
	}

	public void setNumeroProjeto(int numeroProjeto) {
		if (numeroProjeto > 0) {
			this.numeroProjeto = numeroProjeto;
		} else {
			throw new IllegalArgumentException("Digite o nÃºmero de projetos.");
		}
	}

	public String mostrar() {
		return "Título: " + this.getTitulo() + "\n" + "Data de Apresentacao: " + this.getDataApresentacao() + "\n"
				+ "Data de Aprovacao: " + this.getDataAprovacao() + "\n" + "Número do Projeto: "
				+ this.getNumeroProjeto();
	}

	public boolean estaAprovado() {
		return (this.dataAprovacao != null);
	}

}
