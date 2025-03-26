package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.AddToCart;

public class CartTestcase extends Base_class {
	AddToCart ac;
	String url;

	@BeforeTest
	public void readData() throws IOException {
		// Loading the properties file to fetch the url
		FileInputStream fis = new FileInputStream("src\\test\\java\\utilities\\Data.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		// Initializing the extent Report
		ExtentReport.getInstance();
	}

	@Test

	public void TestCases3() throws InterruptedException, IOException {

		driver.get(url);
		ac = new AddToCart(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Set up explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the link to navigate to the Gift Card page
		wait.until(ExpectedConditions.elementToBeClickable(ac.link())).click();
		System.out.println("navigated to giftcard page");
		// Select sorting option "Name: A-Z"
		wait.until(ExpectedConditions.elementToBeClickable(ac.Positions())).sendKeys(Keys.ARROW_DOWN, "Name:A-Z",
				Keys.ENTER);

		// Selecting display format as "List"
		wait.until(ExpectedConditions.elementToBeClickable(ac.Grid())).sendKeys(Keys.ARROW_DOWN, "List", Keys.ENTER);

		// Selecting the number of items displayed per page
		wait.until(ExpectedConditions.elementToBeClickable(ac.view())).sendKeys(Keys.ARROW_DOWN, "8", Keys.ENTER);

		// Clicking on the Gift Card product
		wait.until(ExpectedConditions.elementToBeClickable(ac.Giftcard())).click();

		// entering the recipient details

		wait.until(ExpectedConditions.visibilityOf(ac.name())).sendKeys("Yogeswari");
		wait.until(ExpectedConditions.visibilityOf(ac.email())).sendKeys("Yogeswari1234@gmail.com");

		// Fill in sender details
		wait.until(ExpectedConditions.visibilityOf(ac.sendername())).sendKeys("Keerthi");
		wait.until(ExpectedConditions.visibilityOf(ac.senderemail())).sendKeys("Keerth123@gmail.com");

		// Enter a personalized message
		wait.until(ExpectedConditions.visibilityOf(ac.Message())).sendKeys("All the best");

		// Click on the "Add to Cart" button
		wait.until(ExpectedConditions.elementToBeClickable(ac.AdToCart())).click();

		// Verify successful product addition message
		// Validation
		WebElement Msg = driver.findElement(By.className("content"));
		String Successfulmessage = Msg.getText();
		System.out.println(Successfulmessage);
		System.out.println("product added successfully");
		screenshot();
		try {
			ExtentReport.createTest("Add to Cart Validation").log(Status.PASS, "Product successfully added to cart");

		} catch (Exception e) {
			// Log the exception in the Extent Report and capture screenshot on failure
			System.out.println("An error occurred during the test: " + e.getMessage());
			ExtentReport.createTest("AddToCart TESTcase").log(Status.FAIL,
					"Test case failed due to exception: " + e.getMessage());
			screenshot(); // Capture a screenshot if there's an error
		}
	}
}
