package cn.itcast.jpa.demo04.many2many;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class ManyToManyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	/**
	 * 初始化
	 */
	@Test
	public void init(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		factory.close();
	}
	/**
	 * 保存老师学生
	 */
	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(new Student("Miss zhang"));
		em.persist(new Teacher("Miss wang"));
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	/**
	 * 建立师生关系
	 */
	@Test
	public void buildTS(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		student.addTeacher(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	/**
	 * 解除师生关系
	 */
	@Test
	public void deleteTS(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		student.removeTeacher(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	/**
	 * 删除老师
	 */
	@Test
	public void deleteTeacher(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		
		student.removeTeacher(teacher);
		em.remove(teacher);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	/**
	 * 删除学生
	 */
	@Test
	public void deleteStudent(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		
		student.removeTeacher(teacher);
		em.remove(student);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
