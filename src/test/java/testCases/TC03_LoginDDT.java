package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="Datadriven")
	public void verifyLoginDDT(String email,String pwd,String exp) {
		
		logger.info("Logging into application using Dataprovider***");
		try {
HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		logger.info("Logging the page***");
		lp.txtEmail(email);
		lp.txtPassword(pwd);
		lp.btnLogin();
		
		logger.info("My account page*****");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true,"Login failed");
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
			
			macc.clickLogout();
			Assert.assertTrue(true);
		}
			else {
				Assert.assertTrue(false);
			}
			
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
	logger.info("Finished the Login Test ******");
	}
	
	

}
