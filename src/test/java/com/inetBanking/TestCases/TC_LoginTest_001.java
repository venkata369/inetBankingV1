package com.inetBanking.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void LoginTest() {
		
		
		// Get user name and Password from LoginPage class
		//driver.get(baseURL);
		logger.info("URL is Opened");
		
		LoginPage LP = new LoginPage(driver);
		LP.SetUserName(UserName);
		logger.info("Entered UserName");
		LP.SetPassword(Password);
		logger.info("Entered Password");
		LP.ClickSubmit();
		//to know the title of webpage
		//String title = driver.getTitle();
		//System.out.println(title);
				
	if(driver.getTitle().contains("Guru99 Bank Manager HomePage"))
			
		{
			
			Assert.assertTrue(true);
			logger.info("Login Test PASS");
			
		}
		else {
			captureScreen(driver,"LoginTest");
			logger.info("Login Test FAIL");
			Assert.assertTrue(false);
			
			
					
			
			
		}
		
		
	}

	private void captureScreen(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}
	}

	

	

