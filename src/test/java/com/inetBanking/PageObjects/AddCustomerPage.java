package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify all the elements which are present in the New Customer Page
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement txtsub;
	
	//For all above elements write action class
	
	public void ClickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void CustName(String Cname) {
		txtCustomerName.sendKeys(Cname);
				
	}
	
	public void Custgender(String Cgender) {
		rGender.click();
	}
	
	public void Custdob(String mm,String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void Custaddress(String Caddress) {
		txtaddress.sendKeys(Caddress);
	}
	
	public void Custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void CustState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custpinon(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);			
	}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		txtsub.click();
	}	
	

}
