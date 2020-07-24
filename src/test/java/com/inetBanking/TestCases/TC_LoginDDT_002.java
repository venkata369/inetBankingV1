package com.inetBanking.TestCases;

import java.io.IOException;

//import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	//Write Test Methods & Data Provider
	
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String Uname, String pwd) throws InterruptedException {
		//Here call Login Username & Password from LoginPage class
		LoginPage LP = new LoginPage(driver);
		//driver.get(baseURL);
		logger.info("URL is Opened");
		LP.SetUserName(Uname);
		logger.info("Entered UserName");
		logger.info("Entered UserName");
		LP.SetPassword(pwd);
		logger.info("Entered Password");
		logger.info("Entered Password");
		LP.ClickSubmit();
		LP.EditCustomer();
		
		Thread.sleep(3000);
		
		if(isAlertPresents()==true) {
			
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false); //To do this because failure condition i.e. Invalid username & pwd.
			logger.info("Login Faild due to invalid username and Password");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login valid username and Password-PASS");
			LP.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
			
		}
		
	}
	
	public boolean isAlertPresents() {
		try {
			driver.switchTo().alert();
			return true;
			}
			catch(Exception e) {
				return false;
				
			}
	}

	//Data provider provides data to the Test method
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		XLUtils XLUtils = new XLUtils();
		//Get the data from excel sheet and store in two-dimensional
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/LoginData.xlsx";
		//Here use XLUtils.java methods
		//Read the Excel data and count number of rows and columns 
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		//Get the Cell count each row
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		//Store two dimensional Array
		String logindata[][]=new String[rownum][colcount];
		//for loop to get the data
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;		
	}
	

}
