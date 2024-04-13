package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Resposta;

public interface IRespostaDAO {

	void salvar(Resposta resposta);

	Resposta buscarPorId(Long id);

	void atualizar(Resposta resposta);

	void remover(Resposta resposta);

	List<Resposta> listarTodos();

	void fecharConexao();
}
