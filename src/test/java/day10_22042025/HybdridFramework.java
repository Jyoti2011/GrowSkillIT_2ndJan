package day10_22042025;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class HybdridFramework {
	
	@Test
	public void executionMethod() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		OrangeHRM_Login_POM_PageFact lin = new OrangeHRM_Login_POM_PageFact(driver);
		OrangeHRM_Logout_POM lout = new OrangeHRM_Logout_POM(driver);
		
		
		String filePath="D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";		
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet dataSheet=workbook.getSheet("Data");
		XSSFSheet keySheet = workbook.getSheet("Keyword");
		
		int dRows=dataSheet.getLastRowNum();
		System.out.println("Total Number of Data Rows: "+dRows);
		
		int kRows=keySheet.getLastRowNum();
		System.out.println("Total Number of Key Rows: "+kRows);
		
		for(int dr=1; dr<=dRows; dr++)
		{
			XSSFRow dRow=dataSheet.getRow(dr);
			XSSFCell usernm=dRow.getCell(0);
			XSSFCell pass=dRow.getCell(1);
			XSSFCell result=dRow.createCell(2);
			
			System.out.println("UserName------->"+usernm+"          Password----->"+pass);
			try {
			for(int kr=1; kr<=kRows; kr++)
			{
				XSSFRow kRow = keySheet.getRow(kr);
				XSSFCell key = kRow.getCell(1);
				XSSFCell match=kRow.createCell(2);
				
				System.out.println("Keywords-->" + key);
				
				switch (key.toString()) 
				{
				case "url":
					lin.url();
					System.out.println("Url Keyword is Matched");
					match.setCellValue("Url Keyword is Matched");
					break;
					
				case "enterUserName":
					lin.enterUserName(usernm.toString());
					System.out.println("enterUserName Keyword is Matched");
					match.setCellValue("enterUserName Keyword is Matched");
					break;
					
				case "enterPassword":
					lin.enterPassword(pass.toString());
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
			System.out.println("Valid Data");
			result.setCellValue("Valid Data");
			}
			catch(Exception e)
			{
				System.out.println("Invalid");
				result.setCellValue("Invalid Data");
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(filePath);
		workbook.write(fos);
	}

}
