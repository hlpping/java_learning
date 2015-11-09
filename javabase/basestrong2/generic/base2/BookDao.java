package basestrong2.generic.base2;

public class BookDao {
	
	private Session session=new Session();
	
	public void save(Book book){
		session.save(book);
	}

	
	public Book get(int id) {		
		return (Book) session.get(Book.class,id);
	}
}
