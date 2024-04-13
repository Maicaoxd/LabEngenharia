package com.reclamegeral.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.ReclamacaoDAO;
import com.reclamegeral.model.Categoria;
import com.reclamegeral.model.Empresa;
import com.reclamegeral.model.Pessoa;
import com.reclamegeral.model.Reclamacao;

public class ReclamacaoController {
	private ReclamacaoDAO reclamacaoDao = new ReclamacaoDAO();

	public void inserirReclamacao(Reclamacao reclamacao) {
		reclamacaoDao.salvar(reclamacao);
	}

	public List<Reclamacao> pesquisarTodos() {
		return reclamacaoDao.listarTodos();
	}

	public Reclamacao pesquisarUmReclamacao(Long id) {
		return reclamacaoDao.buscarPorId(id);
	}

	public void apagar(Reclamacao reclamacao) {
		reclamacaoDao.remover(reclamacao);
	}

	public void atualizar(Reclamacao reclamacao) {
		reclamacaoDao.atualizar(reclamacao);
	}

	public void exibirReclamacoes(List<Reclamacao> reclamacoes) {
		StringBuilder sb = new StringBuilder();
		for (Reclamacao reclamacao : reclamacoes) {
			sb.append(reclamacao.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Reclamações:\n" + sb.toString(), "Reclamações",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Reclamacao obterDadosReclamacao() {
		String texto = JOptionPane.showInputDialog(null, "Digite o texto da reclamação:");
		LocalDateTime dataHora = LocalDateTime.now();
		boolean hasReply = false; // Inicialmente, a reclamação não tem resposta

		try {
			Long idPessoa = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa que está reclamando:"));
			PessoaController pessoaController = new PessoaController();
			Pessoa pessoa = pessoaController.pesquisarUmPessoa(idPessoa); // Obter a pessoa correspondente ao ID

			Long idEmpresa = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa alvo da reclamação:"));
			EmpresaController empresaController = new EmpresaController();
			Empresa empresa = empresaController.pesquisarUmEmpresa(idEmpresa); // Obter a empresa correspondente ao ID

			Long idCategoria = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria da reclamação:"));
			CategoriaController categoriaController = new CategoriaController();
			Categoria categoria = categoriaController.pesquisarUmCategoria(idCategoria); // Obter a categoria
																							// correspondente ao ID

			// Validar se os objetos foram encontrados
			if (pessoa == null) {
				throw new IllegalArgumentException("Pessoa com o ID fornecido não encontrada.");
			}
			if (empresa == null) {
				throw new IllegalArgumentException("Empresa com o ID fornecido não encontrada.");
			}
			if (categoria == null) {
				throw new IllegalArgumentException("Categoria com o ID fornecido não encontrada.");
			}

			Reclamacao reclamacao = new Reclamacao();
			reclamacao.setTexto(texto);
			reclamacao.setDataHora(dataHora);
			reclamacao.setHasReply(hasReply);
			reclamacao.setPessoa(pessoa);
			reclamacao.setEmpresa(empresa);
			reclamacao.setCategoria(categoria);

			return reclamacao;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID inválido. Certifique-se de digitar um número válido.");
			return null; // Retorna null em caso de erro
		}
	}

	public Reclamacao atualizarDadosReclamacao(Reclamacao reclamacaoParaAtualizar, Reclamacao dadosAtualizados) {
		reclamacaoParaAtualizar.setTexto(dadosAtualizados.getTexto());
		reclamacaoParaAtualizar.setDataHora(dadosAtualizados.getDataHora());
		reclamacaoParaAtualizar.setHasReply(dadosAtualizados.isHasReply());
		reclamacaoParaAtualizar.setPessoa(dadosAtualizados.getPessoa());
		reclamacaoParaAtualizar.setEmpresa(dadosAtualizados.getEmpresa());
		reclamacaoParaAtualizar.setCategoria(dadosAtualizados.getCategoria());
		reclamacaoParaAtualizar.setRespostas(dadosAtualizados.getRespostas());

		return reclamacaoParaAtualizar;
	}

}
