package testcases;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import configurationFiles.ReadProperties;

public class ScreenShot {
	WebDriver driver;
	public static ReadProperties rp;

	
	@Test
	public static void captureScreenMethod() throws Exception{
		
	rp=new ReadProperties();
		String path=System.getProperty("user.dir");
		String edge=rp.getEdgeDriver();
	}
				
	
}
