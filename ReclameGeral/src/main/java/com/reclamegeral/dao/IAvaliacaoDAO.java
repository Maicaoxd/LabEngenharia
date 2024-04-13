package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Avaliacao;

public interface IAvaliacaoDAO {

	void salvar(Avaliacao avaliacao);

	Avaliacao buscarPorId(Long id);

	void atualizar(Avaliacao avaliacao);

	void remover(Avaliacao avaliacao);

	List<Avaliacao> listarTodos();

	void fecharConexao();
}
