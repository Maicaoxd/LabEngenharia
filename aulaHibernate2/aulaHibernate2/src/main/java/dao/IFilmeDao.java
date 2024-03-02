package dao;

import java.util.List;

import model.Filme;

public interface IFilmeDao {
	public Filme pesquisar(String filme) ;
	public void inserir(Filme filme) ;
	public void remover (long id) ;
	public List<Filme> lista(); 
	public List<Filme> apenasUmFilme (String titulo);

}
