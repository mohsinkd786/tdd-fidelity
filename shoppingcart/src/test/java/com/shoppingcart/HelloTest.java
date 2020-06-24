package com.shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HelloTest {

	@Test
	void testSayHello() {
		Hello hello = new Hello();
		String msg = hello.sayHello();
		assertEquals(msg, "Hello");
	}
	
}
