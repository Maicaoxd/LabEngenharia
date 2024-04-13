package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.RespostaController;
import com.reclamegeral.model.Resposta;

public class RespostaView {

	private final RespostaController respostaController;

	public RespostaView() {
		this.respostaController = new RespostaController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Resposta:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Resposta novaResposta = respostaController.obterDadosResposta();
			respostaController.inserirResposta(novaResposta);
			break;

		case "Listar Todos":
			List<Resposta> todasAsRespostas = respostaController.pesquisarTodos();
			respostaController.exibirRespostas(todasAsRespostas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser pesquisada:"));
			Resposta respostaPesquisada = respostaController.pesquisarUmResposta(idPesquisar);
			if (respostaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Resposta encontrada:\n" + respostaPesquisada.toString(),
						"Resposta Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser atualizada:"));
			Resposta respostaParaAtualizar = respostaController.pesquisarUmResposta(idAtualizar);
			if (respostaParaAtualizar != null) {
				Resposta dadosAtualizados = respostaController.obterDadosResposta();
				respostaParaAtualizar = respostaController.atualizarDadosResposta(respostaParaAtualizar,
						dadosAtualizados);
				respostaController.atualizar(respostaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Resposta atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser deletada:"));
			Resposta respostaParaDeletar = respostaController.pesquisarUmResposta(idDeletar);
			if (respostaParaDeletar != null) {
				respostaController.apagar(respostaParaDeletar);
				JOptionPane.showMessageDialog(null, "Resposta deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Resposta.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
