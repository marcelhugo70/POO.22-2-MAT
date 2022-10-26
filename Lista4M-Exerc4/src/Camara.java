

import java.util.ArrayList;
import java.util.HashMap;

public class Camara {
	private ArrayList<Partido> partidos;
	private HashMap<Integer, Partido> partidos1;

	public int totalProjAprovadoCamara() {
		int contador = 0;
		for (Partido partido : partidos) {
			contador += partido.totalProjAprova();
		}
		return contador;
	}

	public int getTotalProjAprovCamara() {
		int contador = 0;
		for (Partido partido : partidos) {
			contador += partido.totalProjAprova();
		}
		return contador;
	}

	public Vereador maisProjAptovad() {
		Vereador retornar = null;
		for (Partido partido : partidos) {
			Vereador comparar = partido.maisProjAprov();
			if (retornar == null || comparar.getQntProjAprovado() > retornar.getQntProjAprovado()) {
				retornar = comparar;
			}
		}
		return retornar;
	}

	public Vereador menorDesempenho() {
		Vereador retornar = null;
		for (Partido partido : partidos) {
			Vereador comparar = partido.menorDesempenho();
			if (retornar == null || comparar.getDesempenho() < retornar.getDesempenho()) {
				retornar = comparar;
			}
		}
		return retornar;
	}

	public int getTotalPartidos() {
		return partidos.size();
	}

	public void addPartido(Partido p) {
		partidos.add(p);
		if (partidos1.containsKey(p.getNumero())) {
			partidos1.put(p.getNumero(), p);
		}
	}

	public Partido getPartido(int numero) {
		return partidos1.get(numero);
	}

	public double mediaDesempenho() {
		double soma = 0;
		int conta = 0;
		for (Partido partido : partidos) {
			soma += partido.mediaDesempenho() * partido.qntVereadores();
			conta += partido.qntVereadores();
		}
		return soma / conta;
	}

	public ArrayList<Vereador> getVereadorAcimaMedia() {
		ArrayList<Vereador> osBao = new ArrayList<>();
		double media = this.mediaDesempenho();

		for (Partido p : partidos) {
			ArrayList<Vereador> lista = p.getVereadors();
			for (Vereador vereador : lista) {
				if (vereador.getDesempenho() > media) {
					osBao.add(vereador);
				}
			}
		}
		return osBao;
	}

}
