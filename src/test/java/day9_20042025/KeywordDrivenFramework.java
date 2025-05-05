package day9_20042025;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day7_18042025.OrangeHRM_Login_POM_PageFact;
import day7_18042025.OrangeHRM_Logout_POM;

public class KeywordDrivenFramework {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		OrangeHRM_Login_POM_PageFact lin = new OrangeHRM_Login_POM_PageFact(driver);
		OrangeHRM_Logout_POM lout = new OrangeHRM_Logout_POM(driver);

		String filePath = "D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Keyword");

		int rows = sheet.getLastRowNum();
		System.out.println("Total Number of Rows: " + rows);
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell key = row.getCell(1);

			System.out.println("Keywords-->" + key);

			switch (key.toString()) 
			{
			case "url":
				lin.url();
				System.out.println("Url Keyword is Matched");
				break;
				
			case "enterUserName":
				lin.enterUserName("Admin");
				System.out.println("enterUserName Keyword is Matched");
				break;
				
			case "enterPassword":
				lin.enterPassword("admin123");
				System.out.println("enterPassword Keyword is Matched");
				break;
				
			case "clickOnLoginBtn":
				lin.clickOnLoginBTN();
				System.out.println("clickOnLoginBtn Keyword is Matched");
				break;
				
			case "clickOnProfile":
				lout.clickOnProfile();
				System.out.println("clickOnProfile Keyword is Matched");
				break;
				
			case "clickOnLogoutLink":
				lout.clickOnLogoutLink();
				System.out.println("clickOnLogoutLink Keyword is Matched");
				break;
				
				default: System.out.println("Invalid Keyword");
			}
		}
		fis.close();
	}

}
