package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Empresa;
import com.reclamegeral.util.JPAUtil;

public class EmpresaDAO implements IEmpresaDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Empresa empresa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(empresa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Empresa buscarPorId(Long id) {
		return em.find(Empresa.class, id);
	}

	@Override
	public void atualizar(Empresa empresa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(empresa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Empresa empresa) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(empresa) ? empresa : em.merge(empresa));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Empresa> listarTodos() {
		return em.createQuery("SELECT e FROM Empresa e", Empresa.class).getResultList();
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
