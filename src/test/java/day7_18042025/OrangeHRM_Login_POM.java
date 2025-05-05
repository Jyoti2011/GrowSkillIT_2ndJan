package day7_18042025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_Login_POM {
	
	WebDriver driver;
	
	
	public OrangeHRM_Login_POM(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	// Repository
	By usernm= By.name("username");
	By pass=By.name("password");
	By loginBtn= By.xpath("//button[@type='submit']");
	
	public void url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void enterUserName(String un)
	{
		driver.findElement(usernm).sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		driver.findElement(pass).sendKeys(pw);
	}
	
	public void clickOnLoginBTN() throws InterruptedException
	{
		driver.findElement(loginBtn).click();
		Thread.sleep(5000);
	}
}
