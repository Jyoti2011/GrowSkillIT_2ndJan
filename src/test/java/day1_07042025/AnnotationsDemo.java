package day1_07042025;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {
	
	
	
	@BeforeClass
	public void beforeClassMethod()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethodMethod()
	{
		System.out.println("Before Method");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test 2");
	}
	
	@AfterMethod
	public void afterMethodMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClassMethod()
	{
		System.out.println("After Class");
	}
	
	@AfterTest
	public void afterTestMethod()
	{
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuiteMethod()
	{
		System.out.println("After Suite");
	}
	@BeforeSuite
	public void beforeSuiteMethod()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTestMethod()
	{
		System.out.println("Before Test");
	}
}
