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

public class ItemIdPage 
{
	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public ItemIdPage(WebDriver driver) throws IOException
	{
		this.driver=driver;
        lf=new LoadFile();
		objpro=lf.loadFile();
		rp=new ReadProperties();
	}
	//items from left side module(FISH AND DOG)
	public void fish_item_id() throws IOException 
	{
	
		String value=rp.clickFishItemId();
		driver.findElement(By.linkText(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void dog_item_id() throws IOException 
	{
	
		String value=rp.clickDogItemId();
		driver.findElement(By.linkText(value)).click();//clicking the Dog item id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	//click item id of image pets(reptile and cats)
	public void reptile_item_id() throws IOException 
	{
	
		String value=rp.clickReptileItemId();
		driver.findElement(By.linkText(value)).click();//clicking the Dog item id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void cat_item_id() throws IOException 
	{
	
		String value=rp.clickCatItemId();
		driver.findElement(By.linkText(value)).click();//clicking the Dog item id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	//click item id of top module bird
	public void bird_item_id() throws IOException 
	{
	
		String value=rp.clickBirdItemId();
		driver.findElement(By.linkText(value)).click();//clicking the Dog item id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("item id page loaded successfully");
		
	}

}
