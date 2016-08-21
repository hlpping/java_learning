package cn.itcast.jpa.demo01;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void save(){
		//sessionFactory --> session -->begin
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		//开始事务
		em.getTransaction().begin();
		//save --> persist
		em.persist(new Person("传智播客2"));
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void getPerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		
		Person p = em.find(Person.class, 2);		//get
		
		System.out.println(p.getName());
		em.close();
		System.out.println(p.getName());
		factory.close();
	}
	
	@Test
	public void getPerson2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		
		Person p = em.getReference(Person.class, 1);		//load 懒加载
		
		System.out.println(p.getName());
		em.close();
		System.out.println(p.getName());
		factory.close();
	}
	
	
	//new 
	//managed 托管
	//游离 脱管
	//删除
	
	@Test
	public void updatePerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Person p = em.find(Person.class, 2);
		p.setName("update");
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void updatePerson2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Person p = em.find(Person.class, 2);
		em.clear();			//把实体管理器中所有实体变成游离状态
		p.setName("update2");
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void updatePerson3(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Person p = em.find(Person.class, 2);
		em.clear();			//把实体管理器中所有实体变成游离状态
		p.setName("update2");
		em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void deletePerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Person p = em.find(Person.class, 2);
		em.remove(p);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	//命名参数查询,位置参数查询(?1 索引值)
	
	
	
	@Test
	public void queryPerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select o from Person o where o.id = ?1");
		query.setParameter(1, 3);
		Person p = (Person) query.getSingleResult();
		System.out.println(p.getName());
		
		em.close();
		factory.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void queryPerson2(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select o from Person o where o.id=?1");
		query.setParameter(1, 1);
		List<Person> persons =  query.getResultList();
		for(Person p : persons){
			System.out.println(p.getName());
			
		}
		
		em.close();
		factory.close();
	}
	
	@Test
	public void updateQueryPerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("update Person o set o.name=:name where o.id=:id");
		query.setParameter("name","xxxx");
		query.setParameter("id", 3);
		query.executeUpdate();
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
	@Test
	public void deleteQueryPerson(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("delete from Person o where o.id=?1");
		query.setParameter(1, 3);
		query.executeUpdate();
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
}
