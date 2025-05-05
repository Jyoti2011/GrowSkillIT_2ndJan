package day7;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import day7_18042025.OrangeHRM_Login_POM_PageFact;
import day7_18042025.OrangeHRM_Logout_POM;

public class CallingPOM {

	@Test
	public void executionMethod() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		OrangeHRM_Login_POM_PageFact lin=new OrangeHRM_Login_POM_PageFact(driver);
		OrangeHRM_Logout_POM lout=new OrangeHRM_Logout_POM(driver);
		
		lin.url();
		lin.enterUserName("Admin");
		lin.enterPassword("admin123");
		lin.clickOnLoginBTN();
		lout.clickOnProfile();
		lout.clickOnLogoutLink();
	}
}
