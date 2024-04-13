package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.CategoriaController;
import com.reclamegeral.model.Categoria;

public class CategoriaView {
	private CategoriaController categoriaController;

	public CategoriaView() {
		this.categoriaController = new CategoriaController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Categoria:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Categoria novaCategoria = categoriaController.obterDadosCategoria();
			categoriaController.inserirCategoria(novaCategoria);
			break;

		case "Listar Todos":
			List<Categoria> todasAsCategorias = categoriaController.pesquisarTodos();
			categoriaController.exibirCategorias(todasAsCategorias);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser pesquisada:"));
			Categoria categoriaPesquisada = categoriaController.pesquisarUmCategoria(idPesquisar);
			if (categoriaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Categoria encontrada:\n" + categoriaPesquisada.toString(),
						"Categoria Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser atualizada:"));
			Categoria categoriaParaAtualizar = categoriaController.pesquisarUmCategoria(idAtualizar);
			if (categoriaParaAtualizar != null) {
				Categoria dadosAtualizados = categoriaController.obterDadosCategoria();
				categoriaParaAtualizar = categoriaController.atualizarDadosCategoria(categoriaParaAtualizar,
						dadosAtualizados);
				categoriaController.atualizar(categoriaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser deletada:"));
			Categoria categoriaParaDeletar = categoriaController.pesquisarUmCategoria(idDeletar);
			if (categoriaParaDeletar != null) {
				categoriaController.apagar(categoriaParaDeletar);
				JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Categoria.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
