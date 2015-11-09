package basestrong.singleton;

import basestrong.enumsave.City;

public class SingletonDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Person p1=Person.p;
//		Person p2=Person.p;
//		System.out.println(p1==p2);
		
//		Person p1=Person.instance();
//		Person p2=Person.instance();
//		System.out.println(p1==p2);
		
//		Gender g1=Gender.getMale();
//		Gender g2=Gender.getMale();
//		System.out.println(g1==g2);
//		
//		Gender g3=Gender.getFemale();
//		System.out.println(g1==g3);
		
		City c1=City.getCity("bj");
		City c2=City.getCity("bj");
		City c3=City.getCity("sh");
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		
	}

}
