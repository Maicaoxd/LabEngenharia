package dao;

import java.util.List;

import model.Consumidor;

public interface IConsumidorDao {

	public void inserir(Consumidor consumidor);

	public void atualizar(long id, Consumidor consumidor);

	public void remover(long id);

	public List<Consumidor> listar();

	public Consumidor pesquisarCPF(Long cpfConsumidor);

	public List<Consumidor> pesquisarNome(String nomeConsumidor);

}
