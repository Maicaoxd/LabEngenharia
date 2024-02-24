package fronteira;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Filme;

public class Main {

	public static void main(String[] args) {
		Filme f1 = new Filme();
		f1.setNome("Era uma vez em hollywood...");
		f1.setNomeDiretor("Tarantino");

		EntityManagerFactory mf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = mf.createEntityManager();

		em.getTransaction().begin();
		em.persist(f1);
		em.getTransaction().commit();
	}

}
