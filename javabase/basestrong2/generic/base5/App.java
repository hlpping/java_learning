package basestrong2.generic.base5;

//应用
public class App {
	public static void main(String[] args) {
//		test1();
		
		BookDao bookDao =new BookDao();
		Book book = new Book();
		bookDao.save(book);
		
		UserDao userDao =new UserDao();
		User user=new User();
		userDao.save(user);
		
		
		
		
		
	}

	private static void test1() {
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
