package day8_19042025;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import day7_18042025.OrangeHRM_Login_POM_PageFact;
import day7_18042025.OrangeHRM_Logout_POM;

public class DataDrivenFrameworkDemo {
	
	@Test
	public void executionMethod() throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		OrangeHRM_Login_POM_PageFact lin=new OrangeHRM_Login_POM_PageFact(driver);
		OrangeHRM_Logout_POM lout=new OrangeHRM_Logout_POM(driver);
		
		lin.url();
		Thread.sleep(5000);
		
		String filePath="D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";		
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Data");
		
		int rows=sheet.getLastRowNum();
		System.out.println("Total Number of Rows: "+rows);
		
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell usernm=row.getCell(0);
			XSSFCell pass=row.getCell(1);
			
			System.out.println("UserName------->"+usernm+"          Password----->"+pass);
			try {
			lin.enterUserName(usernm.toString());
			lin.enterPassword(pass.toString());
			lin.clickOnLoginBTN();
			lout.clickOnProfile();
			lout.clickOnLogoutLink();
			System.out.println("Valid Data");
			}
			catch(Exception e)
			{
				System.out.println("Invalid Data");
			}
			
		}
		
		fis.close();
	}

}
