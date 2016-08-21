package cn.itcast.jpa.demo05.compositePK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class PKTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * 初始化
	 */
	@Test
	public void init() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		factory.close();
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(new AirLine("pek", "sha", "北京到上海"));
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
