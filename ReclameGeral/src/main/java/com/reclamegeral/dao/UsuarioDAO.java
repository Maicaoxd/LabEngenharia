package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Usuario;
import com.reclamegeral.util.JPAUtil;

public class UsuarioDAO implements IUsuarioDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void atualizar(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> listarTodos() {
		return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
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
