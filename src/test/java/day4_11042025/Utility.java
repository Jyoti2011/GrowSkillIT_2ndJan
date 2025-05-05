package day4_11042025;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility extends ListenersDemo{
	
	
	public static void captureSS(String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Screenshots\\"+name+".jpeg");
		FileHandler.copy(src, dest);
	}

}
