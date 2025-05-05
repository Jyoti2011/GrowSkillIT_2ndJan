package day5_14042025;

import org.testng.annotations.Test;

public class GroupsDemo {
	
	@Test(groups = {"mac.Smoke"})
	public void test1()
	{
		System.out.println("Test Case 1 {\"Smoke\"}");
	}
	
	@Test(groups = {"linux.Sanity"})
	public void test2()
	{
		System.out.println("Test Case 2 {\"Sanity\"}");
	}
	
	@Test(groups = {"Smoke", "Sanity"})
	public void test3()
	{
		System.out.println("Test Case 3 {\"Smoke\", \"Sanity\"}");
	}
	
	@Test(groups = {"windows.Regression"})
	public void test4()
	{
		System.out.println("Test Case 4 {\"Regression\"}");
	}
	
	@Test (groups = {"Smoke", "Regression"})
	public void test5()
	{
		System.out.println("Test Case 5 {\"Smoke\", \"Regression\"}");
	}
	
	@Test(groups = {"Sanity", "Regression"})
	public void test6()
	{
		System.out.println("Test Case 6 {\"Sanity\", \"Regression\"}");
	}
	
	@Test(groups = {"Smoke", "Sanity", "Regression"})
	public void test7()
	{
		System.out.println("Test Case 7 {\"Smoke\", \"Sanity\", \"Regression\"}");
	}
	
	@Test (groups = {"mac.Integration"})
	public void test8()
	{
		System.out.println("Test Case 8 {\"Integration\"}");
	}
	
	@Test (groups = {"Retest"})
	public void test9()
	{
		System.out.println("Test Case 9 {\"Retest\"}");
	}

}
