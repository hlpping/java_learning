package com.test1;

public class A {

	static B b;

	public static void f1() {
		System.out.println("A f1");
		b.f1();
	}

	public static void main(String[] args) {
		A.f1();
	}
}