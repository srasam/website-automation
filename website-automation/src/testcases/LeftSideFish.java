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
import registration.Excel;

public class LeftSideFish//selecting fish from left side module
{
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int i=0;
	
	
	public LeftSideFish()
	{
		
	}
	
	public LeftSideFish(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	@Test
	public void browser() throws IOException
	{
		rp=new ReadProperties();
		System.setProperty("webdriver.edge.driver", rp.getEdgeDriver());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(rp.Url());
	
		
	}
	 
	@Test(priority=0)//landing paeg
	public void landing() throws IOException
	{
		lp=new LandingPage(driver);
		lp.click_enter_store();//click enter the store
		lp.getTitle();
		System.out.println("landing page loaded successfully....");
		Reporter.log("landing page loaded successfully....");
	}
	@Test(priority=1)//home page
	public void home_page() throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickFish();//click on fish from left side module
		hp.getTitle();
		System.out.println("home page loaded successfully...");
		Reporter.log("home page loaded successfully...");
	}
	@Test(priority=2)//product page
	public void product_page() throws IOException
	{
		ProductPage fp=new ProductPage(driver);
		fp.fish_product_id();//selecting fish product id
		fp.getTitle();
		System.out.println("product page loaded successfully.....");
		Reporter.log("product page loaded successfully.....");
	}
	@Test(priority=3)//item id page
	public void item_id() throws IOException
	{
		ItemIdPage fi=new ItemIdPage(driver);
		fi.fish_item_id();//selecting fish item id
		fi.getTitle();
		System.out.println("item id page loaded successfully....");
		Reporter.log("item id page loaded successfully....");
	}
	@Test(priority=4)//add to cart page
	public void add_to_cart() throws IOException
	{
		AddToCart ac=new AddToCart(driver);
		ac.click_addtocart();//click add to cart
		ac.getTitle();
		System.out.println("add to cart page loaded successfully....");
		Reporter.log("add to cart page loaded successfully....");
	}
	@Test(priority=5)//shopping cart 
	public void shopping_cart() throws IOException
	{
		ShoppingCart sc=new ShoppingCart(driver);
		sc.click_proceed();//click proceed to checkout
		sc.getTitle();
		System.out.println("shopping cart page loaded successfully.....");
		Reporter.log("shopping cart page loaded successfully.....");
	}

	@Test(priority=6)//sign-in page
	public void multi_sign() throws IOException, InterruptedException
	{
		Multi_signIn ms=new Multi_signIn(driver);
		ms.click_signin();//click signin
		ms.SignIn(i);//entering uname,password and click login
		System.out.println("sign-in page loaded successfully....");
		Reporter.log("sign-in page loaded successfully....");
		
		
	}
	@Test(priority=7)//cart icon
	public void click_cart() throws IOException, InterruptedException
	{
		Click_cart_icon cc=new Click_cart_icon(driver);
		cc.click_cart();//click on cart icon
		System.out.println("cart icon is clicked successfully...");
		Reporter.log("cart icon is clicked successfully...");
		
	}
	@Test(priority=8)//proceed to checkout
	public void click_proceed() throws IOException, InterruptedException
	{
		ShoppingCart sc=new ShoppingCart(driver);
		sc.click_proceed();//click proceed to checkout
		System.out.println("shopping cart page loaded successfully...");
		Reporter.log("shopping cart page loaded successfully...");
		
	}
	@Test(priority=9)//payment page
	public void click_continue() throws IOException, InterruptedException
	{
		Payment_Continue pc=new Payment_Continue(driver);
		pc.click_continue();//clicking continue
		pc.getTitle();
		System.out.println("payment page loaded successfully....");
		Reporter.log("payment page loaded successfully....");
	}
	@Test(priority=10)//confirmation page
	public void click_confirm() throws IOException, InterruptedException
	{
		Confirm_Order  co=new Confirm_Order (driver);
		co.click_confirm();
		co.getTitle();
		System.out.println("confirmation page loaded successfully....");
		Reporter.log("confirmation page loaded successfully....");
	}
	@Test(priority=11)//sign-out
	public void click_sign_out() throws IOException, InterruptedException
	{
		Sign_Out  so=new Sign_Out(driver);
		so.click_signout();//click sign-out
		so.getTitle();
		System.out.println("clicked sign-out....");
		Reporter.log("clicked sign-out....");
	}
	
	
	
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
	
		
		
	
	
}
