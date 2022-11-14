package testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configurationFiles.ReadProperties;
import pages.Browser;
import pages.LandingPage;
import pages.Multi_signIn;
import registration.Excel;

public class Senario1_testcase {//selecting the product and then sign-in
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int rowcount;
	@BeforeTest
	public void browser() throws Exception//choosing browsers
	{
	
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
		  System.out.println("landing page loaded");
	  }
  @Test(priority=1)
  public void FishTest() throws IOException, InterruptedException //Testing Left side Fish 
  {
	  LeftSideFish lf=new LeftSideFish(driver);
	  for(int i=0;i<rowcount;i++)
	  {
		 
		 lf.home_page();
		 Thread.sleep(1000);
		 
		 lf.product_page();
		 Thread.sleep(1000);
		 
		 lf.item_id();
		 Thread.sleep(1000);
		 lf.add_to_cart();
		 Thread.sleep(1000);
		 lf.shopping_cart();
		 Thread.sleep(1000);
	
		 Multi_signIn m=new Multi_signIn(driver);
		 m.SignIn(i);
		 //lf.multi_sign(i);
		 Thread.sleep(1000);
		 lf.click_cart();
		 Thread.sleep(1000);
		 lf.click_proceed();
		 Thread.sleep(1000);
		 lf.click_continue();
		 Thread.sleep(1000);
		 lf.click_confirm();
		 Thread.sleep(1000);
		 lf.click_sign_out();
		 Thread.sleep(1000);
		 
	  }
	  
	  
  }
  @Test(priority=2)//Testing left side dog
  public void DogTest() throws IOException, InterruptedException 
  {
	  LeftSideDog ld=new LeftSideDog(driver);
	  for(int i=0;i<rowcount;i++)
	  {
		 
		 ld.select_dog();
		 Thread.sleep(1000);
		 ld.product_page();
		 Thread.sleep(1000);
		 ld.item_id();
		 Thread.sleep(1000);
		 ld.add_to_cart();
		 Thread.sleep(1000);
		 ld.shopping_cart();
		 Thread.sleep(1000);
		 //lf.click_proceed();
		 //ld.multi_sign(i);
		 Multi_signIn m=new Multi_signIn(driver);
		 m.SignIn(i);
		 Thread.sleep(1000);
		 ld.click_cart();
		 Thread.sleep(1000);
		 ld.click_proceed();
		 Thread.sleep(1000);
		 ld.click_continue();
		 Thread.sleep(1000);
		 ld.click_confirm();
		 Thread.sleep(1000);
		 ld.click_sign_out();
		 Thread.sleep(1000);
		 
	  }
	  
	  
  }
 
  
  @AfterTest
  public void close()
  {
	  driver.quit();
  }
}
