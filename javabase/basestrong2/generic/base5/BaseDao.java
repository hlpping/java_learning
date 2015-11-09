package basestrong2.generic.base5;

public class BaseDao<T> {
	
	private Session session=new Session();
	
	private Class clazz;
	
	public BaseDao(Class clazz){
		System.out.println("clazz :"+clazz);
		this.clazz=clazz;
	}	

	public void save(T obj) {
		session.save(obj);
	}
	
	public void update(T obj) {
		session.update(obj);
	}
	
	public void delete(Integer id) {
		session.delete(id);
	}

	public T get(Integer id) {
		return (T) session.get(clazz, id);
	}
}
