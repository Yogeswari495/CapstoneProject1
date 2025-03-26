package stepDef;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Base_class;
import Base.ExtentReport;
import Pages.LoginPageInvalid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login extends Base_class {
	 
	    private LoginPageInvalid loginPage;

	@Given("the user is on LoginPage {string}")
	public void the_user_is_on_login_page(String url) {
		// Ensure browser is initialized
		setup("chrome");
		// Initialize Page Object
		driver.get(url);
		loginPage = new LoginPageInvalid(driver);
		ExtentReport.getInstance();
	}

	@When("the user clicks on login")
	public void the_user_clicks_on_login() {
		loginPage.clickOnLoginPage();
	}

	@When("enters a unique email {string} and password {string}")
	public void enters_a_unique_email_and_password(String email, String Password) {
		loginPage.enterEmailId().sendKeys(email);

		loginPage.enterPwd().sendKeys(Password);
		ExtentReport.createTest("Valid login Test").info("users enters valid credientials");
	}

	@And("clicks the login button")
	public void clicks_the_login_button() {
		loginPage.clickOnLoginBtn();
		
		ExtentReport.createTest("Login test sucessful").pass("Login testcase successfully completed");

	}
	@And("error message is generated")
	public void error_message_is_generated() throws IOException {

	String error =  loginPage.geterrormsg().getText();
	System.out.println(error);
		screenshot();
	}

	}

