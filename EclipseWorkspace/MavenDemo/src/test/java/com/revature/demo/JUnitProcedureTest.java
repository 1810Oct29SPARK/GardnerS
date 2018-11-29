package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitProcedureTest {

// executes before each test
	
	@AfterClass
	public static void afterTests() {
		System.out.println("in afterTests");
	}
	
	@BeforeClass
	public static void beforeTests() {
		System.out.println("in beforeTests");
	}
	@Ignore
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	@Test
	public void testCase21() {
		fail();
		System.out.println("in testCase21");
	}

}
