import java.time.LocalDate;

public class Evento {
	private String titulo;
	private int valor;
	private LocalDate data;
	protected Avaliacao avaliacao;

	public Evento(String titulo, int valor, LocalDate data) {
		super();
		this.setTitulo(titulo);
		this.setValor(valor);
		this.setData(data);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor do ingresso inválido");
		}
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String exibir() {
		String str = "Evento: " + this.getTitulo() + ", no dia " + this.getData() + ", ingressos a R$ "
				+ this.getValor();
		if (this.avaliacao == null) {
			str += ". Ainda não avaliado.";
		} else {
			str += ", teve " + avaliacao.getQtdPagantes() + " pagantes que acharam o evento "
					+ avaliacao.getOpiniaoGeral();
		}
		return str;
	}
}
