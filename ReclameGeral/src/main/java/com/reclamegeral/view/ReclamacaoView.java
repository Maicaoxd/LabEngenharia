package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.ReclamacaoController;
import com.reclamegeral.model.Reclamacao;

public class ReclamacaoView {
	private ReclamacaoController reclamacaoController;

	public ReclamacaoView() {
		this.reclamacaoController = new ReclamacaoController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Reclamacao:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Reclamacao novaReclamacao = reclamacaoController.obterDadosReclamacao();
			reclamacaoController.inserirReclamacao(novaReclamacao);
			break;

		case "Listar Todos":
			List<Reclamacao> todasAsReclamacaos = reclamacaoController.pesquisarTodos();
			reclamacaoController.exibirReclamacoes(todasAsReclamacaos);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamacao a ser pesquisada:"));
			Reclamacao reclamacaoPesquisada = reclamacaoController.pesquisarUmReclamacao(idPesquisar);
			if (reclamacaoPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Reclamacao encontrada:\n" + reclamacaoPesquisada.toString(),
						"Reclamacao Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamacao a ser atualizada:"));
			Reclamacao reclamacaoParaAtualizar = reclamacaoController.pesquisarUmReclamacao(idAtualizar);
			if (reclamacaoParaAtualizar != null) {
				Reclamacao dadosAtualizados = reclamacaoController.obterDadosReclamacao();
				reclamacaoParaAtualizar = reclamacaoController.atualizarDadosReclamacao(reclamacaoParaAtualizar,
						dadosAtualizados);
				reclamacaoController.atualizar(reclamacaoParaAtualizar);
				JOptionPane.showMessageDialog(null, "Reclamacao atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamacao a ser deletada:"));
			Reclamacao reclamacaoParaDeletar = reclamacaoController.pesquisarUmReclamacao(idDeletar);
			if (reclamacaoParaDeletar != null) {
				reclamacaoController.apagar(reclamacaoParaDeletar);
				JOptionPane.showMessageDialog(null, "Reclamacao deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamacao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Reclamacao.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
