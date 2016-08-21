package cn.itcast.jpa.demo02.one2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;


public class OneToManyTest {
	
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
		
		Order order = new Order();
		order.setAmount(20f);
		order.setOrderid("100");
		
		OrderItem item01 = new OrderItem();
		item01.setProductName("basketball");
		item01.setSellPrice(100f);
		
		OrderItem item02 = new OrderItem();
		item02.setProductName("football");
		item02.setSellPrice(50f);
		
		order.addOrderItem(item01);
		order.addOrderItem(item02);
		
		em.persist(order);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
