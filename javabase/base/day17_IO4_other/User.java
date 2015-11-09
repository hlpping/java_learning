package base.day17_IO4_other;

import java.io.Serializable;
//实现Serializable接口之后, 就可以被序列化, 就是可以被写出了.
@SuppressWarnings("serial")
public class User implements Serializable { 
	private String name;
	private String password;
	private String email;

	public User() {
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String toString() {
		return name + " : " + password + " : " + email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
