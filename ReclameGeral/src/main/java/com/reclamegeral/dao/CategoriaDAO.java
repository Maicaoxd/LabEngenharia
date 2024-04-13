package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Categoria;
import com.reclamegeral.util.JPAUtil;

public class CategoriaDAO implements ICategoriaDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Categoria categoria) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(categoria);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	@Override
	public void atualizar(Categoria categoria) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(categoria);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Categoria categoria) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(categoria) ? categoria : em.merge(categoria));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Categoria> listarTodos() {
		return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
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
