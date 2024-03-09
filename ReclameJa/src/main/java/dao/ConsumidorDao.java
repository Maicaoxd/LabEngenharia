package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Consumidor;

public class ConsumidorDao implements IConsumidorDao {

	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");

	@Override
	public void inserir(Consumidor consumidor) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(consumidor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(long id, Consumidor consumidor) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.merge(consumidor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Consumidor consumidor = em.find(Consumidor.class, id);
		if (consumidor != null) {
			em.remove(consumidor);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Consumidor> listar() {
		EntityManager em = mf.createEntityManager();
		List<Consumidor> consumidores = em.createQuery("SELECT c FROM Consumidor c", Consumidor.class).getResultList();
		em.close();
		return consumidores;
	}

	@Override
	public Consumidor pesquisarCPF(Long cpfConsumidor) {
		return null;
	}

	@Override
	public List<Consumidor> pesquisarNome(String nomeConsumidor) {
		EntityManager em = mf.createEntityManager();
		List<Consumidor> consumidores = em
				.createQuery("SELECT c FROM Consumidor c WHERE c.nome LIKE :nome", Consumidor.class)
				.setParameter("nome", "%" + nomeConsumidor + "%").getResultList();
		em.close();
		return consumidores;
	}

}
