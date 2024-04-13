package com.reclamegeral.view;

import javax.swing.JOptionPane;

public class ReclameGeralApplication {
	public static void main(String[] args) {

		String[] entidades = { "Pessoa", "Empresa", "Categoria", "Reclamação", "Resposta", "Avaliação" };
		String entidadeSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a entidade:",
				"Menu Principal", JOptionPane.PLAIN_MESSAGE, null, entidades, entidades[0]);

		if (entidadeSelecionada == null) {
			System.exit(0);
		}

		switch (entidadeSelecionada) {
		case "Pessoa":
			PessoaView pessoaView = new PessoaView();
			pessoaView.mostrarMenu();
			break;
		case "Empresa":
			EmpresaView empresaView = new EmpresaView();
			empresaView.mostrarMenu();
			break;
		case "Categoria":
			CategoriaView categoriaView = new CategoriaView();
			categoriaView.mostrarMenu();
			break;
		case "Reclamação":
			ReclamacaoView reclamacaoView = new ReclamacaoView();
			reclamacaoView.mostrarMenu();
			break;
		case "Resposta":
			RespostaView respostaView = new RespostaView();
			respostaView.mostrarMenu();
			break;
		case "Avaliação":
			AvaliacaoView avaliacaoView = new AvaliacaoView();
			avaliacaoView.mostrarMenu();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
