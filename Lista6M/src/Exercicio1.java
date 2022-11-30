import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Exercicio1 {

	public static void main(String[] parametros) {
		LinkedList<Veiculo> veiculos = new LinkedList<>();
		
		Veiculo v1 = new Veiculo("123", "Celta Azul", 2022, "Dorivaldo");
		veiculos.add(v1);
		Veiculo v2 = new Veiculo("1234", "Uno", 2021, "Daniel");
		veiculos.add(v2);
		Veiculo v3 = new Veiculo("1235", "Uno", 2021, "Gustavo");
		veiculos.add(v3);
		Veiculo v4 = new Veiculo("1236", "Monza", 2010, "Gabriel");
		veiculos.add(v4);
		Veiculo v5 = new Veiculo("1237", "Marea", 2021, "Luiz");
		veiculos.add(v5);
		Veiculo v6 = new Veiculo("1238", "Chevette", 2019, "Marcel");
		veiculos.add(v6);
		Veiculo v7 = new Veiculo("1239", "Fusca", 2022, "Julio");
		veiculos.add(v7);
		Veiculo v8 = new Veiculo("1230", "Gol Bola", 2008, "Michael Jackson");
		veiculos.add(v8);
		Veiculo v9 = new Veiculo("12311", "Palio", 2023, "Camaleao");
		veiculos.add(v9);
		Veiculo v10 = new Veiculo("12312", "Corsa", 2022, "Luva de Pedreiro");
		veiculos.add(v10);
		
		System.out.println("Após as inclusões");
		System.out.println(veiculos);
		
		veiculos.remove(v8); // deletei pelo objeto
		veiculos.remove(6);  // deletei o sétimo elemento
		ListIterator<Veiculo> li = veiculos.listIterator(veiculos.size()-2);
		Veiculo v = li.previous();
		li.remove(); // deletei pelo iterador
		
		System.out.println("\nApós as exclusões");
		System.out.println(veiculos);
		System.out.println("\nBagunçando a lista...");
		Collections.shuffle(veiculos);
		System.out.println(veiculos);
		
		System.out.println("\nOrdenado por placa");
		Collections.sort(veiculos);
		System.out.println(veiculos);
		
		System.out.println("\nOrdenado por ano e placa");
		Collections.shuffle(veiculos);
		ComparaAnoPlaca comparador = new ComparaAnoPlaca();
		Collections.sort(veiculos, comparador);
		System.out.println(veiculos);
		
		
		System.out.println("\nOrdenado por modelo, ano e placa");
		Collections.shuffle(veiculos);
		ComparaModeloAnoPlaca comparadorModelo = new ComparaModeloAnoPlaca();
		Collections.sort(veiculos, comparadorModelo);
		System.out.println(veiculos);
		}
}
