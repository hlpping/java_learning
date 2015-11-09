package basestrong2.generic.base2;


/*
 *  底层代码
 * 模拟	hibernate中的session应用
 *   	Hibernate中的session对数据库执行crud操作
 */
public class Session {
	
	public void save(Object obj){
		System.out.println("保存到数据库");
	 }
	 
	 public void update(Object obj){
		System.out.println("更新到数据库");
	 }
	 
	 public void delete(Integer id){
		System.out.println("删除到数据库");
	 }
	 
	 /**
	  * get(Class clazz,Integer id)l
	  * 
	  * get(Person.class,1)
	  *   * 查询id=1的信息
	  *   * 查询的信息放置在javaBean==Person.class
	  */
	 public Object get(Class clazz,Integer id){
		System.out.println("通过id查询");
	    return null;       		
     }
}
