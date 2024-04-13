package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Empresa;

public interface IEmpresaDAO {

	void salvar(Empresa empresa);

	Empresa buscarPorId(Long id);

	void atualizar(Empresa empresa);

	void remover(Empresa empresa);

	List<Empresa> listarTodos();

	void fecharConexao();
}
