package dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Consumidor;

public class ConsumidorDao implements IConsumidorDao {

	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");
	
	@Override
	public Consumidor pesquisar(String consumidor) {
		return null;
	}

	@Override
	public void inserir(Consumidor consumidor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(long id, Consumidor consumidor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Consumidor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consumidor> apenasUmConsumidor(String CPF) {
		// TODO Auto-generated method stub
		return null;
	}

}
