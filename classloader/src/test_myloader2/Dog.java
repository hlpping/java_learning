package test_myloader2;

public class Dog {
	public Dog() {
		System.out.println("Dog is loaded by : "
				+ this.getClass().getClassLoader());
	}
}