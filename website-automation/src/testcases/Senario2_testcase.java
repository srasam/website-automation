package testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configurationFiles.ReadProperties;
import pages.Browser;
import pages.LandingPage;
import pages.Multi_signIn;
import registration.Excel;

public class Senario2_testcase //sign-in and then select the product
{
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int rowcount;
	@BeforeTest
	public void browser() throws Exception
	{
		/*rp=new ReadProperties();
		System.setProperty("webdriver.edge.driver", rp.getEdgeDriver());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(rp.Url());*/
		Excel read=new Excel("E:\\Register2.xlsx");
		rowcount=read.getRowCount(0);
		System.out.println("Choose browser edge or firefox: ");
		Scanner sc=new Scanner(System.in);
		String browser=sc.next();
		
		Browser b=new Browser(driver);
		switch(browser)
		{
		case "edge":
			driver=b.verifyBrowser("edge");//edge driver
			
			Reporter.log("Edge Browser Launched");
			break;
			
		case "firefox":	
			driver=b.verifyBrowser("firefox");//fire fox
			Reporter.log("firefox Browser Launched");
			
			
			
			break;
		}
	}
		
	@Test(priority=0)
	public void landing_page() throws IOException 
	  {
		  LeftSideFish lf=new LeftSideFish(driver);
		  lf.landing();
	  }
	 @Test(priority=1)//selecting cat from image module
	  public void CatTest() throws IOException, InterruptedException 
	  {
		  CatImage ci=new CatImage(driver);
		
		  for(int i=0;i<rowcount;i++)
		  {
			  Multi_signIn m=new Multi_signIn(driver);
			  
				 m.SignIn(i);
			  Thread.sleep(1000);
			  ci.select_cat();
			 Thread.sleep(1000);
			 ci.product_page();
			 Thread.sleep(1000);
			 ci.item_id();
			 Thread.sleep(1000);
			 ci.add_to_cart();
			 Thread.sleep(1000);
			 ci.shopping_cart();
			 Thread.sleep(1000);
			 //lf.click_proceed();
			 ci.click_continue();
			 Thread.sleep(1000);
			 ci.click_confirm();
			 Thread.sleep(1000);
			 ci.click_sign_out();
			 Thread.sleep(1000);
			 
		  }
		  
		  
	  }
	
	 @Test(priority=1)//selecting bird from top module
	  public void BirdTest() throws IOException, InterruptedException 
	  {
		 TopModuleBird tb=new TopModuleBird(driver);
		
		  for(int i=0;i<rowcount;i++)
		  {
			  Multi_signIn m=new Multi_signIn(driver);
				 m.SignIn(i);
			  Thread.sleep(1000);
			  tb.select_bird();
			 Thread.sleep(1000);
			 tb.product_page();
			 Thread.sleep(1000);
			 tb.item_id();
			 Thread.sleep(1000);
			 tb.add_to_cart();
			 Thread.sleep(1000);
			 tb.shopping_cart();
			 Thread.sleep(1000);
			 
			 tb.click_continue();
			 Thread.sleep(1000);
			 tb.click_confirm();
			 Thread.sleep(1000);
			 tb.click_sign_out();
			 Thread.sleep(1000);
			 
		  }
		  
	  }
	 
	 @AfterTest
	  public void close()
	  {
		  driver.quit();
	  }
 
  
}
