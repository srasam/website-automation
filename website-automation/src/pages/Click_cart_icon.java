package pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;

public class Click_cart_icon 
{
	WebDriver driver;
ReadProperties rp;
public Click_cart_icon(WebDriver driver) throws IOException
{
	this.driver=driver;
    rp=new ReadProperties();
}
public void click_cart() throws IOException//clicking the cart icon when page redirects to homepage after sign-in 
{

	String value=rp.cart();
	driver.findElement(By.name(value)).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Reporter.log("clicked on cart icon");
}


}
