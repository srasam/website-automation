package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import configurationFiles.ReadProperties;

public class LoadFile 
{
	Properties objpro;
	ReadProperties rp;
	public Properties loadFile() throws IOException
	{
		rp=new ReadProperties();
	String path=System.getProperty("user.dir");
	String excel=rp.Excel();
	try
	{
	//File fi=new File(path+"\\Object Repository\\jpet.properties");
		File fi=new File(path+excel);
	FileInputStream fis=new FileInputStream(fi);
	objpro =new Properties();
	objpro.load(fis);
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return objpro;
	}

}
