
import java.time.LocalDate;
import java.util.ArrayList;

public class AlunoUniversitario extends Aluno {
	private char formaIngresso;
	private Curso curso;

	public AlunoUniversitario(String nome, LocalDate dataNascimento, char formaIngresso, Curso curso) {
		super(nome, dataNascimento);
		this.setFormaIngresso(formaIngresso);
		this.setCurso(curso);
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		if (curso != null) {
			this.curso = curso;
		} else {
			throw new IllegalArgumentException("Curso não pode ser nulo, tente novamente...");
		}
	}

	public char getFormaIngresso() {
		return formaIngresso;
	}

	public void setFormaIngresso(char formaIngresso) {
		if (formaIngresso == 'V' || formaIngresso == 'E' || formaIngresso == 'S' || formaIngresso == 'T'
				|| formaIngresso == 'I') {
			this.formaIngresso = formaIngresso;
		} else {
			throw new IllegalArgumentException("Forma de Ingresso não disponível.");
		}
	}

	public String mostra() {
		return this.getNome() + " é aluno  universitário do curso de " 
					+ curso.getSigla() + " - " + curso.getNomeCurso()
					+ ", ingressando por " + this.getFormaIngresso();
		
	}

	protected void finalize() throws Throwable {
		System.out.println("FIM do Aluno Universitário:"+this.getNome());
		super.finalize();
	}
}