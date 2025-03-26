package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageF {
	WebDriver driver;

	// constructor
	public LoginPageF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// mandatory
	}

	// locators
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginPageBtn;
	@FindBy(xpath = "//input[@class='email' ]")
	WebElement email;
	@FindBy(xpath = "//input[@class='password' ]")
	WebElement password_loc;
	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement remCheckBox;
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginButton_loc;

	// action methods
	public void clickOnLoginPage() {
		loginPageBtn.click();
	}

	public void enterEmailId() {
		email.sendKeys("yogitha22@gmail.com");
	}

	public void enterPwd() {
		password_loc.sendKeys("fW3D@QH3rtYbts");
	}

	public void clickOnRemCheckBox() {
		remCheckBox.click();
	}

	public void clickOnLoginBtn() {
		loginButton_loc.click();
	}

}