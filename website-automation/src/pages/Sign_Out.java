package pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class Sign_Out //Sign-out page
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public Sign_Out(WebDriver driver) throws IOException
	{
		this.driver=driver;
	    rp=new ReadProperties();
	}
	public void click_signout() throws IOException//verify confirmation text 
	{
		String t = "Thank you, your order has been submitted";
	    if(driver.getPageSource().contains(t))
	    {
	    	System.out.println("Text : "+t+" is present");
	    }
	    else
	    {
	    	System.out.println("Text : "+t+" is not present,try again later");
	    }

		String value=rp.Sign_out();  
		driver.findElement(By.linkText(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()//verify title of the page
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("sign-out page loaded successfully");
		
	}

}
