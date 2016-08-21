package cn.itcast.jpa.demo03.one2one;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class OneToOneTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void init(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		factory.close();
	}
	
	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Personal personal = new Personal("miss zhang");
		IDCard idCard = new IDCard("2201002102");
		personal.setIdcard(idCard);
		
		em.persist(personal);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
