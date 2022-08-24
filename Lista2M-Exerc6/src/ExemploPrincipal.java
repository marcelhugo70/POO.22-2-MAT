
public class ExemploPrincipal {
	public static void main(String[] args) {
		VetorDeReais meuVetor = new VetorDeReais(5);
		VetorDeReais segundo = new VetorDeReais(5);
		
		meuVetor.setValor(4.5, 0);
		meuVetor.setValor(-1.3, 1);
		meuVetor.setValor(20, 2);
		meuVetor.setValor(31.7, 3);
		meuVetor.setValor(-20.0, 4);
		
		
		double mult = meuVetor.multiplicacao(segundo);
	}
	
}
