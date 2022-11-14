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

public class ProductPage //Product page-contains the products of the selected pet
{

	WebDriver driver;
	Properties objpro;
	LoadFile lf;
	ReadProperties rp;
	public ProductPage(WebDriver driver) throws IOException
	{
		this.driver=driver;
        lf=new LoadFile();
		objpro=lf.loadFile();
		rp=new ReadProperties();
	}
	//product id of left side pets(fish and dog)
	public void fish_product_id() throws IOException 
	{
	/*String t=rp.VerifyFishText();
	String text=driver.findElement(By.linkText(t)).getText();
	System.out.println(text);*/
		String value=rp.clickFishProduct();//objpro.getProperty("LEFTFISHPRODUCTID");
		driver.findElement(By.linkText(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void dog_product_id() throws IOException 
	{
	
		String value=rp.clickDogProduct();//objpro.getProperty("LEFTDOGPRODUCTID");
		driver.findElement(By.linkText(value)).click();//clicking the dog product id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	//product id of image pets(reptiles and cats)
	public void reptile_product_id() throws IOException 
	{
	
		String value=rp.clickReptileProduct();
		driver.findElement(By.linkText(value)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void cats_product_id() throws IOException 
	{
	
		String value=rp.clickCatProduct();
		driver.findElement(By.linkText(value)).click();//clicking the dog product id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	//product id of top module pets
	public void bird_product_id() throws IOException 
	{
	
		String value=rp.clickBirdProduct();
		driver.findElement(By.linkText(value)).click();//clicking the dog product id
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void getTitle()
	{
		String expected="JPetStore Demo";
		String actual=driver.getTitle();//get the tile of the webpage
		Assert.assertEquals(actual, expected);
		System.out.println("Title of the page is : "+actual);
		Reporter.log("Title of the page is : "+actual);
		//Reporter.log("product page loaded successfully");
		
	}

}
