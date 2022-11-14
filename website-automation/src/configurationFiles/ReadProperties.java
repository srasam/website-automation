package configurationFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadProperties 
{
	Properties objpro;
	public ReadProperties() throws IOException 
	{
		String path=System.getProperty("user.dir");
		File fi=new File(path+"\\Object Repository\\jpet.properties");
		FileInputStream fis=new FileInputStream(fi);
		
		objpro =new Properties();
		objpro.load(fis);
		
	}
	
//drivers
	public String getEdgeDriver()
	{
		return objpro.getProperty("EDGEDRIVER");
		
	}
	
	public String FireFoxDriver()
	{
		return objpro.getProperty("FIREFOX");
		
	}
	public String Url()
	{
		return objpro.getProperty("URL");
		
	} 
	public String Excel()
	{
		return objpro.getProperty("EXCEL");
	}
	
	public String EnterStore()
	{
		return objpro.getProperty("CLICKSTORE");
		
	}
	public String Signin()
	{
		return objpro.getProperty("CLICKSIGNIN");
	}
	//Dog from Left Module
	public String clickDog()
	{
		return objpro.getProperty("LEFTDOG");
	}
	public String clickDogProduct()
	{
		return objpro.getProperty("LEFTDOGPRODUCTID");
	}
	public String clickDogItemId()
	{
		return objpro.getProperty("LEFTDOGITEMID");
	}
	//fish from left module
	public String clickFish()
	{
		return objpro.getProperty("LEFTFISH");
	}
	public String clickFishProduct()
	{
		return objpro.getProperty("LEFTFISHPRODUCTID");
	}
	public String clickFishItemId()
	{
		return objpro.getProperty("LEFTFISHITEMID");
	}
	//Reptiles image
	public String clickReptile()
	{
		return objpro.getProperty("REPTILEIMAGE");
	}
	public String clickReptileProduct()
	{
		return objpro.getProperty("REPTILEPRODUCTID");
	}
	public String clickReptileItemId()
	{
		return objpro.getProperty("REPTILESITEMID");
	}
	//Cats image
	public String clickCat()
	{
		return objpro.getProperty("CATIMAGE");
	}
	public String clickCatProduct()
	{
		return objpro.getProperty("CATPRODUCTID");
	}
	public String clickCatItemId()
	{
		return objpro.getProperty("CATITEMID");
	}
	//Birds from top module
	public String clickBirds()
	{
		return objpro.getProperty("SELECTBIRD");
	}
	public String clickBirdProduct()
	{
		return objpro.getProperty("BIRDPRODUCTID");
	}
	public String clickBirdItemId()
	{
		return objpro.getProperty("BIRDITEMID");
	}
	//Top Module Dog
	public String clickTopDog()
	{
		return objpro.getProperty("SELECTDOG");
	}
	public String clickTopDogProduct()
	{
		return objpro.getProperty("DOGPRODUCTID");
	}
	public String clickTopDogItemId()
	{
		return objpro.getProperty("DOGITEMID");
	}
	//Registration
	public String register()
	{
		return objpro.getProperty("REGISTER");
	}
	public String username()
	{
		return objpro.getProperty("USERNAME");
	}
	public String password()
	{
		return objpro.getProperty("PASSWORD");
	}
	public String repeat_password()
	{
		return objpro.getProperty("REPEATPASSWORD");
	}
	public String firstname()
	{
		return objpro.getProperty("FIRSTNAME");
	}
	public String lastname()
	{
		return objpro.getProperty("LASTNAME");
	}
	public String email()
	{
		return objpro.getProperty("EMAIL");
	}
	public String phone()
	{
		return objpro.getProperty("PHONE");
	}
	public String address1()
	{
		return objpro.getProperty("ADDRESS1");
	}
	public String address2()
	{
		return objpro.getProperty("ADDRESS2");
	}
	public String city()
	{
		return objpro.getProperty("CITY");
	}
	public String state()
	{
		return objpro.getProperty("STATE");
	}
	public String zip()
	{
		return objpro.getProperty("ZIP");
	}
	public String country()
	{
		return objpro.getProperty("COUNTRY");
	}
	public String saveDetails()
	{
		return objpro.getProperty("SAVEDETAILS");
	}
	public String clickLogin()
	{
		return objpro.getProperty("CLICKLOGIN");
	}
	
	
	//click search icon
	public String search()
	{
		return objpro.getProperty("CLICKSEARCH");
	}
	//click cart icon 
	public String cart()
	{
		return objpro.getProperty("CLICKCART");
	}
	
	public String AddToCart()
	{
		return objpro.getProperty("ADDTOCART");
	}
	public String checkout()
	{
		return objpro.getProperty("CHECKOUT");
	}
	public String clickContinue()
	{
		return objpro.getProperty("CLICKCONTINUE");
	}
	public String paymentContinue()
	{
		return objpro.getProperty("CONTINUE");
	}
	
	public String clickConfirm()
	{
		return objpro.getProperty("CLICKCONFIRM");
	}
	public String ClickSubmit()
	{
		return objpro.getProperty("CLCIKSUBMIT");
	}
	public String Sign_out()
	{
		return objpro.getProperty("CLICKSIGNOUT");
	}
	//VERIFY
	public String VerifyFishText()
	{
		return objpro.getProperty("FISHPRODUCT_TEXT");//linktext
	}
	
	
	
	
	
}
