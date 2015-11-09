package basestrong2.generic.base3;

public class BookDao {
	
	private Session session=new Session();
	
	public void save(Object obj){
		session.save(obj);
	}

	
	public Object get(int id) {		
		return (Book) session.get(Book.class,id);
	}
}
