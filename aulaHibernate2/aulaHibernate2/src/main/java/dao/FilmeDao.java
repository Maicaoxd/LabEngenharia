package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Filme;

public class FilmeDao implements IFilmeDao{

	EntityManagerFactory mf = Persistence.createEntityManagerFactory ("HibJPA");


	public Filme pesquisar(String filme) {
		return null;
	}

	public List<Filme> lista() {
		EntityManager em = mf.createEntityManager();
		List<Filme> filmes = em.createQuery("SELECT f FROM Filme f", Filme.class).getResultList();
		em.close();
		return filmes;
	}
	public List<Filme> apenasUmFilme (String titulo){
		EntityManager em = mf.createEntityManager();
		List<Filme> filmes = em.createQuery("SELECT f FROM Filme f WHERE f.titulo LIKE :titulo", Filme.class)
				.setParameter("titulo", "%" + titulo + "%")
				.getResultList();
		em.close();
		return filmes;
	}

	public void inserir(Filme filme) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
		em.close();
	}
	public void remover(long id) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		Filme filme = em.find(Filme.class, id);
		if (filme != null) {
			em.remove(filme);
		}
		em.getTransaction().commit();
		em.close();
	}

}
