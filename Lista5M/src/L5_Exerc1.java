import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L5_Exerc1 {

	public static void main(String[] parametros) {
		try {
			FileWriter fw = new FileWriter("L5M-Exerc1Texto.txt");
			fw.write("12345");
			fw.close();
			FileOutputStream fos = new FileOutputStream("L5M-Exerc1Binario.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(12345);
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// leitura de ambos como texto
		// try with resources
		try (FileReader fr = new FileReader("L5M-Exerc1Texto.txt");
			 BufferedReader bf = new BufferedReader(fr);){
			String s = bf.readLine();
			System.out.println("Lendo texto como texto = "+s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (FileReader fr = new FileReader("L5M-Exerc1Binario.dat");
				 BufferedReader bf = new BufferedReader(fr);){
				String s = bf.readLine();
				System.out.println("Lendo binário como texto = "+s);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// leitura de ambos como binário
		try (FileInputStream fis = new FileInputStream("L5M-Exerc1Texto.txt");
			 DataInputStream dis = new DataInputStream(fis)){
			int valor = dis.readInt(); 
			System.out.println("Lendo texto como binário = "+valor);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream("L5M-Exerc1Binario.dat");
				 DataInputStream dis = new DataInputStream(fis)){
				int valor = dis.readInt(); 
				System.out.println("Lendo binário como binário = "+valor);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
