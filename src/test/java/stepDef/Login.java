package stepDef;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Base.Base_class;
import Base.ExtentReport;
import Pages.LoginPageF;
import Pages.LoginPageValid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Base_class {
	 
	    private LoginPageValid loginPage;

	@Given("the user is on LoginPage {string}")
	public void the_user_is_on_login_page(String url) {
		// Ensure browser is initialized
		setup("chrome");
		// Initialize Page Object
		driver.get(url);
		loginPage = new LoginPageValid(driver);
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

}
