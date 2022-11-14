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
import pages.AddToCart;
import pages.Browser;
import pages.Confirm_Order;
import pages.HomePage;
import pages.ItemIdPage;
import pages.LandingPage;
import pages.Multi_signIn;
import pages.Payment_Continue;
import pages.ProductPage;
import pages.ShoppingCart;
import pages.Sign_In_Page;
import pages.Sign_Out;
import registration.Excel;

public class TopModuleBird //selecting Top module Bird
{
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int i=0;
	
	public TopModuleBird()
	{
		
	}
	
	public TopModuleBird(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	@BeforeTest
	public void browser() throws Exception//choosing between browsers
	{
		
		System.out.println("Choose browser edge or firefox: ");
		Scanner sc=new Scanner(System.in);
		String browser=sc.next();
		
		Browser b=new Browser(driver);
		switch(browser)
		{
		case "edge":
			driver=b.verifyBrowser("edge");
			
			Reporter.log("Edge Browser Launched");
			break;
			
		case "firefox":	
			driver=b.verifyBrowser("firefox");
			Reporter.log("firefox Browser Launched");
			
			
			
			break;
		}
		
		
		/*rp=new ReadProperties();
		System.setProperty("webdriver.edge.driver", rp.getEdgeDriver());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(rp.Url());*/
		
	}
	@Test(priority=0)
	public void landing() throws InterruptedException, IOException//landing page
	{
		lp=new LandingPage(driver);
		//lp.enter_website();
		lp.click_enter_store();
		lp.getTitle();
		Thread.sleep(1000);
		Reporter.log("landing page loaded successfully...");
	}
	
	/*@Test(priority=1)
	public void sign_in() throws IOException, InterruptedException
	{
		Sign_In_Page si=new Sign_In_Page(driver);
		si.click_signin();
		si.SignIn();
		si.getTitle();
		Thread.sleep(1000);
	}*/
	@Test(priority=1)//sign in page
	public void multi_sign() throws IOException, InterruptedException
	{
		Multi_signIn ms=new Multi_signIn(driver);
		ms.click_signin();
		ms.SignIn(i);
		Reporter.log("sign-in page loaded successfully...");
		
		
	}
	@Test(priority=2)//clicking the bird from top module
	public void select_bird() throws IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickBird();
		hp.getTitle();
		Thread.sleep(1000);
		Reporter.log("home page loaded successfully...");
	}
	
	@Test(priority=3)//entering the product paeg
	public void product_page() throws IOException, InterruptedException
	{
		ProductPage fp=new ProductPage(driver);
		fp.bird_product_id();
		fp.getTitle();
		Reporter.log("product page loaded successfully...");
	}
	
	@Test(priority=4)//item id page
	public void item_id() throws IOException, InterruptedException
	{
		ItemIdPage ip=new ItemIdPage(driver);
		ip.bird_item_id();
		ip.getTitle();
		Reporter.log("item id page loaded successfully...");
	}
	@Test(priority=5)//add to cart page-clicking add to cart
	public void add_to_cart() throws IOException, InterruptedException
	{
		AddToCart ac=new AddToCart(driver);
		ac.click_addtocart();
		ac.getTitle();
		Thread.sleep(1000);
		Reporter.log("add to cart page loaded successfully...");
	}
	@Test(priority=6)//shopping cart page
	public void shopping_cart() throws IOException, InterruptedException
	{
		ShoppingCart sc=new ShoppingCart(driver);
		sc.click_proceed();
		sc.getTitle();
		Thread.sleep(1000);
		Reporter.log("shopping cart page loaded successfully...");
	}
	
	@Test(priority=7)//contains payment details
	public void click_continue() throws IOException, InterruptedException
	{
		Payment_Continue pc=new Payment_Continue(driver);
		pc.click_continue();
		pc.getTitle();
		Thread.sleep(1000);
		Reporter.log("payment page loaded successfully...");
	}
	@Test(priority=8)//verify thankyou text and confirm
	public void click_confirm() throws IOException, InterruptedException
	{
		Confirm_Order  co=new Confirm_Order (driver);
		co.click_confirm();
		co.getTitle();
		Thread.sleep(1000);
		Reporter.log("confirmation page loaded successfully...");
	}
	@Test(priority=9)//signout page
	public void click_sign_out() throws IOException, InterruptedException
	{
		Sign_Out  so=new Sign_Out(driver);
		so.click_signout();
		so.getTitle();
		Thread.sleep(1000);
		Reporter.log("sign-out page loaded successfully...");
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
  
}
