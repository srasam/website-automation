package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import configurationFiles.ReadProperties;

public class Browser //browsers edge and firefox
{
	WebDriver driver;
	ReadProperties rp;
	Properties objpro;
	public Browser(WebDriver driver) throws IOException
	{
		this.driver=driver;
		//this.objpro=objpro;
	}
	
	public WebDriver verifyBrowser(String browser) throws Exception
	{
		rp=new ReadProperties();
		String path=System.getProperty("user.dir");
		String edge=rp.getEdgeDriver();
		if(browser.equalsIgnoreCase("edge"))//for edge browser
		{
			System.setProperty("webdriver.edge.driver", path+edge);
			//System.setProperty("webdriver.edge.driver", path+);
			driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			
		}
		else if(browser.equalsIgnoreCase("firefox"))//for fire fox browser
		{
			rp=new ReadProperties();
			//String path1=System.getProperty("user.dir");
			String firefox=rp.FireFoxDriver();
			System.setProperty("webdriver.gecko.driver", path+firefox);
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			
		}
		else
		{
			throw new Exception("Browser not found");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
		
		
		
	}

}
