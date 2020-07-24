package com.inetBanking.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String UserName = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	

	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br) {
		//System.setProperty("webdriver.chrome.driver","C://Users//v.madapate//eclipse-workspace//NewProjectFramework//inetBankingV1//Drivers//chromedriver.exe" );
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe" );
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		}else if(br.equals("firefox")){
		System.setProperty("webdriver.chrome.driver",readconfig.firefoxPath());
		driver = new FirefoxDriver();
		}
		driver.get(baseURL);
		
		//Add IE condition also
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");
		
	}	
	
	
	@AfterMethod
	 public void captureScreen(ITestResult result) throws IOException
	 {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
	   
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	  }
	   
	 }

		
	@AfterClass
	 void closeBrowser()
	 {
	  driver.quit();
	 } 
	 
	}