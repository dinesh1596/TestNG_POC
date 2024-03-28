package com.test;

import org.junit.*;

public class Practice {
	@BeforeClass
	public  static void beforeClass() {
		System.out.println("BeforeClass");
	}

public  void before() {
	System.out.println("before");
}


@Test
public void test() {
	System.out.println("test");
}
@Test
public void test1() {
	System.out.println("test1");
}
@Test
public void test2() {
	System.out.println("test2");
}
@AfterClass
public static  void afterClass() {
	System.out.println("AfterClass");
}
@After
public  void after() {
	System.out.println("after");
}
}
