package pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class Payment_Continue //Payment Details Page
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public Payment_Continue(WebDriver driver) throws IOException
	{
		this.driver=driver;
	    rp=new ReadProperties();
	}
	public void click_continue() throws IOException //click continue in the payment page
	{

		String value=rp.paymentContinue();//objpro.getProperty("CONTINUE");
		driver.findElement(By.name(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("payment page loaded successfully");
		
	}

}
