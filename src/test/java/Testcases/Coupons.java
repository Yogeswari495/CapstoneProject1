package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.Applying_discount_couponsPageFactory;

public class Coupons extends Base_class {

	public static String url;

	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\java\\utilities\\Data.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		ExtentReport.getInstance();
	}

	@Test
	public void coupons() throws IOException, InterruptedException {
		driver.get(url);

		// FluentWait setup: Polling every 500ms, timeout after 15 seconds
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(15))//maximum wait time
				.pollingEvery(Duration.ofMillis(500))//frequency polling
				.ignoring(NoSuchElementException.class);// ignores specific exception
		Applying_discount_couponsPageFactory adc = new Applying_discount_couponsPageFactory(driver);

		// Navigating through elements with FluentWait
		wait.until(webDriver -> {
			adc.giftcard();
			return true;
		});

		wait.until(webDriver -> {
			adc.order();
			return true;
		});

		wait.until(webDriver -> {
			adc.view();
			return true;
		});

		wait.until(webDriver -> {
			adc.size();
			return true;
		});

		wait.until(webDriver -> {
			adc.selectgiftcard();
			return true;
		});

		wait.until(webDriver -> {
			adc.rec_name();
			return true;
		});

		wait.until(webDriver -> {
			adc.rec_email();
			return true;
		});

		wait.until(webDriver -> {
			adc.sender_name();
			return true;
		});

		wait.until(webDriver -> {
			adc.sender_email();
			return true;
		});

		wait.until(webDriver -> {
			adc.message();
			return true;
		});

		wait.until(webDriver -> {
			adc.addtocart();
			return true;
		});
         Thread.sleep(5000);		// Waiting longer for potential pop-ups or banners to disappear
		wait.until(webDriver -> {
			adc.shoping_links();
			return true;
		});

		wait.until(webDriver -> {
			adc.entercoupons();
			return true;
		});

		wait.until(webDriver -> {
			adc.click_coupon();
			return true;
		});

		// Capturing the error message
		WebElement errorMsg = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.className("message"));
			}
		});

		String error = errorMsg.getText();
		System.out.println(error);
		screenshot();

		try {
			ExtentReport.createTest("Login Test Validation").log(Status.PASS,
					"Login validation completed successfully");
		} catch (Exception e) {
			System.out.println("An error occurred during login test: " + e.getMessage());
			ExtentReport.createTest("Login Test Failure").log(Status.FAIL,
					"Login test failed due to exception: " + e.getMessage());
			screenshot();
		}
	}
}
