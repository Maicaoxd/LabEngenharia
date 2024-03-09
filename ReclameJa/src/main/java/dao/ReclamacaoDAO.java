package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Reclamacao;

public class ReclamacaoDAO implements IReclamacaoDao {
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");

	@Override
	public void inserir(Reclamacao reclamacao) {
		EntityManager em = mf.createEntityManager();
		em.getTransaction().begin();
		em.persist(reclamacao);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void atualizar(long id, Reclamacao reclamacao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reclamacao> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamacao> pesquisarCPF(String cpfReclamacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reclamacao pesquisarNome(String nomeReclamacao) {
		// TODO Auto-generated method stub
		return null;
	}

}
