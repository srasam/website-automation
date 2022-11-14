package registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import configurationFiles.ReadProperties;
import registration.Excel;

public class ReadExcel 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Properties objpro;
		WebDriver driver;
		Excel read=new Excel("E:\\Registration.xlsx");
		int rowcount=read.getRowCount(0);
		String path=System.getProperty("user.dir");
		File fi=new File(path+"\\Object Repository\\jpet.properties");
		FileInputStream fis=new FileInputStream(fi);
		
		objpro =new Properties();
		objpro.load(fis);
		
		String driverpath=objpro.getProperty("EDGEDRIVER");
		String url=objpro.getProperty("URL");
		String enterstore=objpro.getProperty("CLICKSTORE");
		String clicksignin=objpro.getProperty("CLICKSIGNIN");
		String clickregister=objpro.getProperty("REGISTER");
		
		String userid=objpro.getProperty("USERID");
		String password=objpro.getProperty("PASSWORD");
		String rpassword=objpro.getProperty("REPEATPASSWORD");
		String firstname=objpro.getProperty("FIRSTNAME");
		String lastname=objpro.getProperty("LASTNAME");
		String email=objpro.getProperty("EMAIL");
		String phone=objpro.getProperty("PHONE");
		String address1=objpro.getProperty("ADDRESS1");
		String address2=objpro.getProperty("ADDRESS2");
		String city=objpro.getProperty("CITY");
		String state=objpro.getProperty("STATE");
		String zip=objpro.getProperty("ZIP");
		String country=objpro.getProperty("COUNTRY");
		String save=objpro.getProperty("SAVEDETAILS");
		
		System.setProperty("webdriver.edge.driver",driverpath);
		driver=new EdgeDriver(); 
		driver.get(url);
		
		driver.findElement(By.linkText(enterstore)).click();
		Thread.sleep(2000);
		for(int i=0;i<rowcount;i++)
		{
		driver.findElement(By.linkText(clicksignin)).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(clickregister)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(userid)).sendKeys(read.getData(0, i, 0));
		Thread.sleep(2000);
		driver.findElement(By.name(password)).sendKeys(read.getData(0, i, 1));
		Thread.sleep(2000);
		driver.findElement(By.name(rpassword)).sendKeys(read.getData(0, i, 2));
		Thread.sleep(2000);
		driver.findElement(By.name(firstname)).sendKeys(read.getData(0, i, 3));
		Thread.sleep(2000);
		driver.findElement(By.name(lastname)).sendKeys(read.getData(0, i, 4));
		Thread.sleep(2000);
		driver.findElement(By.name(email)).sendKeys(read.getData(0, i, 5));
		Thread.sleep(2000);
		driver.findElement(By.name(phone)).sendKeys(read.getData(0, i, 6));
		Thread.sleep(2000);
		driver.findElement(By.name(address1)).sendKeys(read.getData(0, i, 7));
		Thread.sleep(2000);
		driver.findElement(By.name(address2)).sendKeys(read.getData(0, i, 8));
		Thread.sleep(2000);
		driver.findElement(By.name(city)).sendKeys(read.getData(0, i, 9));
		Thread.sleep(2000);
		driver.findElement(By.name(state)).sendKeys(read.getData(0, i, 10));
		Thread.sleep(2000);
		driver.findElement(By.name(zip)).sendKeys(read.getData(0, i, 11));
		Thread.sleep(2000);
		driver.findElement(By.name(country)).sendKeys(read.getData(0, i, 12));
		Thread.sleep(2000);
		driver.findElement(By.name(save)).sendKeys(read.getData(0, i, 13));
		Thread.sleep(2000);
		
		
		}
		
		driver.quit();
		
		

	
	}
}

	
	
