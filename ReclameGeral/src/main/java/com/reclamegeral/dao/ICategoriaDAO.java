package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Categoria;

public interface ICategoriaDAO {

	void salvar(Categoria categoria);

	Categoria buscarPorId(Long id);

	void atualizar(Categoria categoria);

	void remover(Categoria categoria);

	List<Categoria> listarTodos();

	void fecharConexao();
}
