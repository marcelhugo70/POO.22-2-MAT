import java.io.Serializable;
import java.time.LocalDate;

public class ClimaDoDia implements Serializable{
	private LocalDate data;
	private String direcaoVento;
	private int velocidadeVento;
	private int indicePluviometrico;
	private double temperatura;
	
	public ClimaDoDia(LocalDate data, String direcaoVento, int velocidadeVento, int indicePluviometrico,
			double temperatura) {
		super();
		this.setData(data);
		this.setDirecaoVento(direcaoVento);
		this.setVelocidadeVento(velocidadeVento);
		this.setIndicePluviometrico(indicePluviometrico);
		this.setTemperatura(temperatura);
	}
		
	@Override
	public String toString() {
		return "ClimaDoDia [data=" + data + ", direcaoVento=" + direcaoVento + ", velocidadeVento=" + velocidadeVento
				+ ", indicePluviometrico=" + indicePluviometrico + ", temperatura=" + temperatura + "]";
	}


	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDirecaoVento() {
		return direcaoVento;
	}
	public void setDirecaoVento(String direcaoVento) {
		this.direcaoVento = direcaoVento;
	}
	public int getVelocidadeVento() {
		return velocidadeVento;
	}
	public void setVelocidadeVento(int velocidadeVento) {
		this.velocidadeVento = velocidadeVento;
	}
	public int getIndicePluviometrico() {
		return indicePluviometrico;
	}
	public void setIndicePluviometrico(int indicePluviometrico) {
		this.indicePluviometrico = indicePluviometrico;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	

}
