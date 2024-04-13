package com.reclamegeral.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.AvaliacaoDAO;
import com.reclamegeral.model.Avaliacao;
import com.reclamegeral.model.Reclamacao;

public class AvaliacaoController {
	private AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

	public void inserirAvaliacao(Avaliacao avaliacao) {
		avaliacaoDao.salvar(avaliacao);
	}

	public List<Avaliacao> pesquisarTodos() {
		return avaliacaoDao.listarTodos();
	}

	public Avaliacao pesquisarUmAvaliacao(Long id) {
		return avaliacaoDao.buscarPorId(id);
	}

	public void apagar(Avaliacao avaliacao) {
		avaliacaoDao.remover(avaliacao);
	}

	public void atualizar(Avaliacao avaliacao) {
		avaliacaoDao.atualizar(avaliacao);
	}

	public void exibirAvaliacoes(List<Avaliacao> avaliacoes) {
		StringBuilder sb = new StringBuilder();
		for (Avaliacao avaliacao : avaliacoes) {
			sb.append(avaliacao.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Avaliações:\n" + sb.toString(), "Avaliações",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Avaliacao obterDadosAvaliacao() {
		float pontuacao = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a pontuação da avaliação:"));
		boolean isResolved = Boolean.parseBoolean(JOptionPane.showInputDialog(null,
				"A reclamação está resolvida? Digite 'true' para sim ou 'false' para não:"));
		LocalDateTime dtAvaliacao = LocalDateTime.now();

		try {
			Long idReclamacao = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamação relacionada à avaliação:"));
			ReclamacaoController reclamacaoController = new ReclamacaoController();
			Reclamacao reclamacao = reclamacaoController.pesquisarUmReclamacao(idReclamacao);

			// Validar se a reclamação foi encontrada
			if (reclamacao == null) {
				throw new IllegalArgumentException("Reclamação com o ID fornecido não encontrada.");
			}

			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setPontuacao(pontuacao);
			avaliacao.setResolved(isResolved);
			avaliacao.setDtAvaliacao(dtAvaliacao);
			avaliacao.setReclamacao(reclamacao);

			return avaliacao;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID inválido. Certifique-se de digitar um número válido.");
			return null; // Retorna null em caso de erro
		}
	}

	public Avaliacao atualizarDadosAvaliacao(Avaliacao avaliacaoParaAtualizar, Avaliacao dadosAtualizados) {
		avaliacaoParaAtualizar.setPontuacao(dadosAtualizados.getPontuacao());
		avaliacaoParaAtualizar.setResolved(dadosAtualizados.isResolved());
		avaliacaoParaAtualizar.setDtAvaliacao(dadosAtualizados.getDtAvaliacao());
		avaliacaoParaAtualizar.setReclamacao(dadosAtualizados.getReclamacao());

		return avaliacaoParaAtualizar;
	}

}
