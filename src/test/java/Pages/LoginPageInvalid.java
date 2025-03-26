package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageInvalid {
	WebDriver driver;

	public LoginPageInvalid(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By loginPage = By.xpath("//a[@class='ico-login' ]");
	private By emailId = By.xpath("//input[@class='email' ]");
	private By pwd = By.xpath("//input[@class='password' ]");
	private By remCheckBox = By.xpath("//input[@id='RememberMe']");
	private By loginBtn = By.xpath("//input[@class='button-1 login-button']");
            By errorMessage=By.className("message-error");
	// action methods
	public void clickOnLoginPage() {
		driver.findElement(loginPage).click();
	}

	public WebElement enterEmailId() {
		return driver.findElement(emailId);
	}

	public WebElement enterPwd() {
		return driver.findElement(pwd);
	}

	public void clickOnRemCheckBox() {
		driver.findElement(remCheckBox).click();
	}

	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public WebElement geterrormsg() {
		return driver.findElement(errorMessage);
	}
}
