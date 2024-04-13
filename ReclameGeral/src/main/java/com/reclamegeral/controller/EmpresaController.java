package com.reclamegeral.controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.EmpresaDAO;
import com.reclamegeral.model.Empresa;

public class EmpresaController {
	private EmpresaDAO empresaDao = new EmpresaDAO();

	public void inserirEmpresa(Empresa empresa) {
		empresaDao.salvar(empresa);
	}

	public List<Empresa> pesquisarTodos() {
		return empresaDao.listarTodos();
	}

	public Empresa pesquisarUmEmpresa(Long id) {
		return empresaDao.buscarPorId(id);
	}

	public void apagar(Empresa empresa) {
		empresaDao.remover(empresa);
	}

	public void atualizar(Empresa empresa) {
		empresaDao.atualizar(empresa);
	}

	public void exibirEmpresas(List<Empresa> empresas) {
		StringBuilder sb = new StringBuilder();
		for (Empresa empresa : empresas) {
			sb.append(empresa.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Empresas:\n" + sb.toString(), "Empresas",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Empresa obterDadosEmpresa() {
		String nomeFantasia = JOptionPane.showInputDialog(null, "Digite o nome fantasia da empresa:");
		String sobre = JOptionPane.showInputDialog(null, "Digite uma descrição sobre a empresa:");
		Long cpfCnpj = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o CPF/CNPJ da empresa:"));
		LocalDate nascimento = LocalDate.parse(
				JOptionPane.showInputDialog(null, "Digite a data de fundação da empresa (no formato YYYY-MM-DD):"));

		String nome = JOptionPane.showInputDialog(null, "Digite o nome do responsável:");
		String email = JOptionPane.showInputDialog(null, "Digite o e-mail do responsável:");
		String estado = JOptionPane.showInputDialog(null, "Digite o estado da empresa:");
		String cidade = JOptionPane.showInputDialog(null, "Digite a cidade da empresa:");
		String telefone = JOptionPane.showInputDialog(null, "Digite o telefone da empresa:");
		String senha = JOptionPane.showInputDialog(null, "Digite a senha da empresa:");

		Empresa empresa = new Empresa();
		empresa.setNomeFantasia(nomeFantasia);
		empresa.setSobre(sobre);
		empresa.setCpfCnpj(cpfCnpj);
		empresa.setNascimento(nascimento);
		empresa.setNome(nome);
		empresa.setEmail(email);
		empresa.setEstado(estado);
		empresa.setCidade(cidade);
		empresa.setTelefone(telefone);
		empresa.setSenha(senha);

		return empresa;
	}

	public Empresa atualizarDadosEmpresa(Empresa empresaParaAtualizar, Empresa dadosAtualizados) {
		empresaParaAtualizar.setNomeFantasia(dadosAtualizados.getNomeFantasia());
		empresaParaAtualizar.setSobre(dadosAtualizados.getSobre());
		empresaParaAtualizar.setCpfCnpj(dadosAtualizados.getCpfCnpj());
		empresaParaAtualizar.setNascimento(dadosAtualizados.getNascimento());
		empresaParaAtualizar.setNome(dadosAtualizados.getNome());
		empresaParaAtualizar.setEmail(dadosAtualizados.getEmail());
		empresaParaAtualizar.setEstado(dadosAtualizados.getEstado());
		empresaParaAtualizar.setCidade(dadosAtualizados.getCidade());
		empresaParaAtualizar.setTelefone(dadosAtualizados.getTelefone());
		empresaParaAtualizar.setSenha(dadosAtualizados.getSenha());

		return empresaParaAtualizar;
	}
}
