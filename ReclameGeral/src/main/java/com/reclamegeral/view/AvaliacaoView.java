package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.AvaliacaoController;
import com.reclamegeral.model.Avaliacao;

public class AvaliacaoView {

	private AvaliacaoController avaliacaoController;

	public AvaliacaoView() {
		this.avaliacaoController = new AvaliacaoController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Avaliacao:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Avaliacao novaAvaliacao = avaliacaoController.obterDadosAvaliacao();
			avaliacaoController.inserirAvaliacao(novaAvaliacao);
			break;

		case "Listar Todos":
			List<Avaliacao> todasAsAvaliacaos = avaliacaoController.pesquisarTodos();
			avaliacaoController.exibirAvaliacoes(todasAsAvaliacaos);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliacao a ser pesquisada:"));
			Avaliacao avaliacaoPesquisada = avaliacaoController.pesquisarUmAvaliacao(idPesquisar);
			if (avaliacaoPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Avaliacao encontrada:\n" + avaliacaoPesquisada.toString(),
						"Avaliacao Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliacao a ser atualizada:"));
			Avaliacao avaliacaoParaAtualizar = avaliacaoController.pesquisarUmAvaliacao(idAtualizar);
			if (avaliacaoParaAtualizar != null) {
				Avaliacao dadosAtualizados = avaliacaoController.obterDadosAvaliacao();
				avaliacaoParaAtualizar = avaliacaoController.atualizarDadosAvaliacao(avaliacaoParaAtualizar,
						dadosAtualizados);
				avaliacaoController.atualizar(avaliacaoParaAtualizar);
				JOptionPane.showMessageDialog(null, "Avaliacao atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliacao a ser deletada:"));
			Avaliacao avaliacaoParaDeletar = avaliacaoController.pesquisarUmAvaliacao(idDeletar);
			if (avaliacaoParaDeletar != null) {
				avaliacaoController.apagar(avaliacaoParaDeletar);
				JOptionPane.showMessageDialog(null, "Avaliacao deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Avaliacao.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}
