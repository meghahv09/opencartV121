package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups ={"Sanity","Master"})
	public void test_account_registration() {
		logger.info("Starting tetscase *****");
		try{
	
		logger.info("clicked on My account link***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickMyRegister();
		
		logger.info("clicked on registered link****");
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		logger.info("Entering the customer details***");
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+ "@gmail.com" );
		regPage.setTelephone(randomeNumber());
		String password=randomAlphanumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating the message*****");
		String confmsg=regPage.getConfirmationMsg();
		
		AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		
		logger.info("Test passed****");
		}
		catch(Exception e) {
			logger.error("Test failed**" +e.getMessage() );
			//logger.debug("Debug logs");
			AssertJUnit.fail("Test failed****" +e.getMessage());
		}
		
		finally {
			logger.info("***Finished testing");
		}
		
	}


}
