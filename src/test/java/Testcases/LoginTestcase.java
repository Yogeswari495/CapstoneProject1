package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.LoginPageF;

public class LoginTestcase extends Base_class {

	public static String url;

	@BeforeTest
	// Method to read data from properties file
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\java\\utilities\\Data.Properties");
		Properties prop = new Properties();// Properties Object to load data
		prop.load(fis);// Load Properties file data
		url = prop.getProperty("url");
		ExtentReport.getInstance();// intializing the extenReport
	}

	@Test

	public void loginTest() throws InterruptedException, IOException {
		// invoking the browser with specified parameter

		driver.get(url);// navigating to url
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageF lp = new LoginPageF(driver);
		lp.clickOnLoginPage();// clicking on login page link
		Thread.sleep(1000);
		lp.enterEmailId();// entering the email
		Thread.sleep(1000);
		lp.enterPwd();// entering the password
		Thread.sleep(1000);
		lp.clickOnRemCheckBox();// clicking on the checkbox
		Thread.sleep(1000);
		lp.clickOnLoginBtn();// By clicking on the login button it will navigate to loginpage
		Thread.sleep(1000);
	
    	screenshot();
//		try {
//			ExtentReport.createTest("Login Test Validation").log(Status.PASS,
//					"Login validation completed successfully");
//		} catch (Exception e) {
//			// Log failure in Extent Report and capture screenshot
//			System.out.println("An error occurred during login test: " + e.getMessage());
//			ExtentReport.createTest("Login Test Failure").log(Status.FAIL,
//					"Login test failed due to exception: " + e.getMessage());
//			screenshot(); // Capture screenshot on failure
		}
	}

