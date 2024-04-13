package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.EmpresaController;
import com.reclamegeral.model.Empresa;

public class EmpresaView {

	private EmpresaController empresaController;

	public EmpresaView() {
		this.empresaController = new EmpresaController();
	}

	public void mostrarMenu() {
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a operação para Empresa:",
				"Menu de Operações", JOptionPane.PLAIN_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		executarOperacao(operacaoSelecionada);
	}

	private void executarOperacao(String operacao) {
		switch (operacao) {
		case "Inserir":
			Empresa novaEmpresa = empresaController.obterDadosEmpresa();
			empresaController.inserirEmpresa(novaEmpresa);
			break;

		case "Listar Todos":
			List<Empresa> todasAsEmpresas = empresaController.pesquisarTodos();
			empresaController.exibirEmpresas(todasAsEmpresas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser pesquisada:"));
			Empresa empresaPesquisada = empresaController.pesquisarUmEmpresa(idPesquisar);
			if (empresaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Empresa encontrada:\n" + empresaPesquisada.toString(),
						"Empresa Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser atualizada:"));
			Empresa empresaParaAtualizar = empresaController.pesquisarUmEmpresa(idAtualizar);
			if (empresaParaAtualizar != null) {
				Empresa dadosAtualizados = empresaController.obterDadosEmpresa();
				empresaParaAtualizar = empresaController.atualizarDadosEmpresa(empresaParaAtualizar, dadosAtualizados);
				empresaController.atualizar(empresaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser deletada:"));
			Empresa empresaParaDeletar = empresaController.pesquisarUmEmpresa(idDeletar);
			if (empresaParaDeletar != null) {
				empresaController.apagar(empresaParaDeletar);
				JOptionPane.showMessageDialog(null, "Empresa deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Empresa.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}
