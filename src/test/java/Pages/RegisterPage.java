package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	By Register=By.xpath("//a[.='Register']");
	By Gender=By.xpath("//label[.='Female']"); 
	By firstName =By.id("FirstName");
	By LastName =By.id("LastName");
	By email =By.id("Email");
	By PassWord =By.name("Password");
	By cPassword =By.name("ConfirmPassword");
	By RegisterButton=By.id("register-button");
	//action methods
	public WebElement Register () {
		return driver.findElement(Register);
	}
	public WebElement  Gender() {
		return driver.findElement(Gender);
	}
	public WebElement  FirstName() {
		return driver.findElement(firstName);
	}
	public WebElement  LastName() {
		return driver.findElement(LastName);
	}
	public WebElement  email() {
		return driver.findElement(email);
	}
	public WebElement  Password() {
		return driver.findElement(PassWord);
	}
	public WebElement  cPassword(){
		return driver.findElement(cPassword);
	}
	public WebElement  Registerbutton(){
		return driver.findElement(RegisterButton);
	}
}
