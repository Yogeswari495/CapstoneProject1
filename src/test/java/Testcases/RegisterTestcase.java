package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.RegisterPage;

public class RegisterTestcase extends Base_class {
	RegisterPage rp;
	String url;

	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\java\\utilities\\Data.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");

		ExtentReport.getInstance();
	}

	@Test

	public void TestCases1() throws InterruptedException, IOException {
	
		driver.get(url);
		rp = new RegisterPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Perform actions with explicit waits instead of Thread.sleep()

		// Wait for the Register link to be clickable and click on it
		wait.until(ExpectedConditions.elementToBeClickable(rp.Register())).click();

		// Wait for the Gender radio button to be clickable and click on it
		wait.until(ExpectedConditions.elementToBeClickable(rp.Gender())).click();

		// Wait for the First Name field to be visible and enter data
		wait.until(ExpectedConditions.visibilityOf(rp.FirstName())).sendKeys("Yogeswari");
		wait.until(ExpectedConditions.visibilityOf(rp.LastName())).sendKeys("Yalamilli");
        wait.until(ExpectedConditions.visibilityOf(rp.email())).sendKeys("Yogeswari@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(rp.Password())).sendKeys("Yogeswari1234");
        wait.until(ExpectedConditions.visibilityOf(rp.cPassword())).sendKeys("Yogeswari1234");
		// Wait for the Register button to be clickable and click on it
		wait.until(ExpectedConditions.elementToBeClickable(rp.Registerbutton())).click();

		// Capture screenshot after successful registration
		screenshot();

		// Handle Extent Report logging with exception handling
		try {
			ExtentReport.createTest("Registration Validation").log(Status.PASS, "Registration successfully completed");
		} catch (Exception e) {
			// Log failure in Extent Report and take a failure screenshot
			System.out.println("An error occurred during the registration test: " + e.getMessage());
			ExtentReport.createTest("Register TESTcase").log(Status.FAIL,
					"Registration test failed due to exception: " + e.getMessage());
			screenshot(); // Capture screenshot on failure
		} 
	}
}


