package fronteira;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField txtFilme;
	private JTextField txtDiretor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JLabel lblNomeFilme = new JLabel("Nome Filme");
		lblNomeFilme.setBounds(6, 31, 95, 16);
		frame.getContentPane().add(lblNomeFilme);
		
		JLabel lblNomeDiretor = new JLabel("Nome Diretor");
		lblNomeDiretor.setBounds(6, 64, 85, 16);
		frame.getContentPane().add(lblNomeDiretor);
		
		txtFilme = new JTextField();
		txtFilme.setBounds(111, 26, 164, 26);
		frame.getContentPane().add(txtFilme);
		txtFilme.setColumns(10);
		
		txtDiretor = new JTextField();
		txtDiretor.setBounds(103, 59, 172, 21);
		frame.getContentPane().add(txtDiretor);
		txtDiretor.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Filme f1 = new Filme ();
//				f1.setId(null);
//				f1.setNome(txtFilme.getText());
//				f1.setNomeDiretor(txtDiretor.getText());
//				
//				FilmeController ctf = new FilmeController();
//				ctf.salvarFilme(f1);
				
			}
		});
		btnGravar.setBounds(111, 181, 117, 29);
		frame.getContentPane().add(btnGravar);
	}
}
