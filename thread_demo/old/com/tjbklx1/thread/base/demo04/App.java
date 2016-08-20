package com.tjbklx1.thread.base.demo04;

public class App {
	public static void main(String[] args) {
		DataBase db = new DataBase();
		new Thread(new DBA(db)).start(); // 开启一个数据库管理员线程
		new Thread(new Developer(db)).start();
	}
}