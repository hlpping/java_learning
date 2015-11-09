package basestrong2.generic.base3;

//应用
public class App {
	public static void main(String[] args) {
		BookDao bookDao = new BookDao();
		Book book = new Book();
		//save
		bookDao.save(book);
		//query
		Book  book2=(Book) bookDao.get(1);
		
		//保存用户
		User user=new User();
		UserDao userDao =new UserDao();
		userDao.save(user);
	}
}
