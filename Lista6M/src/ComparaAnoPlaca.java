import java.util.Comparator;

public class ComparaAnoPlaca implements Comparator<Veiculo> {

	@Override
	public int compare(Veiculo v1, Veiculo v2) {
		if (v1.getAno() > v2.getAno()) {
			return 5; // positivo
		}
		if (v1.getAno() < v2.getAno()) {
			return -5; // negativo
		}
		return v1.getPlaca().compareTo(v2.getPlaca());
	}
	

}
