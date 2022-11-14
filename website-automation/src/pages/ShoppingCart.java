package pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class ShoppingCart //Shopping cart page
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public ShoppingCart(WebDriver driver) throws IOException
	{
		this.driver=driver;
        /*lf=new LoadFile();
		objpro=lf.loadFile();*/
		rp=new ReadProperties();
	}
	public void click_proceed() throws IOException //click proceed to checkout
	{
	
		String value=rp.checkout();//objpro.getProperty("CHECKOUT");
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
		//Reporter.log("shopping cart page loaded successfully");
		
	}
}

