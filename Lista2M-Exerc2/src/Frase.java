
public class Frase {
	private String texto;

	public Frase(String texto) {
		super();
		this.texto = texto;
	}
	
	public String[] decompor() {
		return this.texto.split(" ");
	}
	

}
