package day5.dbutils;

public class Student {
	/*
	 *    	id INT,
		   sname VARCHAR(20),
		   les VARCHAR(20),
		   score INT
	 */
	private Integer id;
	private String sname;
	private String les;
	private Integer score;	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getLes() {
		return les;
	}



	public void setLes(String les) {
		this.les = les;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	/** 重写toString方法 */
	public String toString(){
		return "id:"+id+" sname:"+sname+" les:"+les+" score:"+score;
	}
}
