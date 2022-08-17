import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfRenda;
	private Contribuinte[] contribuintes = new Contribuinte[100];
	private int indice;
	private JTextField tfConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 11, 123, 14);
		frame.getContentPane().add(lblNewLabel);

		tfNome = new JTextField();
		tfNome.setBounds(143, 8, 189, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		tfCPF = new JTextField();
		tfCPF.setBounds(143, 33, 108, 20);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Estado (UF):");
		lblNewLabel_2.setBounds(10, 61, 78, 14);
		frame.getContentPane().add(lblNewLabel_2);

		tfUF = new JTextField();
		tfUF.setBounds(143, 58, 46, 20);
		frame.getContentPane().add(tfUF);
		tfUF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Renda anual: R$");
		lblNewLabel_3.setBounds(10, 86, 108, 14);
		frame.getContentPane().add(lblNewLabel_3);

		tfRenda = new JTextField();
		tfRenda.setBounds(143, 83, 108, 20);
		frame.getContentPane().add(tfRenda);
		tfRenda.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte contrib;
				contrib = new Contribuinte();
				contrib.setNome(tfNome.getText());
				contrib.setCpf(tfCPF.getText());
				contrib.setUf(tfUF.getText());
				contrib.setRendaAnual(Double.parseDouble(tfRenda.getText()));
				double imposto = contrib.calcularImposto();
				String str = "O contribuinte " + contrib.getNome() + " pagará R$" + imposto;
				JOptionPane.showMessageDialog(frame, str);
				contribuintes[indice] = contrib;
				indice++;
			}
		});
		btnNewButton.setBounds(143, 114, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Imposto a consultar: R$");
		lblNewLabel_4.setBounds(10, 186, 138, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfConsulta = new JTextField();
		tfConsulta.setBounds(143, 183, 108, 20);
		frame.getContentPane().add(tfConsulta);
		tfConsulta.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorConsulta = Double.parseDouble(tfConsulta.getText());
				String str = "Contribuintes com imposto acima de R$"+valorConsulta+"\n";
				for (int i=0; i < indice; i++) {
					if (contribuintes[i].calcularImposto() > valorConsulta) {
						str += "\n"+contribuintes[i].getNome()+" - "
								+contribuintes[i].getCpf()+" - "
								+contribuintes[i].getRendaAnual()+" - Imposto="
								+contribuintes[i].calcularImposto();
					}
				}
				JOptionPane.showMessageDialog(frame, str);
			}
		});
		btnNewButton_1.setBounds(264, 182, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
