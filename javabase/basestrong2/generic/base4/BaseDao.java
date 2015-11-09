package basestrong2.generic.base4;

public class BaseDao {
	
	private Session session=new Session();
	
	private Class clazz;
	
	public BaseDao(Class clazz){
		System.out.println("clazz :"+clazz);
		this.clazz=clazz;
	}
	
	
	

	public void save(Object obj) {
		session.save(obj);
	}
	
	public void update(Object obj) {
		session.update(obj);
	}
	
	public void delete(Integer id) {
		session.delete(id);
	}

	public Object get(Integer id) {
		return session.get(clazz, id);
	}
}
