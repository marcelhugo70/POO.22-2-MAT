
import java.time.LocalDate;

public class TelefoneResidencial extends Telefone {
	private boolean conexao;

	public TelefoneResidencial(String nome, String endereco, 
			LocalDate data, String numero, boolean conexao) {
		super(nome, endereco, data, numero);
		this.setConexao(conexao);
	}

	public boolean hasConexao() {
		return conexao;
	}

	public void setConexao(boolean conexao) {
		this.conexao = conexao;
	}

	public double custoMensalTelefone() {
		return 15;
	}


	public String getAddInfo() {
		if (conexao) {
			return "Conexao Internet: Sim";
		}
		return "Conexao Internet: Nao";
	}

}
