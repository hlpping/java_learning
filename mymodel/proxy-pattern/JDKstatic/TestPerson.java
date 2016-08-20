package JDKstatic;

public class TestPerson {
	public static void main(String args[]) {
		Person targetPerson = new PersonImpl();
		Person person = null;
		Object proxy = MyProxyFactory.getProxy(targetPerson);
		if (proxy instanceof Person) {
			person = (Person) proxy;
		}
		person.info();
		person.run();
	}
}