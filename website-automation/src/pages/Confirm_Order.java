package pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class Confirm_Order 
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public Confirm_Order(WebDriver driver) throws IOException
	{
		this.driver=driver;
	    lf=new LoadFile();
		objpro=lf.loadFile();
		rp=new ReadProperties();
	}
	public void click_confirm() throws IOException//click confirm after the order is placed 
	{
		

		String value=rp.clickConfirm();
		driver.findElement(By.linkText(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("confirmation page is passed");
		
	}

}
