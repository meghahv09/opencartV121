package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public  HomePage(WebDriver driver) {
		super(driver);	
		
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement linkMyRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickMyRegister() {
		linkMyRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
}
