package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base_class;
import Base.ExtentReport;
import Pages.Remove_from_cart;

public class RemoveCart_testcase extends Base_class {

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

	public void Remove_Cart() throws InterruptedException, IOException {
		// invoking the browser with specified parameter

		driver.get(url);// navigating to url
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Remove_from_cart rc = new Remove_from_cart(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the link to navigate to the Gift Card page
		wait.until(ExpectedConditions.elementToBeClickable(rc.link())).click();
		System.out.println("navigated to giftcard page");
		// Select sorting option "Name: A-Z"
		wait.until(ExpectedConditions.elementToBeClickable(rc.Positions())).sendKeys(Keys.ARROW_DOWN, "Name:A-Z",Keys.ENTER);

		// Selecting display format as "List"
		wait.until(ExpectedConditions.elementToBeClickable(rc.Grid())).sendKeys(Keys.ARROW_DOWN, "List", Keys.ENTER);

		// Selecting the number of items displayed per page
		wait.until(ExpectedConditions.elementToBeClickable(rc.view())).sendKeys(Keys.ARROW_DOWN, "8", Keys.ENTER);

		// Clicking on the Gift Card product
		wait.until(ExpectedConditions.elementToBeClickable(rc.Giftcard())).click();

		// entering the recipient details

		wait.until(ExpectedConditions.visibilityOf(rc.name())).sendKeys("Yogeswari");
		wait.until(ExpectedConditions.visibilityOf(rc.email())).sendKeys("Yogeswari1234@gmail.com");

		// Fill in sender details
		wait.until(ExpectedConditions.visibilityOf(rc.sendername())).sendKeys("Keerthi");
		wait.until(ExpectedConditions.visibilityOf(rc.senderemail())).sendKeys("Keerth123@gmail.com");

		// Enter a personalized message
		wait.until(ExpectedConditions.visibilityOf(rc.Message())).sendKeys("All the best");

		// Click on the "Add to Cart" button
		wait.until(ExpectedConditions.elementToBeClickable(rc.AdToCart())).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(rc.shoppingLink())).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(rc.remove())).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(rc.update())).click();
	}

}
