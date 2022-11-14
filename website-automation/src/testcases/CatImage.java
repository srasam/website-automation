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

public class CatImage 
{
	WebDriver driver;
	LandingPage lp;
	ReadProperties rp;
	Properties objpro;
	int i=0;
	public CatImage()
	{
		
	}
	
	public CatImage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	@BeforeTest
	public void browser() throws IOException//open browser
	{
		rp=new ReadProperties();
		System.setProperty("webdriver.edge.driver", rp.getEdgeDriver());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(rp.Url());
		
	}
	@Test(priority=0)//landing page
	public void landing() throws InterruptedException, IOException
	{
		lp=new LandingPage(driver);
		lp.click_enter_store();
		lp.getTitle();
		Thread.sleep(1000);
		System.out.println("landing page loaded successfully....");
		Reporter.log("landing page loaded successfully....");
		
		
	}
	
	
	@Test(priority=1)//sign-in page
	public void multi_sign() throws IOException, InterruptedException
	{
		Multi_signIn ms=new Multi_signIn(driver);
		ms.click_signin();//click sign-in
		ms.SignIn(i);//entering details uname,password and clcik login
		System.out.println("sign-in page loaded successfully....");
		Reporter.log("sign-in loaded successfully....");
		
		
	}
	@Test(priority=2)//homepage-selecting cat image fromhome page
	public void select_cat() throws IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickCatImage();//click on cat image
		hp.getTitle();
		Thread.sleep(1000);
		System.out.println("home page loaded successfully....");
		Reporter.log("home page loaded successfully");
	}
	
	@Test(priority=3)
	public void product_page() throws IOException, InterruptedException
	{
		ProductPage fp=new ProductPage(driver);
		fp.cats_product_id();//click on cat product id
		fp.getTitle();
		System.out.println("product page loaded successfully....");
		Reporter.log("product page loaded successfully");
	}
	
	@Test(priority=4)//item id page
	public void item_id() throws IOException, InterruptedException
	{
		ItemIdPage ip=new ItemIdPage(driver);
		ip.cat_item_id();//click on item id of cat
		ip.getTitle();
		System.out.println("item id page loaded successfully....");
		Reporter.log("item id page loaded successfully");
	}
	@Test(priority=5)//add to cart page
	public void add_to_cart() throws IOException, InterruptedException
	{
		AddToCart ac=new AddToCart(driver);
		ac.click_addtocart();//click add to cart
		ac.getTitle();
		Thread.sleep(1000);
		System.out.println("add to cart page loaded successfully....");
		Reporter.log("add to cat page loaded successfully");
	}
	@Test(priority=6)//shopping cart page
	public void shopping_cart() throws IOException, InterruptedException
	{
		ShoppingCart sc=new ShoppingCart(driver);
		sc.click_proceed();//click on proceed
		sc.getTitle();//get the title of the page
		Thread.sleep(1000);
		System.out.println("shopping cart page loaded successfully....");
		Reporter.log("shopping cart page loaded successfully");
	}
	
	@Test(priority=7)//payment page
	public void click_continue() throws IOException, InterruptedException
	{
		Payment_Continue pc=new Payment_Continue(driver);
		pc.click_continue();//click on continue
		pc.getTitle();
		Thread.sleep(1000);
		System.out.println("payment page loaded successfully....");
		Reporter.log("payment page loaded successfully");
	}
	@Test(priority=8)//confirmation page
	public void click_confirm() throws IOException, InterruptedException
	{
		Confirm_Order  co=new Confirm_Order (driver);
		co.click_confirm();//click confirm
		co.getTitle();
		Thread.sleep(1000);
		System.out.println("confirmation page loaded successfully....");
		Reporter.log("comfirmation page loaded successfully");
	}
	@Test(priority=9)//sign out page
	public void click_sign_out() throws IOException, InterruptedException
	{
		Sign_Out  so=new Sign_Out(driver);
		so.click_signout();//clickin sign out
		so.getTitle();
		Thread.sleep(1000);
		System.out.println("sign-out page loaded successfully....");
		Reporter.log("sign-out page loaded successfully");
	}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
  
  
}
