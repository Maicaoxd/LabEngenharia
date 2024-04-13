package com.reclamegeral.controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.PessoaDAO;
import com.reclamegeral.model.Pessoa;

public class PessoaController {
	private PessoaDAO pessoaDao = new PessoaDAO();

	public void inserirPessoa(Pessoa pessoa) {
		pessoaDao.salvar(pessoa);
	}

	public List<Pessoa> pesquisarTodos() {
		return pessoaDao.listarTodos();
	}

	public Pessoa pesquisarUmPessoa(Long id) {
		return pessoaDao.buscarPorId(id);
	}

	public void apagar(Pessoa pessoa) {
		pessoaDao.remover(pessoa);
	}

	public void atualizar(Pessoa pessoa) {
		pessoaDao.atualizar(pessoa);
	}

	public void exibirPessoas(List<Pessoa> pessoas) {
		StringBuilder sb = new StringBuilder();
		for (Pessoa pessoa : pessoas) {
			sb.append(pessoa.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Pessoas:\n" + sb.toString(), "Pessoas",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Pessoa atualizarDadosPessoa(Pessoa pessoaParaAtualizar, Pessoa dadosAtualizados) {
		pessoaParaAtualizar.setNome(dadosAtualizados.getNome());
		pessoaParaAtualizar.setEmail(dadosAtualizados.getEmail());
		pessoaParaAtualizar.setGenero(dadosAtualizados.getGenero());
		pessoaParaAtualizar.setBlackList(dadosAtualizados.isBlackList());
		pessoaParaAtualizar.setCpfCnpj(dadosAtualizados.getCpfCnpj());
		pessoaParaAtualizar.setNascimento(dadosAtualizados.getNascimento());
		pessoaParaAtualizar.setEstado(dadosAtualizados.getEstado());
		pessoaParaAtualizar.setCidade(dadosAtualizados.getCidade());
		pessoaParaAtualizar.setTelefone(dadosAtualizados.getTelefone());
		pessoaParaAtualizar.setSenha(dadosAtualizados.getSenha());
		return pessoaParaAtualizar;
	}

	public Pessoa obterDadosPessoa() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da pessoa:");
		String email = JOptionPane.showInputDialog(null, "Digite o e-mail da pessoa:");
		String genero = JOptionPane.showInputDialog(null, "Digite o gênero da pessoa:");
		boolean isBlackList = JOptionPane.showInputDialog(null, "A pessoa está na Black list? (true/false)")
				.equalsIgnoreCase("true");

		Long cpfCnpj = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o CPF/CNPJ da pessoa:"));
		LocalDate nascimento = LocalDate.parse(
				JOptionPane.showInputDialog(null, "Digite a data de nascimento da pessoa (no formato YYYY-MM-DD):"));
		String estado = JOptionPane.showInputDialog(null, "Digite o estado da pessoa:");
		String cidade = JOptionPane.showInputDialog(null, "Digite a cidade da pessoa:");
		String telefone = JOptionPane.showInputDialog(null, "Digite o telefone da pessoa:");
		String senha = JOptionPane.showInputDialog(null, "Digite a senha da pessoa:");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setGenero(genero);
		pessoa.setBlackList(isBlackList);
		pessoa.setCpfCnpj(cpfCnpj);
		pessoa.setNascimento(nascimento);
		pessoa.setEstado(estado);
		pessoa.setCidade(cidade);
		pessoa.setTelefone(telefone);
		pessoa.setSenha(senha);

		return pessoa;
	}
}
