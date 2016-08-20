package cn.test.reflect.demo05;

import java.util.Date;

public class Student {

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(int id, String name, Date bir) {
		this.id = id;
		this.name = name;
		this.birthday = bir;
	}

	private int id;
	private String name;
	private Date birthday;

	public String getMessage() {
		return id + "\t" + name + "\t" + birthday;
	}

	private void getNull() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
