package basestrong2.generic.base6;

import java.lang.reflect.ParameterizedType;

public class BaseDao<T> {
	
	private Session session=new Session();	
	private Class clazz;
	//反射加泛型的实例
	public BaseDao(){
		//获取子类的类型   	class base6.BookDao
		System.out.println(this.getClass());		
		Class clazz2=this.getClass();
		
		//获取父类的参数化类型parameterizedType		BaseDao<Book>
		//base6.BaseDao<base6.Book>
		ParameterizedType parameterizedType=(ParameterizedType) clazz2.getGenericSuperclass();
		
		//获取实际class类型	 返回表示此类型实际类型参数的 Type 对象的数组。
		//class base6.Book
		clazz=(Class) parameterizedType.getActualTypeArguments()[0];
		
		
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
