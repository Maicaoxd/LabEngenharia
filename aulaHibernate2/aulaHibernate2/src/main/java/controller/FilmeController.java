package controller;

import java.util.List;

import dao.FilmeDao;
import model.Filme;

public class FilmeController {
	
	private FilmeDao filmeDao = new FilmeDao();
	
	public void inserirFilme (Filme filme){
		filmeDao.inserir(filme);
	}
	
	public List<Filme> pesquisarTodos (){
		return filmeDao.lista();
	}
	public List<Filme> pesquisarUmFilme (String nome){
		return filmeDao.apenasUmFilme(nome);
	}
	
	public void apagar (long id) {
		filmeDao.remover(id);
	}

}
