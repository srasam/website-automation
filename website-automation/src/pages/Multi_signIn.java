package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import configurationFiles.ReadProperties;
import registration.Excel;

public class Multi_signIn //Sign in for multiple users
{
	Properties objpro;
	WebDriver driver;
	LoadFile lf;
	ReadProperties rp;
	public Multi_signIn(WebDriver driver) throws IOException
	{
		this.driver=driver;
		rp=new ReadProperties();
		
	}
	public void click_signin()
	{
		String value=rp.Signin();
		driver.findElement(By.linkText(value)).click();
	}
	
	public void SignIn(int i) throws IOException, InterruptedException
	{
		String value=rp.Signin();
		driver.findElement(By.linkText(value)).click();
		Excel read=new Excel("E:\\Register2.xlsx");
		//int rowcount=read.getRowCount(0);
		//System.out.println(rowcount);
		String uname=rp.username();
		String password=rp.password();
		String clicklogin=rp.clickLogin();
		
		
		
		
		driver.findElement(By.name(uname)).clear();
		driver.findElement(By.name(uname)).sendKeys(read.getData(0, i, 0));
		Thread.sleep(2000);
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(read.getData(0, i, 1));
		Thread.sleep(2000);
		driver.findElement(By.name(clicklogin)).click();
		Thread.sleep(2000);
		
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("sign-in page loaded successfully");
		
	}

}
