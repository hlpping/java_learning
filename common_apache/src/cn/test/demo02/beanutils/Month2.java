package cn.test.demo02.beanutils;

public class Month2 {
	
	private int value;
	private String name;
	private int[] days = { 11, 22, 33, 44, 55 };

	public Month2() {
		
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public int[] getDays() {
		return days;
	}

	public void setDays(int[] is) {
		days = is;
	}

	public String toString() {
		return value + "(" + name + ")";
	}
	
}