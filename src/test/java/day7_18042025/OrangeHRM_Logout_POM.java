package day7_18042025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_Logout_POM {
	
	WebDriver driver;
	
	public OrangeHRM_Logout_POM(WebDriver driver)
	{
		this.driver=driver;
	}

	//Repository
	By profile=By.className("oxd-userdropdown-tab");
	By logoutLink=By.xpath("//ul[@role='menu']/child::li[4]/child::a");
	
	public void clickOnProfile()
	{
		driver.findElement(profile).click();
	}
	
	public void clickOnLogoutLink()
	{
		driver.findElement(logoutLink).click();
	}
	
}
