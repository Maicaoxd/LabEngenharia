package com.reclamegeral.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.CategoriaDAO;
import com.reclamegeral.model.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDao = new CategoriaDAO();

	public void inserirCategoria(Categoria categoria) {
		categoriaDao.salvar(categoria);
	}

	public List<Categoria> pesquisarTodos() {
		return categoriaDao.listarTodos();
	}

	public Categoria pesquisarUmCategoria(Long id) {
		return categoriaDao.buscarPorId(id);
	}

	public void apagar(Categoria categoria) {
		categoriaDao.remover(categoria);
	}

	public void atualizar(Categoria categoria) {
		categoriaDao.atualizar(categoria);
	}

	public void exibirCategorias(List<Categoria> categorias) {
		StringBuilder sb = new StringBuilder();
		for (Categoria categoria : categorias) {
			sb.append(categoria.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(null, "Lista de Categorias:\n" + sb.toString(), "Categorias",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Categoria obterDadosCategoria() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da categoria:");

		Categoria categoria = new Categoria();
		categoria.setNome(nome);

		return categoria;
	}

	public Categoria atualizarDadosCategoria(Categoria categoriaParaAtualizar, Categoria dadosAtualizados) {
		categoriaParaAtualizar.setNome(dadosAtualizados.getNome());

		return categoriaParaAtualizar;
	}

}
