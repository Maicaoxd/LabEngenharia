package dao;

import java.util.List;

import model.Consumidor;

public interface IConsumidorDao {
	public Consumidor pesquisar(String consumidor);

	public void inserir(Consumidor consumidor);

	public void atualizar(long id, Consumidor consumidor);

	public void remover(long id);

	public List<Consumidor> listar();

	public List<Consumidor> apenasUmConsumidor(String CPF);

}
