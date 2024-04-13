package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Reclamacao;
import com.reclamegeral.util.JPAUtil;

public class ReclamacaoDAO implements IReclamacaoDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Reclamacao reclamacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(reclamacao);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Reclamacao buscarPorId(Long id) {
		return em.find(Reclamacao.class, id);
	}

	@Override
	public void atualizar(Reclamacao reclamacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(reclamacao);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Reclamacao reclamacao) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(reclamacao) ? reclamacao : em.merge(reclamacao));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Reclamacao> listarTodos() {
		return em.createQuery("SELECT r FROM Reclamacao r", Reclamacao.class).getResultList();
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
