
public class PassageirosHora {
	private int[][][] matriz = new int[12][30][24];  // 12 meses por 30 dias por 24 horas
	
	// item a
	public void adiciona(int dia, int mes, int hora) {
		this.matriz[mes-1][dia-1][hora]++;
	}
	
	// item b
	public int quantosPassageiros(int dia, int mes) {
		int total = 0;
		int d=dia-1; // para adequar o valor natural ao valor do índice (tecnológico)
		int m=mes-1;
		for (int h=0; h<matriz[m][d].length;h++) {
			total += matriz[m][d][h];
		}
		return total;
	}
	
	// item c
	public int mesMenorFluxo() {
		int mesMenor = 1; // assumindo janeiro como sendo o menor
		int qtdeMenor = this.quantosPassageiros(1);
		for (int mes=2; mes <= 12; mes++) {  // testando de fevereiro em diante
			int qtde = this.quantosPassageiros(mes);
			if (qtde < qtdeMenor) {
				qtdeMenor = qtde;
				mesMenor = mes;
			}
		}
		return mesMenor;
	}
	
	public int quantosPassageiros(int mes) {
		int total = 0;
		for (int dia=1; dia < 31; dia++) {
			total += this.quantosPassageiros(dia, mes);
		}
		return total;
	}
	
	public int[] picoTransporte() {
		int diaM, mesM, horaM, qtdeM;
		diaM = mesM = horaM = qtdeM = 0;
		
		for (int m=0; m<matriz.length; m++) {
			for (int d=0; d<matriz[m].length; d++) {
				for (int h=0; h<matriz[m][d].length; h++) {
					if (matriz[m][d][h] > qtdeM) {
						qtdeM = matriz[m][d][h];
						mesM = m+1;
						diaM = d+1;
						horaM = h;
					}
				}
			}
		}
		int[] retorno = {diaM, mesM, horaM, qtdeM};
		return retorno;
	}
}
