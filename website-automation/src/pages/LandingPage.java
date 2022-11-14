package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class LandingPage //Landing page,here we click enter the store
{
	WebDriver driver;
	ReadProperties rp;
	Properties objpro;
	LoadFile lf;
	
	public LandingPage(WebDriver driver) throws IOException  
	{
		this.driver=driver;
		rp=new ReadProperties();
		
	}
	/*public void enter_website()
	{
		String url=objpro.getProperty("URL");
		driver.get(url);
	}*/
	
	
	public void click_enter_store() //click enter the store 
	{
		String url=rp.Url();
	    driver.get(url);
		String enter=rp.EnterStore();
		driver.findElement(By.linkText(enter)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("landing page is loaded successfully");
		
	}
	
	
}
