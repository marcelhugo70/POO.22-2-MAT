import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class L5_Exerc4 {

	public static void main(String[] args) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");

		try (FileInputStream fis = new FileInputStream("DadosMeteorologicos-OK - 15 dias de Outubro.dat");
				DataInputStream dis = new DataInputStream(fis);
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Objetos.obj"))) {
			while (true) {
				String dataStr = dis.readUTF();
				char c1 = dis.readChar();
				char c2 = dis.readChar();
				int velocidade = dis.readInt();
				int indice = dis.readInt();
				double temperatura = dis.readDouble();
				ClimaDoDia cd = new ClimaDoDia(LocalDate.parse(dataStr, df), "" + c1 + c2, velocidade, indice,
						temperatura);
				// serializando objeto de ClimaDoDia
				oos.writeObject(cd);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eof) {
			System.out.println("Tudo foi lido...");
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
