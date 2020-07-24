package com.inetBanking.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException {
		//Use two page object class LoginPage and AddCustomerPage
		//driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(UserName);
		logger.info("Entered UserName");
		lp.SetPassword(Password);
		logger.info("Entered Password");
		lp.ClickSubmit();
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Ading Customer details");
		addcust.ClickAddNewCustomer();
		addcust.CustName("Venkat");
		addcust.Custgender("male");
		addcust.Custdob("10", "15","1985");
		Thread.sleep(3000);
		addcust.Custaddress("INDIA");
		addcust.Custcity("HYD");
		addcust.CustState("AP");
		addcust.custpinon("500074");
		addcust.custtelephoneno("8884868359");
		//Here make email address is dynamic
		String email = randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdefgh");
		
		addcust.custsubmit();
		logger.info("Successfully Added Customer Details");
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Login Test Add Customer details PASS");
		}
		else {
			logger.info("Login Test FAIL");
			Assert.assertTrue(false);
			
		}
		
	}
		
		
		


		//create user defined method for random email
		public String randomString() {
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return (generatedString);
			
		}
		public String randomNumber() {
			String generatedString1 = RandomStringUtils.randomNumeric(4);
			return (generatedString1);
			
		}
		
		
	}


