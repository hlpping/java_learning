package com.test1;

import com.test2.C;

public class B {
	static C c;

	public static void f1() {
		System.out.println("B f1");
		c.f1();
	}
}