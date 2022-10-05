// Contribuição de
// Luis Felipe de Castilho
// Lyan Rodrigues
// Nicolas Zimermann

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.management.openmbean.KeyAlreadyExistsException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Apresentacao {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private HashMap<String, Telefone> telefones = new HashMap<>();

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

	public Apresentacao() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(tabbedPane);

		// ======================= //
		// ===== RESIDENCIAL ===== //
		// ======================= //

		JPanel panel = new JPanel();
		tabbedPane.addTab("Residencial", null, panel, null);
		panel.setLayout(null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(66, 11, 120, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setBounds(10, 45, 80, 14);
		panel.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(100, 42, 299, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setBounds(263, 14, 46, 14);
		panel.add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setBounds(319, 11, 80, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero:");
		lblNewLabel_3.setBounds(10, 76, 80, 14);
		panel.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(100, 74, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Possui conexao de internet?");
		lblNewLabel_6.setBounds(10, 106, 176, 13);
		panel.add(lblNewLabel_6);

		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setBounds(200, 102, 110, 21);
		panel.add(chckbxNewCheckBox);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textField.getText();
					String endereco = textField_2.getText();
					LocalDate data = LocalDate.parse(textField_3.getText());
					String numero = textField_1.getText();

					Telefone telefone = new TelefoneResidencial(nome, endereco, data, 
												numero,chckbxNewCheckBox.isSelected());
					addTelefone(telefone);

					chckbxNewCheckBox.setSelected(false);
					clearTextField(textField, textField_1, textField_2, textField_3);
				} catch (IllegalArgumentException illegal_exp) {
					JOptionPane.showMessageDialog(frame, illegal_exp.getMessage());
				} catch (DateTimeParseException date_exp) {
					JOptionPane.showMessageDialog(frame, "Data invalida (yyyy-mm-dd)");
				}
			}
		});
		btnNewButton.setBounds(100, 140, 110, 21);
		panel.add(btnNewButton);

		// ===================== //
		// ===== COMERCIAL ===== //
		// ===================== //

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Comercial", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setBounds(10, 14, 46, 14);
		panel_1.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 11, 120, 20);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 42, 299, 20);
		panel_1.add(textField_5);

		JLabel lblNewLabel_1_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_1.setBounds(10, 45, 80, 14);
		panel_1.add(lblNewLabel_1_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(319, 11, 80, 20);
		panel_1.add(textField_6);

		JLabel lblNewLabel_2_1 = new JLabel("Data:");
		lblNewLabel_2_1.setBounds(263, 14, 46, 14);
		panel_1.add(lblNewLabel_2_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 73, 86, 20);
		panel_1.add(textField_7);

		JLabel lblNewLabel_3_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_3_1.setBounds(10, 76, 80, 14);
		panel_1.add(lblNewLabel_3_1);

		textField_13 = new JTextField();
		textField_13.setBounds(140, 103, 110, 19);
		panel_1.add(textField_13);
		textField_13.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Ramo de atividade:");
		lblNewLabel_7.setBounds(10, 106, 120, 13);
		panel_1.add(lblNewLabel_7);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textField_4.getText();
					String endereco = textField_5.getText();
					LocalDate data = LocalDate.parse(textField_6.getText());
					String numero = textField_7.getText();
					char ramoAtiv = textField_13.getText().charAt(0);

					Telefone telefone = new TelefoneComercial(nome, endereco, data, numero,ramoAtiv);

					addTelefone(telefone);
					clearTextField(textField_4, textField_5, textField_6, textField_7, textField_13);
				} catch (IllegalArgumentException illegal_exp) {
					JOptionPane.showMessageDialog(frame, illegal_exp.getMessage());
				} catch (DateTimeParseException date_exp) {
					JOptionPane.showMessageDialog(frame, "Data invalida (yyyy-mm-dd)");
				} catch (IndexOutOfBoundsException index_exp) {
					JOptionPane.showMessageDialog(frame, "Informe um ramo de atividades");
				}

			}
		});
		btnNewButton_1.setBounds(100, 140, 110, 21);
		panel_1.add(btnNewButton_1);

		// ========================= //
		// ===== ESPECIALIZADO ===== //
		// ========================= //

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Especializado", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Nome:");
		lblNewLabel_5.setBounds(10, 14, 46, 14);
		panel_2.add(lblNewLabel_5);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(66, 11, 120, 20);
		panel_2.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(100, 42, 299, 20);
		panel_2.add(textField_9);

		JLabel lblNewLabel_1_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_2.setBounds(10, 45, 80, 14);
		panel_2.add(lblNewLabel_1_2);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(319, 11, 80, 20);
		panel_2.add(textField_10);

		JLabel lblNewLabel_2_2 = new JLabel("Data:");
		lblNewLabel_2_2.setBounds(263, 14, 46, 14);
		panel_2.add(lblNewLabel_2_2);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(100, 73, 86, 20);
		panel_2.add(textField_11);

		JLabel lblNewLabel_3_2 = new JLabel("N\u00FAmero:");
		lblNewLabel_3_2.setBounds(10, 76, 80, 14);
		panel_2.add(lblNewLabel_3_2);

		textField_14 = new JTextField();
		textField_14.setBounds(210, 103, 60, 19);
		panel_2.add(textField_14);
		textField_14.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Quantidade de ocorrencias:");
		lblNewLabel_8.setBounds(10, 106, 160, 13);
		panel_2.add(lblNewLabel_8);

		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textField_8.getText();
					String endereco = textField_9.getText();
					LocalDate data = LocalDate.parse(textField_10.getText());
					String numero = textField_11.getText();
					int qtdeOcorrencia = Integer.parseInt(textField_14.getText());

					Telefone telefone = new TelefoneEspecializado(nome, endereco, data, numero,qtdeOcorrencia);

					addTelefone(telefone);
					clearTextField(textField_8, textField_9, textField_10, textField_11, textField_14);

				} catch (IllegalArgumentException illegal_exp) {
					if (textField_14.getText() != null && !textField_14.getText().isBlank()) {
						JOptionPane.showMessageDialog(frame, illegal_exp.getMessage());
					} else {
						JOptionPane.showMessageDialog(frame, "Informe a qtde de ocorrencias");
					}
				} catch (DateTimeParseException date_exp) {
					JOptionPane.showMessageDialog(frame, "Data invalida (yyyy-mm-dd)");
				}
			}
		});
		btnNewButton_2.setBounds(100, 140, 110, 21);
		panel_2.add(btnNewButton_2);

		// ==================== //
		// ===== CONSULTA ===== //
		// ==================== //

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("N\u00FAmero:");
		lblNewLabel_9.setBounds(10, 10, 80, 14);
		panel_3.add(lblNewLabel_9);

		textField_15 = new JTextField();
		textField_15.setBounds(100, 7, 80, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);

		JButton btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoTelefoneStr = new String();
				String numero = textField_15.getText();
				try {
					Telefone telefone = telefones.get(numero);
					String s = "Nome usuario: " + telefone.getNome() + "\n" 
							+ "Número: " + telefone.getNumero() + "\n" 
							+ "Endereço instalação: " + telefone.getEndereco() + "\n" 
							+ "Data instalação: " + telefone.getData() + "\n"
							+ "Valor a pagar: R$" + telefone.custoMensalTelefone() + "\n" 
							+ telefone.getAddInfo();  // polimorfismo
					JOptionPane.showMessageDialog(frame, s);
				} catch (NullPointerException exp) {
					JOptionPane.showMessageDialog(frame, "Número não encontrado");
				}
				clearTextField(textField_15);
			}
		});
		btnNewButton_3.setBounds(246, 7, 100, 21);
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Faturamento");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double faturamento = 0d;
				for (Telefone t : telefones.values()) {
					faturamento += t.custoMensalTelefone(); // polimorfismo
				}
				String msg = "Faturamento total da empresa: R$" + faturamento;
				JOptionPane.showMessageDialog(frame, msg);
			}
		});
		btnNewButton_4.setBounds(236, 80, 120, 21);
		panel_3.add(btnNewButton_4);
	}

	public void addTelefone(Telefone... teles) {
		for (Telefone t : teles) {
			if (telefones.containsKey(t.getNumero())) {
				throw new KeyAlreadyExistsException("N\u00FAmero ja cadastrado");
			} else {
				telefones.put(t.getNumero(), t);
			}
		}
	}

	public void clearTextField(JTextField... tfs) {
		for (JTextField tf : tfs) {
			tf.setText("");
		}
	}

}
