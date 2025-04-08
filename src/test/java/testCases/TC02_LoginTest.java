package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;



public class TC02_LoginTest extends BaseClass {
	@Test(groups={"Regression","Master"})
	public void verifyLogin() {
		try {
		logger.info("Logging in******");
		HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		logger.info("Logging the page***");
		lp.txtEmail(p.getProperty("email"));
		lp.txtPassword(p.getProperty("password"));
		lp.btnLogin();
		
		logger.info("My account page*****");
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true,"Login failed");
		}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("Login test finished****");
		
	}
	
	
	
	
	
	

}
