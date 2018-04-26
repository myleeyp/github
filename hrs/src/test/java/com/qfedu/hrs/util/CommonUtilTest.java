package com.qfedu.hrs.util;

import static com.qfedu.hrs.util.CommonUtil.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class CommonUtilTest {
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Before Class...");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("After class...");
	}

	@Before
	public void setUp() {
		System.out.println("Before...");
	}
	
	@After
	public void tearDown() {
		System.out.println("After...");
	}
	
	@Test(expected = java.lang.ArithmeticException.class)
	public void testDivide() {
		System.out.println(1 / 0);
	}
	
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testIndexOutOfBounds() {
		int[] a = new int[10];
		a[20] = 100;
	}
	
	@Test(expected = java.lang.AssertionError.class)
	public void testAssertionError() {
		assert 1 > 2;
	}
	
	@Test
	public void testRandomInt() {
		for (int i = 1; i <= 10000; ++i) {
			assertThat(randomInt(1, 100), allOf(
					greaterThanOrEqualTo(1), 
					lessThanOrEqualTo(100))
			);
		}
	}
	
	@Test
	public void testIsValidForTriangle() {
		assertTrue(isValidForTriangle(3, 4, 5));
		assertTrue(isValidForTriangle(3, 3, 3));
		assertFalse(isValidForTriangle(1, 2, 3));
	}

	@Test
	public void testAdd() {
		assertEquals(3, add(1, 2));
		assertEquals(5, add(3, 2));
		assertEquals(-5, add(-3, -2));
		assertEquals(1, add(3, -2));
		assertEquals(-1, add(-3, 2));
	}
	
	@Test
	public void testFactorial() {
		// out.println(0.1 + 0.2 + 0.3);
		// out.println(0.3 + 0.2 + 0.1);
		assertEquals(120.0, factorial(5), 0.01);
		assertEquals(1, factorial(0), 0.01);
		assertEquals(1, factorial(1), 0.01);
	}
}
