package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Pessoa;

public interface IPessoaDAO {

	void salvar(Pessoa pessoa);

	Pessoa buscarPorId(Long id);

	void atualizar(Pessoa pessoa);

	void remover(Pessoa pessoa);

	List<Pessoa> listarTodos();

	void fecharConexao();
}
