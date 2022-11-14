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

public class HomePage 
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public HomePage(WebDriver driver) throws IOException
	{
		this.driver=driver;
		/*lf=new LoadFile();
		objpro=lf.loadFile();*/
		rp=new ReadProperties();
	}
	//pets selected from left side module
	public void clickFish() throws IOException //Click on Left side Fish
	{
	
		String value=rp.clickFish();//objpro.getProperty("LEFTFISH");
		driver.findElement(By.xpath(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		Reporter.log("clicked on fish from left module");
	}
	public void clickDog() throws IOException //Click on Left side Dog
	{
	
		String value=rp.clickDog();//objpro.getProperty("LEFTDOG");
		driver.findElement(By.xpath(value)).click();//selecting the dog from left side panel
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Reporter.log("clicked on dog from left module");
	}
	
	//pet selected by clicking on images
	
	public void clickReptileImage() throws IOException //Click on reptile image
	{
	
		//String value=objpro.getProperty("REPTILEIMAGE");
		
		String value=rp.clickReptile();
		driver.findElement(By.xpath(value)).click();//selecting the dog from left side panel
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Reporter.log("clicked on reptile image");
		
	}
	public void clickCatImage() throws IOException //Click on cat image
	{
	
		String value=rp.clickCat();
		driver.findElement(By.xpath(value)).click();//selecting the dog from left side panel
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Reporter.log("clicked on cat image");
	}
	
	//pets selected from top module
	public void clickBird() throws IOException //Click on bird
	{
	
		String value=rp.clickBirds();
		driver.findElement(By.xpath(value)).click();//selecting the dog from left side panel
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Reporter.log("selected bird from top module ");
	}
	
	
	public void getTitle()//getting the title of the web page
	{
		
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		Reporter.log("homepage page is loaded successfully");
		
	}

}
