package day7_18042025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Login_POM_PageFact {
	
	WebDriver driver;
	
	
	public OrangeHRM_Login_POM_PageFact(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);		
	}
	
	// Repository
	@FindBy (name="username") WebElement usernm;
	@FindBy (name="password") WebElement pass;
	@FindBy (xpath="//button[@type='submit']") WebElement loginBtn;
	
	
	public void url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void enterUserName(String un)
	{
		usernm.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		pass.sendKeys(pw);
	}
	
	public void clickOnLoginBTN() throws InterruptedException
	{
		loginBtn.click();
		Thread.sleep(5000);
	}
}
