import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class L5_Exerc2 {

	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int opcao = jfc.showOpenDialog(null);
		if (opcao == JFileChooser.APPROVE_OPTION) {
			File arquivoEntrada = jfc.getSelectedFile();
			String nomeSaida = arquivoEntrada.getAbsolutePath()+"-saida";
			FileReader entrada = null;
			FileWriter saida = null;
			int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da chave (1-200)"));
			try {
				entrada = new FileReader(arquivoEntrada);
				saida = new FileWriter(nomeSaida);

				int lido = entrada.read();
				int convertido;
				while (lido != -1) { // se o valor for -1 indica fim de arquivo (EOF)
					convertido = converter(lido, chave);
					saida.write(convertido);

					lido = entrada.read();
				}
				entrada.close();
				saida.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static int converter(int lido, int chave) {
		int valor = lido + chave;
		if (valor > 255) {
			valor = valor - 256;
		}
		// o if poderia ser substituído por valor = valor%256
		return valor;
	}

}
