package basestrong2.generic.base2;

public class UserDao {
	
	private Session session=new Session();

	public void save(User user) {
		session.save(user);
	}
	
	public void update(User user) {
		session.update(user);
	}
	
	public void delete(Integer id) {
		session.delete(id);
	}

	public User get(Integer id) {
		return (User)session.get(User.class, id);
	}
	
}
