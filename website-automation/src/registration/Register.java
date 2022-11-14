package registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Register {
  @Test
  public void register() throws IOException, InterruptedException 
  {
	  Properties objpro;
		WebDriver driver;
		Excel read=new Excel("E:\\Register2.xlsx");
		int rowcount=read.getRowCount(0);
		System.out.println(rowcount);
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
		driver.findElement(By.name(userid)).clear();
		driver.findElement(By.name(userid)).sendKeys(read.getData(0, i, 0));
		Thread.sleep(2000);
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys(read.getData(0, i, 1));
		Thread.sleep(2000);
		driver.findElement(By.name(rpassword)).clear();
		driver.findElement(By.name(rpassword)).sendKeys(read.getData(0, i, 2));
		Thread.sleep(2000);
		driver.findElement(By.name(firstname)).clear();
		driver.findElement(By.name(firstname)).sendKeys(read.getData(0, i, 3));
		Thread.sleep(2000);
		driver.findElement(By.name(lastname)).clear();
		driver.findElement(By.name(lastname)).sendKeys(read.getData(0, i, 4));
		Thread.sleep(2000);
		driver.findElement(By.name(email)).clear();
		driver.findElement(By.name(email)).sendKeys(read.getData(0, i, 5));
		Thread.sleep(2000);
		driver.findElement(By.name(phone)).clear();
		driver.findElement(By.name(phone)).sendKeys(read.getData(0, i, 6));
		Thread.sleep(2000);
		driver.findElement(By.name(address1)).clear();
		driver.findElement(By.name(address1)).sendKeys(read.getData(0, i, 7));
		Thread.sleep(2000);
		driver.findElement(By.name(address2)).clear();
		driver.findElement(By.name(address2)).sendKeys(read.getData(0, i, 8));
		Thread.sleep(2000);
		driver.findElement(By.name(city)).clear();
		driver.findElement(By.name(city)).sendKeys(read.getData(0, i, 9));
		Thread.sleep(2000);
		driver.findElement(By.name(state)).clear();
		driver.findElement(By.name(state)).sendKeys(read.getData(0, i, 10));
		Thread.sleep(2000);
		driver.findElement(By.name(zip)).clear();
		driver.findElement(By.name(zip)).sendKeys(read.getData(0, i, 11));
		Thread.sleep(2000);
		driver.findElement(By.name(country)).clear();
		driver.findElement(By.name(country)).sendKeys(read.getData(0, i, 12));
		Thread.sleep(2000);
		driver.findElement(By.name(save)).click();
		Thread.sleep(2000);
		System.out.println("user "+(i+1)+" registered");
		Reporter.log("user "+(i+1)+" registered");
		
		}
		
		driver.quit();
  }
}
