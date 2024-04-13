package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Usuario;

public interface IUsuarioDAO {

	void salvar(Usuario usuario);

	Usuario buscarPorId(Long id);

	void atualizar(Usuario usuario);

	void remover(Usuario usuario);

	List<Usuario> listarTodos();

	void fecharConexao();
}
