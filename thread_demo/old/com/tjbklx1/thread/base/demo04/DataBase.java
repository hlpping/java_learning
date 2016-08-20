package com.tjbklx1.thread.base.demo04;

class DataBase {
	private String name;
	private String gender;
	private boolean update; // 这个变量用来标记数据是否是最新的

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}