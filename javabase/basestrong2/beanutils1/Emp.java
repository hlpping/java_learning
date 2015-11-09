package basestrong2.beanutils1;

//po对象,这里值要保存到数据库中
public class Emp {
	private Integer id;
	private String name;
	private String sex;
	private String tel;
	
	//出生日期
	private java.sql.Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
}
