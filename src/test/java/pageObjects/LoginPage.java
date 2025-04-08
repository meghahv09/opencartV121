package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement clickLogin;
	
	
	public void txtEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void txtPassword(String password) {
		txtpassword.sendKeys(password);
		
	}
	
	public void btnLogin() {
		clickLogin.click();
	}
	

}
