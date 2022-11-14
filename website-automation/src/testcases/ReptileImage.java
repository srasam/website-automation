package testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configurationFiles.ReadProperties;
import pages.AddToCart;
import pages.Click_cart_icon;
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

public class ReptileImage 
{
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int i=0;
	public ReptileImage() {}
	public ReptileImage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@BeforeTest
	public void browser() throws IOException
	{
		rp=new ReadProperties();
		System.setProperty("webdriver.edge.driver", rp.getEdgeDriver());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(rp.Url());
		
	}
	@Test(priority=0)
	public void landing() throws InterruptedException, IOException
	{
		lp=new LandingPage(driver);
		lp.click_enter_store();
		lp.getTitle();
		Thread.sleep(1000);
		System.out.println("landing page loaded successfully....");
		Reporter.log("landing page loaded successfully....");
		
	}
	
	
	@Test(priority=1)
	public void multi_sign() throws IOException, InterruptedException
	{
		Multi_signIn ms=new Multi_signIn(driver);
		ms.click_signin();
		ms.SignIn(i);
		System.out.println("sign-in page loaded successfully....");
		Reporter.log("sign-in page loaded successfully....");
		
		
	}
	@Test(priority=2)
	public void select_reptile() throws IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickReptileImage();
		hp.getTitle();
		Thread.sleep(1000);
		System.out.println("home page loaded successfully....");
		Reporter.log("home page loaded successfully....");
	}
	
	@Test(priority=3)
	public void product_page() throws IOException, InterruptedException
	{
		ProductPage fp=new ProductPage(driver);
		fp.reptile_product_id();
		fp.getTitle();
		System.out.println("product page loaded successfully....");
		Reporter.log("product page loaded successfully.....");
	}
	
	@Test(priority=4)
	public void item_id() throws IOException, InterruptedException
	{
		ItemIdPage ip=new ItemIdPage(driver);
		ip.reptile_item_id();
		ip.getTitle();
		System.out.println("item id page loaded successfully....");
		Reporter.log("item id page loaded successfully....");
	}
	@Test(priority=5)
	public void add_to_cart() throws IOException, InterruptedException
	{
		AddToCart ac=new AddToCart(driver);
		ac.click_addtocart();
		ac.getTitle();
		Thread.sleep(1000);
		System.out.println("add to cart page loaded successfully....");
		Reporter.log("add to cart page loaded successfully....");
	}
	@Test(priority=6)
	public void shopping_cart() throws IOException, InterruptedException
	{
		ShoppingCart sc=new ShoppingCart(driver);
		sc.click_proceed();
		sc.getTitle();
		Thread.sleep(1000);
		System.out.println("shopping page loaded successfully....");
		Reporter.log("shopping cart page loaded successfully....");
	}
	
	@Test(priority=7)
	public void click_continue() throws IOException, InterruptedException
	{
		Payment_Continue pc=new Payment_Continue(driver);
		pc.click_continue();
		pc.getTitle();
		Thread.sleep(1000);
		System.out.println("payment page loaded successfully....");
		Reporter.log("payment page loaded successfully....");
	}
	@Test(priority=8)
	public void click_confirm() throws IOException, InterruptedException
	{
		Confirm_Order  co=new Confirm_Order (driver);
		co.click_confirm();
		co.getTitle();
		Thread.sleep(1000);
		System.out.println("confirmation page loaded successfully....");
		Reporter.log("confirmation page loaded successfully.....");
	}
	@Test(priority=9)
	public void click_sign_out() throws IOException, InterruptedException
	{
		Sign_Out  so=new Sign_Out(driver);
		so.click_signout();
		so.getTitle();
		Thread.sleep(1000);
		System.out.println("sign-in page loaded successfully....");
		Reporter.log("sign-out page loaded successfully.....");
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
  
}
