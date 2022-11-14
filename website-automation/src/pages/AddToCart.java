package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class AddToCart 
{
	WebDriver driver;
	
	ReadProperties rp;
	public AddToCart(WebDriver driver) throws IOException
	{
		this.driver=driver;
		rp=new ReadProperties();
	    
	}
public void click_addtocart() throws IOException//clicking add to cart 
{

	String value=rp.AddToCart();
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
	//Reporter.log("add to cart page is loaded successfully");
	
}

}
