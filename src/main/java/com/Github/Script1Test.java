package com.Github;

import org.testng.annotations.Test;

public class Script1Test {
	
	@Test(groups = "SmokeTest")
	public void Sample1_test() {
		System.out.println("This is my sample project");
		System.out.println("Sample1");

	}
	
	@Test(groups = "RegressionTest")
	public void Sample2_test() {
		System.out.println("This is my sample2 project");
		System.out.println("Sample2");

	}
	
	@Test(groups = "SmokeTest")
	public void Sample3_test() {
		System.out.println("This is my sample3 project");
		System.out.println("Sample3");

	}
	@Test(groups = "SmokeTest")
	public void test()
	{
		System.out.println();
	}

	

}
