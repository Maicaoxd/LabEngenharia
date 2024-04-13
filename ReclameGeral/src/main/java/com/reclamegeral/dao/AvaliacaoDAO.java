package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Avaliacao;
import com.reclamegeral.util.JPAUtil;

public class AvaliacaoDAO implements IAvaliacaoDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Avaliacao avaliacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(avaliacao);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Avaliacao buscarPorId(Long id) {
		return em.find(Avaliacao.class, id);
	}

	@Override
	public void atualizar(Avaliacao avaliacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(avaliacao);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Avaliacao avaliacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(avaliacao) ? avaliacao : em.merge(avaliacao));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Avaliacao> listarTodos() {
		return em.createQuery("SELECT a FROM Avaliacao a", Avaliacao.class).getResultList();
	}

	@Override
	public void fecharConexao() {
		if (em != null) {
			em.close();
		}
		if (em != null) {
			em.close();
		}
	}

}
