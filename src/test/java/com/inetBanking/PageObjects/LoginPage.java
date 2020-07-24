package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);

	}
	//Identifying Elements in the loginPage
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement textUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Customised Statement")
	@CacheLookup
	WebElement EditCustomer;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement Logout;
	
	
	
	//Create Action Methods for the above page objects
	
	public void SetUserName(String Uname) {
		textUserName.sendKeys(Uname);
	}
	
	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit() {
		btnLogin.click();
	}
	
	public void EditCustomer() {
		EditCustomer.click();
	}
	public void ClickLogout() {
		Logout.click();
	}
	
}

