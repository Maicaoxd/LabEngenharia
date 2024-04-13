package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Pessoa;
import com.reclamegeral.util.JPAUtil;

public class PessoaDAO implements IPessoaDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Pessoa pessoa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(pessoa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		return em.find(Pessoa.class, id);
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(pessoa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Pessoa pessoa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Pessoa> listarTodos() {
		return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
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
