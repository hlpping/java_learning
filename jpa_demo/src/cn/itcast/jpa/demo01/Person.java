package cn.itcast.jpa.demo01;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="persons")
public class Person {
	
	private Integer id;
	private String name;
	private Date birthDay;
	private Gender gender = Gender.MAN ;
	private String info;
	private Byte[] file;
	private String imagePath;
	
	@Id	@GeneratedValue       //(strategy=GenerationType.)			//属性,get方法,一般用get方法上
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=10,nullable=false,name="personName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Enumerated(EnumType.STRING) @Column(length=5,nullable=false)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Lob
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Lob @Basic(fetch=FetchType.LAZY)
	public Byte[] getFile() {
		return file;
	}
	public void setFile(Byte[] file) {
		this.file = file;
	}
	
	@Transient
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Person() {
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
