package basestrong2.generic.base3;

public class UserDao {
	
	private Session session=new Session();

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
		return (User)session.get(User.class, id);
	}
	
}
