import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfAno;
	private JTextField tfForma;
	private JTextField tfCurso;
	private JTextField tfSigla;
	
	private JComboBox<Curso> cbCursos;
	private JComboBox cbTipoAluno;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// para liberar mais cedo os containers e assim conseguir enxergar a destruição dos objetos
				cbCursos = null; 
				alunos =  null;
				System.gc();
				JOptionPane.showMessageDialog(null, "Parando para olhar a execução dos destrutores");
			}
		});
		frame.setBounds(100, 100, 620, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		cbTipoAluno = new JComboBox();
		cbTipoAluno.setModel(new DefaultComboBoxModel(new String[] { "Ensino Médio", "Universitário" }));
		cbTipoAluno.setToolTipText("Ensino Médio\r\nUniversitário");
		cbTipoAluno.setBounds(283, 28, 96, 22);
		frame.getContentPane().add(cbTipoAluno);

		JLabel lblNewLabel = new JLabel("Tipo de ensino:");
		lblNewLabel.setBounds(211, 33, 108, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 33, 108, 13);
		frame.getContentPane().add(lblNome);

		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(10, 56, 108, 13);
		frame.getContentPane().add(lblDataNascimento);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 151, 108, 13);
		frame.getContentPane().add(lblAno);

		JLabel lblFormaIngresso = new JLabel("Forma ingresso:");
		lblFormaIngresso.setBounds(211, 148, 108, 13);
		frame.getContentPane().add(lblFormaIngresso);

		JLabel lblFormaIngresso_1 = new JLabel("Nome do curso:");
		lblFormaIngresso_1.setBounds(420, 13, 108, 13);
		frame.getContentPane().add(lblFormaIngresso_1);

		JLabel lblFormaIngresso_1_1 = new JLabel("Sigla do curso:");
		lblFormaIngresso_1_1.setBounds(420, 49, 108, 13);
		frame.getContentPane().add(lblFormaIngresso_1_1);

		tfNome = new JTextField();
		tfNome.setBounds(44, 30, 96, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(113, 57, 96, 19);
		frame.getContentPane().add(tfData);

		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(44, 148, 96, 19);
		frame.getContentPane().add(tfAno);

		tfForma = new JTextField();
		tfForma.setColumns(10);
		tfForma.setBounds(289, 145, 96, 19);
		frame.getContentPane().add(tfForma);

		tfCurso = new JTextField();
		tfCurso.setColumns(10);
		tfCurso.setBounds(498, 10, 96, 19);
		frame.getContentPane().add(tfCurso);

		tfSigla = new JTextField();
		tfSigla.setColumns(10);
		tfSigla.setBounds(498, 46, 96, 19);
		frame.getContentPane().add(tfSigla);

		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "Lista dos alunos\\n";
				alunos.sort(null);
				for (Aluno a : alunos) {
					str += "\n" + a.mostra(); // polimorfismo
				}
				JOptionPane.showMessageDialog(frame, str);
			}
		});
		btnNewButton.setBounds(498, 229, 85, 21);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Aluno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(164, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Aluno ensino médio");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(23, 128, 113, 13);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Aluno universitário");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(245, 125, 113, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnCadastrarAluno = new JButton("Cadastrar aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno;
					if (cbTipoAluno.getSelectedIndex() == 0) {
						aluno = new AlunoEnsinoMedio(tfNome.getText(), LocalDate.parse(tfData.getText(), df),
								Integer.parseInt(tfAno.getText()));
					} else {
						aluno = new AlunoUniversitario(tfNome.getText(), LocalDate.parse(tfData.getText(), df),
								tfForma.getText().charAt(0), (Curso) cbCursos.getSelectedItem());
					}
					alunos.add(aluno);
					JOptionPane.showMessageDialog(frame, "Aluno cadastrado");
				} catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(frame, "Data com problemas");
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(frame, iae.getMessage());
				}
			}
		});
		btnCadastrarAluno.setBounds(136, 228, 147, 23);
		frame.getContentPane().add(btnCadastrarAluno);

		JButton btnCadastrarCurso = new JButton("Cadastrar curso");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Curso c = new Curso(tfSigla.getText(), tfCurso.getText());
					cbCursos.addItem(c);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(frame, iae.getMessage());
				}
			}
		});
		btnCadastrarCurso.setBounds(440, 84, 147, 23);
		frame.getContentPane().add(btnCadastrarCurso);

		JLabel lblNewLabel_2 = new JLabel("Curso:");
		lblNewLabel_2.setBounds(211, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		cbCursos = new JComboBox();
		cbCursos.setBounds(289, 172, 137, 22);
		frame.getContentPane().add(cbCursos);
	}
}