import java.util.ArrayList;
import java.util.HashMap;

public class Camara {
	private HashMap<Integer, Partido> partidos = new HashMap<>();

	public void addPartido(Partido p) {
		if (!partidos.containsKey(p.getNumero())) {
			partidos.put(p.getNumero(), p);
		}
	}

	public Partido getPartido(int numero) {
		return partidos.get(numero);
	}

	public int getTotalProjApres() {
		int total = 0;
		for (Partido p : partidos.values()) {
			total += p.getTotalProjApres();
		}
		return total;
	}

	public int getTotalProjAprov() {
		int total = 0;
		for (Partido p : partidos.values()) {
			total += p.getTotalProjAprov();
		}
		return total;
	}

	public int getQtdPartidos() {
		return partidos.size();
	}

	
	// duas estratégias para descobrir o Vereador com alguma característica de toda a câmara
	// primeira: dividir responsabilidade com outra classe
	public Vereador getVereadorMaisProjAprov() {
		Vereador maisProj = null;
		for (Partido p : partidos.values()) {
			Vereador verPartido = p.getVereadorMaisProjAprov();
			if (verPartido != null) {
				if (maisProj == null 
					|| verPartido.getQtdProjAprov() > maisProj.getQtdProjAprov()) {
					maisProj = verPartido;
				}
			}
		}
		return maisProj;
	}
	
	// segunda: fazer a varredura de todos os vereadores na Câmara, pedindo as listas para os Partidos
	public Vereador getVereadorMenorDesempenho() {
		Vereador menor = null;
		for (Partido p : partidos.values()) {
			ArrayList<Vereador> lista = p.getVereadores();
			for (Vereador v: lista) {
				if (menor == null 
					|| v.getDesempenho() < menor.getDesempenho()) {
					menor = v;
				}
			}
		}
		return menor;
	}
	
	public double getMediaDesempenho() {
		double soma = 0;
		int conta = 0;
		for (Partido p: partidos.values()) {
			soma += p.getMediaDesempenho()*p.getQtdeVereadores();
			conta += p.getQtdeVereadores();
		}
		return soma/conta;
	}
	
	public ArrayList<Vereador> getVereadoresAcimaMedia(){
		ArrayList<Vereador> osBao = new ArrayList<>();
		double media = this.getMediaDesempenho();
		
		for (Partido p : partidos.values()) {
			ArrayList<Vereador> lista = p.getVereadores();
			for (Vereador v: lista) {
				if (v.getDesempenho() > media) {
					osBao.add(v);
				}
			}
		}
		
		return osBao;
	}
}
