

import java.util.ArrayList;

public class Vereador {
	private String nome;
	private Partido partido;
	private ArrayList<ProjetoDeLei> projetosLei = new ArrayList<>();
		
	public Vereador(String nome) {
		setNome(nome);
	}

	public void addProjetodeLei(ProjetoDeLei p) {
		projetosLei.add(p);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("Digite um nome.");
		}
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		if (partido != null) {
			this.partido = partido;
			partido.addVereador(this);
		} else {
			throw new IllegalArgumentException("Digite um nome ao partido.");
		}
	}

	public int getQntProjAprovado() {
		int conta = 0;
		for (ProjetoDeLei p : this.projetosLei) {
			if (p.estaAprovado()) {
				conta++;
			}
		}
		return conta;
	}


	public int getQntProjApresentados() {
		return this.projetosLei.size();
	}



	public double getIndiceTrabalho() {
		if (this.getQntProjApresentados() < 1) {
			return 0;
		} else if (this.getQntProjApresentados() > 0 && this.getQntProjApresentados() <= 5) {
			return 0.80;
		} else if (this.getQntProjApresentados() >= 6 && this.getQntProjApresentados() <= 10) {
			return 1;
		} else if (this.getQntProjApresentados() >= 11 && this.getQntProjApresentados() <= 17) {
			return 1.08;
		} else {
			return 1.22;
		}
	}

	public double getDesempenho() {
		if (getQntProjApresentados() == 0) {
			return 0;
		} else {
			return (this.getQntProjAprovado() / this.getQntProjApresentados()) * getIndiceTrabalho();
		}
	}
}
