package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.PessoaController;
import com.reclamegeral.model.Pessoa;

public class PessoaView {

	private PessoaController pessoaController;

	public PessoaView() {
		this.pessoaController = new PessoaController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Pessoa:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Pessoa novaPessoa = pessoaController.obterDadosPessoa();
			pessoaController.inserirPessoa(novaPessoa);
			break;

		case "Listar Todos":
			List<Pessoa> todasAsPessoas = pessoaController.pesquisarTodos();
			pessoaController.exibirPessoas(todasAsPessoas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser pesquisada:"));
			Pessoa pessoaPesquisada = pessoaController.pesquisarUmPessoa(idPesquisar);
			if (pessoaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Pessoa encontrada:\n" + pessoaPesquisada.toString(),
						"Pessoa Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser atualizada:"));
			Pessoa pessoaParaAtualizar = pessoaController.pesquisarUmPessoa(idAtualizar);
			if (pessoaParaAtualizar != null) {
				Pessoa dadosAtualizados = pessoaController.obterDadosPessoa();
				pessoaParaAtualizar = pessoaController.atualizarDadosPessoa(pessoaParaAtualizar, dadosAtualizados);
				pessoaController.atualizar(pessoaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser deletada:"));
			Pessoa pessoaParaDeletar = pessoaController.pesquisarUmPessoa(idDeletar);
			if (pessoaParaDeletar != null) {
				pessoaController.apagar(pessoaParaDeletar);
				JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Pessoa.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
